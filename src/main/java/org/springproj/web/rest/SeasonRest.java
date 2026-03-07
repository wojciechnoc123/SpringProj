package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springproj.model.*;
import org.springproj.service.SeasonService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class SeasonRest {

    private final SeasonService seasonService;

    @GetMapping("/printSeasons")
    String printAllSeasonsString() {
        return seasonService.printAllSeasonsString();
    }

    @GetMapping("/seasons")
    List<Season> getSeasons() {
        return this.seasonService.getAllSeasons();
    }

    @GetMapping("/drivers")
    List<Driver> getDrivers() {
        return this.seasonService.getAllDrivers();
    }

    @GetMapping("/teams")
    List<Team> getTeams() {
        return this.seasonService.getAllTeams();
    }

    @GetMapping("/driverEntries/2026")
    List<DriverEntry> getDriverEntries() {
        return this.seasonService.getAllDriverEntries();
    }

    @GetMapping("/teamEntries/2026")
    List<TeamEntry> getTeamEntries() {
        return this.seasonService.getAllTeamEntries();
    }

    @GetMapping("/engines/2026")
    List<Engine> getAllEngines() {
        return this.seasonService.getAllEngines();
    }

    @GetMapping("/engineSuppliers")
    List<EngineSupplier> getAllEngineSuppliers() {
        return this.seasonService.getAllEnginesSuppliers();
    }


}
