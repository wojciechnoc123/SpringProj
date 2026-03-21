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
import org.springproj.model.GrandPrix;
import org.springproj.service.SeasonService;
import org.springproj.model.Season;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class SeasonController {

    private final SeasonService seasonService;

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
        model.addAttribute("races", races);
        return "seasons/calendarView";
    }

    @GetMapping("/seasons/{year}/entryList")
    public String getEntryList(
            Model model,
            @PathVariable String year
    ) {
        return "seasons/entryView";
    }

    @GetMapping("seasons/{year}/standings")
    public String getStandings(
            Model model,
            @PathVariable String year
    ) {
        return "seasons/standingsView";
    }

}
