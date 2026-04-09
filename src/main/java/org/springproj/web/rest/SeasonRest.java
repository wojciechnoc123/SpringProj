package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springproj.model.DriverEntry;
import org.springproj.model.TeamEntry;
import org.springproj.service.DriverEntryService;
import org.springproj.service.DriverService;
import org.springproj.service.TeamEntryService;
import org.springproj.web.dto.DriverEntryGetDTO;
import org.springproj.web.dto.DriverEntryPostDTO;
import org.springproj.web.dto.TeamEntryDTO;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class SeasonRest {

    private final DriverEntryService driverEntryService;
    private final TeamEntryService teamEntryService;
    private final DriverService driverService;

    @GetMapping("/driverEntries/{driverEntryId}/teamEntry")
    public ResponseEntity<TeamEntryDTO> getTeamEntryWithDriverEntry(@PathVariable("driverEntryId") int id) {
        log.info("Getting team entry from driver entry:" + id);
        DriverEntry driverEntry = driverEntryService.findById(id);
        if (driverEntry == null)
            return ResponseEntity.notFound().build();
        else {
            TeamEntry teamEntry = teamEntryService.findByDriverEntry(driverEntry);
            TeamEntryDTO teamEntryDTO = new TeamEntryDTO();
            teamEntryDTO.setTeam(teamEntry.getTeam());
            teamEntryDTO.setEngine(teamEntry.getEngine());
            teamEntryDTO.setChassisName(teamEntry.getChassisName());
            return ResponseEntity.ok(teamEntryDTO);
        }

    }

    @PostMapping("/driverEntries")
    public ResponseEntity<?> saveDriverEntry(@RequestBody DriverEntryPostDTO driverEntryPostDTO, Authentication authentication) {

        DriverEntry driverEntry = new DriverEntry();
        driverEntry.setDriver(driverService.findById(driverEntryPostDTO.getDriverId()));
        driverEntry.setTeam(teamEntryService.findById(driverEntryPostDTO.getTeamEntryId()));
        driverEntry.setNumber(driverEntryPostDTO.getNumber());
        if (driverEntry.getDriver() == null || driverEntry.getTeam() == null) {
            return ResponseEntity.notFound().build();
        }
        log.info("authenticated user {}", authentication.getName());
        DriverEntry savedDriverEntry = driverEntryService.saveDriverEntry(driverEntry);
        DriverEntryGetDTO driverEntryGetDTO = new DriverEntryGetDTO();
        driverEntryGetDTO.setDriver(savedDriverEntry.getDriver());
        driverEntryGetDTO.setTeamName(savedDriverEntry.getTeam().getTeam().getName());
        driverEntryGetDTO.setNumber(savedDriverEntry.getNumber());
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequestUri().
                path("/" + savedDriverEntry.getId())
                .build()
                .toUri())
                .body(driverEntryGetDTO);
    }



}
