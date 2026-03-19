package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springproj.service.CircuitService;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class CircuitController {

    private final CircuitService circuitService;



}
