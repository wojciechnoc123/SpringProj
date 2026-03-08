package org.springproj;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springproj.service.GeneralService;

import java.util.Arrays;

@Component
@Slf4j
public class SpringProjComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final GeneralService generalService;

    public SpringProjComponent(GeneralService generalService) {
        this.generalService = generalService;
    }

    @PostConstruct
    void init() {
    //    this.seasonService.printAllSeasons();
        System.out.println("Zaczynam pracę.");
    }

    @Override
    public void run(String... args) throws Exception{
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        System.out.println(generalService.printAllSeasonsString());
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method)");
    }

}
