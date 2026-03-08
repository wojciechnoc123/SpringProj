package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springproj.model.*;
import org.springproj.service.GeneralService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi/test")
public class GeneralTestRest {

    private final GeneralService generalService;

    @GetMapping("/printSeasons")
    String printAllSeasonsString() {
        return generalService.printAllSeasonsString();
    }

    @GetMapping("/seasons")
    List<Season> getSeasons() {
        return this.generalService.getAllSeasons();
    }

    @GetMapping("seasons/{id}")
    Season getSeason(@PathVariable int id) {
        return this.generalService.getSeasonById(id);
    }

    @GetMapping("/drivers")
    List<Driver> getDrivers() {
        return this.generalService.getAllDrivers();
    }

    @GetMapping("/teams")
    List<Team> getTeams() {
        return this.generalService.getAllTeams();
    }

    @GetMapping("/driverEntries/2026")
    List<DriverEntry> getDriverEntries() {
        return this.generalService.getAllDriverEntries();
    }

    @GetMapping("/teamEntries/2026")
    List<TeamEntry> getTeamEntries() {
        return this.generalService.getAllTeamEntries();
    }

    @GetMapping("/engines/2026")
    List<Engine> getAllEngines() {
        return this.generalService.getAllEngines();
    }

    @GetMapping("/engineSuppliers")
    List<EngineSupplier> getAllEngineSuppliers() {
        return this.generalService.getAllEnginesSuppliers();
    }


}
