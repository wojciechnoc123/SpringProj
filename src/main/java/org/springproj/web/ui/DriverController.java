package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springproj.service.DriverService;

import java.util.ArrayList;
import java.util.List;
import org.springproj.model.Driver;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/drivers")
     String getDrivers(
             Model model,
             @RequestParam(value = "driverId", required = false) Integer driverId
    ) {
        log.info("Returning drivers view");
        if (driverId == null) {
            List<Driver> drivers = driverService.findAllDrivers();
            model.addAttribute("drivers", drivers);
        }
        else {
            List<Driver> drivers = new ArrayList<>(1);
            drivers.add(driverService.findById(driverId));
            model.addAttribute("drivers", drivers);
        }
        return "general/driversView";
    }
    //

}
