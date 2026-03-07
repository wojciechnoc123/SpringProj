package org.springproj;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springproj.config.SpringProjConfig;
import org.springproj.repository.SeasonDAO;
import org.springproj.service.SeasonService;
import org.springproj.service.impl.SeasonServiceBean;
import org.springproj.repository.sampleMem.SampleData;
import org.springproj.model.TeamEntry;

import java.util.Arrays;

@Component
@Slf4j
public class SpringProjComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final SeasonService seasonService;

    public SpringProjComponent(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostConstruct
    void init() {
        this.seasonService.printAllSeasons();

    }

    @Override
    public void run(String... args) throws Exception{
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        seasonService.printAllSeasons();
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method)");
    }

}
