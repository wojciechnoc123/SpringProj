package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/driverEntries")
    List<DriverEntry> getDriverEntries() {
        return this.generalService.getAllDriverEntries();
    }

    @GetMapping("/teamEntries")
    List<TeamEntry> getTeamEntries() {
        return this.generalService.getAllTeamEntries();
    }

    @GetMapping("/engines")
    List<Engine> getAllEngines() {
        return this.generalService.getAllEngines();
    }

    @GetMapping("/engineSuppliers")
    List<EngineSupplier> getAllEngineSuppliers() {
        return this.generalService.getAllEnginesSuppliers();
    }

    @GetMapping("teams/{id}")
    ResponseEntity<Team> getTeamById(@PathVariable int id) {
        log.info("Retrieving team");
        Team teamToReturn = this.generalService.getTeamById(id);

        if (teamToReturn != null) {
            return ResponseEntity.status(200).body(teamToReturn);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    /*
    @GetMapping("drivers/{id}")
    Driver getDrivers(@PathVariable int id) {
        Driver driverToReturn = this.generalService.getDriverById(id);
        return driverToReturn;
    }
    */

    @GetMapping("drivers/{id}")
    ResponseEntity<Driver> getDrivers(@PathVariable int id) {
        Driver driverToReturn = this.generalService.getDriverById(id);
        if (driverToReturn != null) {
            return ResponseEntity.status(HttpStatus.OK).body(driverToReturn);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
