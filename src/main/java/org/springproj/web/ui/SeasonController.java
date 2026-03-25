package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springproj.model.*;
import org.springproj.service.SeasonService;
import org.springframework.ui.Model;
import org.springproj.service.StandingsService;
import org.springproj.web.dto.DriverEntryPointsDTO;

import org.springproj.web.dto.TeamEntryPointsDTO;

import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class SeasonController {

    private final SeasonService seasonService;
    private final StandingsService standingsService;



    @GetMapping("/seasons")
    public String getSeasons(
            Model model,
            @RequestParam(value = "year", required = false) String year
    ) {
        List<Season> seasons;
        if (year != null) {
            seasons = new ArrayList<>(1);
            seasons.add(seasonService.findByYear(year));
        }
        else {
            seasons = seasonService.findAll();

        }
        model.addAttribute("seasons", seasons);
        return "seasons/seasonsList";
    }

    @GetMapping("/seasons/{year}")
    public String getSeason(
            Model model,
            @PathVariable String year
    ){
        Season season = seasonService.findByYear(year);
        model.addAttribute("yearSeason",year);
        return "/seasons/seasonView";
    }

    @GetMapping("/seasons/{year}/calendar")
    public String getCalendar(
            Model model,
            @PathVariable String year
    ) {
        List<GrandPrix> races = seasonService.findByYear(year).getGrandPrixes();
        model.addAttribute("year", year);
        model.addAttribute("races", races);
        return "seasons/calendarView";
    }

    @GetMapping("/seasons/{year}/entryList")
    public String getEntryList(
            Model model,
            @PathVariable String year
    ) {
        model.addAttribute("year", year);
        Season season = seasonService.findByYear(year);
        List<TeamEntry> teamEntries = season.getTeams();
        model.addAttribute("entries", teamEntries);
        return "seasons/entryView";
    }
    /*
        REFACTOR SO CODE DOESN'T CUPLICATE
    */
    /*
        CONSIDER MOVING LOGIC TO SOME SERVICE OR SOMETHING
     */
    @GetMapping("seasons/{year}/driverStandings")
    public String getDriverStandings(
            Model model,
            @PathVariable String year
    ) {
        model.addAttribute("year", year);
        List<GrandPrix> races = seasonService.findByYear(year).getGrandPrixes();
        final int numberOfRaces = races.size();
        model.addAttribute("races", races);
        List<DriverEntry> drivers = seasonService.findByYear(year).getDrivers();
        final int numberOfDrivers = drivers.size();
        List<DriverEntryPointsDTO> finalDrivers = new ArrayList<>(numberOfDrivers);
        for (int i = 0; i < numberOfDrivers; i++) {
            DriverEntry driverToAdd = drivers.get(i);
            DriverEntryPointsDTO fullInfoDriver = new DriverEntryPointsDTO(driverToAdd, numberOfRaces);
            standingsService.calculatePointsAndSetPositions(fullInfoDriver, races);
            finalDrivers.add(fullInfoDriver);
        }
        var sortedFinalDrivers = finalDrivers.stream().sorted(Comparator.comparingInt(DriverEntryPointsDTO::getPoints).reversed()).toList();
        model.addAttribute("finalDrivers", sortedFinalDrivers);
        return "seasons/driverStandingsView";
    }

    @GetMapping("seasons/{year}/teamStandings")
    public String getTeamStandings(
            Model model,
            @PathVariable String year
    ) {
        model.addAttribute("year", year);
        List<GrandPrix> races = seasonService.findByYear(year).getGrandPrixes();
        final int numberOfRaces = races.size();
        model.addAttribute("races", races);
        List<DriverEntry> drivers = seasonService.findByYear(year).getDrivers();
        final int numberOfDrivers = drivers.size();
        List<DriverEntryPointsDTO> finalDrivers = new ArrayList<>(numberOfDrivers);
        for (int i = 0; i < numberOfDrivers; i++) {
            DriverEntry driverToAdd = drivers.get(i);
            DriverEntryPointsDTO fullInfoDriver = new DriverEntryPointsDTO(driverToAdd, numberOfRaces);
            standingsService.calculatePointsAndSetPositions(fullInfoDriver, races);
            finalDrivers.add(fullInfoDriver);
        }
        List<TeamEntry> teams = seasonService.findByYear(year).getTeams();
        final int numberOfTeams = teams.size();
        List<TeamEntryPointsDTO> finalTeams = new ArrayList<>(numberOfTeams);
        for (int teamIndex = 0; teamIndex < numberOfTeams; teamIndex++) {
            finalTeams.add(new TeamEntryPointsDTO(teams.get(teamIndex)));
        }
        for (int teamIndex = 0; teamIndex < numberOfTeams; teamIndex++) {
            var finalTeam = finalTeams.get(teamIndex);
            for (int driverIndex = 0; driverIndex < numberOfDrivers; driverIndex++) {
                var finalDriver = finalDrivers.get(driverIndex);
                if (finalTeam.getTeamEntry().equals(finalDriver.getDriverEntry().getTeam())) {
                    if (finalTeam.getFirstDriverEntry() == null)
                        finalTeam.setFirstDriverEntry(finalDriver);
                    else if (finalTeam.getSecondDriverEntry() == null) {
                        finalTeam.setSecondDriverEntry(finalDriver);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        for (var finalTeam : finalTeams) {
            finalTeam.sumPoints();
        }
        var sortedFinalTeams = finalTeams.stream().sorted(Comparator.comparingInt(TeamEntryPointsDTO::getPoints).reversed()).toList();
        model.addAttribute("teams", sortedFinalTeams);
        return "seasons/teamStandingsView";
    }

}
