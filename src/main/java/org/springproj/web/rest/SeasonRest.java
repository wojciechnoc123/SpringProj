package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;
import org.springproj.service.DriverEntryService;
import org.springproj.service.TeamEntryService;
import org.springproj.model.Driver;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class SeasonRest {

    private final DriverEntryService driverEntryService;
    private final TeamEntryService teamEntryService;

    @GetMapping("/driverEntries/{id}/teamEntry")
    public ResponseEntity<TeamEntry> getTeamEntryWithDriverEntry(@PathVariable int id) {
        DriverEntry driverEntry = driverEntryService.findById(id);
        if (driverEntry == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(teamEntryService.findByDriverEntry(driverEntry));
    }



}
