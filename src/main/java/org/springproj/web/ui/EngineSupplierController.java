package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springproj.model.EngineSupplier;
import org.springproj.service.EngineSupplierService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class EngineSupplierController {

    private final EngineSupplierService engineSupplierService;


    @GetMapping("/engineSuppliers")
    public String getEngineSuppliers(
            Model model,
            @RequestParam(value = "name", required = false) String name
    ) {
        if (name == null) {
            List<EngineSupplier> engineSuppliers = engineSupplierService.findAll();
            model.addAttribute("engineSuppliers", engineSuppliers);
            return "engineSupsView";
        }

        else {
            List<EngineSupplier> engineSuppliers = new ArrayList<>(1);
            engineSuppliers.add(engineSupplierService.findByName(name));
            model.addAttribute("engineSuppliers", engineSuppliers);
            return "general/engineSupsView";
        }

    }


}
