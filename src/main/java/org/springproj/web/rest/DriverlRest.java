package org.springproj.web.rest;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springproj.service.DriverService;
import org.springproj.model.Driver;

import java.util.Locale;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class DriverlRest {

    private final DriverService driverService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;


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
    public ResponseEntity<?> createDriver(@Validated  @RequestBody Driver driver, Errors errors, HttpServletRequest request) {
        //machen walidacja
        log.info("creating driver");

        if (errors.hasErrors()) {
            Locale locale1 = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(objectError -> messageSource.getMessage(objectError.getCode(), new Object[0], locale1))
                    .reduce("errors:\n", (accu, objectError)-> accu + objectError + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
       return ResponseEntity.status(HttpStatus.CREATED).body(driverService.saveDriver(driver));
    }

}
