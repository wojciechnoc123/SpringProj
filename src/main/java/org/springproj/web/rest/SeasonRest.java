package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springproj.model.Driver;
import org.springproj.model.Season;
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


}
