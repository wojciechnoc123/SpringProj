package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springproj.model.Circuit;
import org.springproj.model.enums.ReturnType;
import org.springproj.service.CircuitService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class CircuitController {

    private final CircuitService circuitService;

    @GetMapping("/circuits")
    public String getCircuits(
            Model model,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "location", required = false) String location
    ) {
        //przeniesc do serwisu logike
        //wszystko na streamach zrobic
        ReturnType rt = ReturnType.ALL;
        Circuit circuitToAdd;
        List<Circuit> circuits = new ArrayList<>(0);
        if (name != null) {
             circuitToAdd = circuitService.findByName(name);
             if (circuitToAdd != null) {
                 rt = ReturnType.FOUND;
                 circuits = new ArrayList<>(1);
                 circuits.add(circuitToAdd);
             }
             else {
                 rt = ReturnType.NOTFOUND;
             }
        }
        if (location != null) {
            if (rt == ReturnType.ALL) {
                circuits = circuitService.findAll().stream().filter(c -> c.getLocation().equals(location)).toList();
                rt = ReturnType.FOUND;
            }
            else if (rt == ReturnType.FOUND) {
                circuits = circuits.stream().filter(c -> c.getLocation().equals(location)).toList();

            }
        }
        if (country != null) {
            if (rt == ReturnType.ALL) {
                circuits = circuitService.findAll().stream().filter(c -> c.getCountry().equals(country)).toList();
                rt = ReturnType.FOUND;
            }
            else if(rt == ReturnType.FOUND) {
                circuits = circuits.stream().filter(c -> c.getCountry().equals(country)).toList();
            }
        }
        if (rt == ReturnType.ALL) {
            circuits = circuitService.findAll();
        }

        model.addAttribute("circuits", circuits);
        return "general/circuitsView";
    }

}
