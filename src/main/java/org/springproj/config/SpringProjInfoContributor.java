package org.springproj.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springproj.service.GeneralService;

@Component
public class SpringProjInfoContributor implements InfoContributor {

    private final GeneralService generalService;

    public SpringProjInfoContributor(GeneralService generalService) {
        this.generalService = generalService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("drivers", this.generalService.getAllDrivers().size());
        builder.withDetail("teams", this.generalService.getAllTeams().size());
        builder.withDetail("seasons", this.generalService.getAllSeasons().size());
    }
}
