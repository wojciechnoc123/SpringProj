package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springproj.service.impl.SeasonServiceBean;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seasons")
public class SeasonRest {

    private SeasonServiceBean seasonServiceBean;



}
