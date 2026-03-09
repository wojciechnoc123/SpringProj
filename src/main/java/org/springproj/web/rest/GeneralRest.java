package org.springproj.web.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springproj.service.DriverService;
import org.springproj.model.Driver;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class GeneralRest {

    private final DriverService driverService;

    @GetMapping("/driver")
    public ResponseEntity<Driver> getDriver(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestHeader(value = "custom-header", required = false) String customHeader
    ) {
        log.info(customHeader);
        Driver driver = driverService.findByName(firstName, lastName);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(driver);
        }
    }

    @PostMapping("/drivers")
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        //machen walidacja
        log.info("creating driver");
       return ResponseEntity.status(HttpStatus.CREATED).body(driverService.saveDriver(driver));
    }

}
