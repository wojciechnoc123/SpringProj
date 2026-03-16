package org.springproj.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springproj.service.TeamService;
import org.springproj.model.Team;

@Component
@RequiredArgsConstructor
public class TeamValidator implements Validator {

    private final TeamService teamService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(Team.class); }

    @Override
    public void validate(Object target, Errors erros) {
        Team validatedTeam = (Team) target;
        boolean duplicated = teamService.findAll().stream()
                .anyMatch((team) -> team.getName().equalsIgnoreCase(validatedTeam.getName()));
        if (duplicated)
            erros.rejectValue("name", "team.name.duplicated");
    }

}
