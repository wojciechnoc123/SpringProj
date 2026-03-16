package org.springproj.web.rest;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springproj.service.TeamService;
import org.springproj.model.Team;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class TeamRest {

    private final TeamService teamService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final TeamValidator teamValidator;

    @InitBinder
    void initBinder(WebDataBinder binder) { binder.addValidators(teamValidator); }

    @GetMapping("/team")
    public ResponseEntity<Team> getTeam(
            @RequestParam("name") String name

    ) {
        Team team = teamService.findByName(name);
        if (team == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(team);
    }

    @PostMapping("/teams")
    public ResponseEntity<?> saveTeam(@Validated @RequestBody Team team, Errors errors, HttpServletRequest request) {
        log.info("creating a team");

        if (errors.hasErrors()) {
            Locale locale1 = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(objectError -> messageSource.getMessage(objectError.getCode(), new Object[0], locale1))
                    .reduce("errors:\n", (accu, objectError)-> accu + objectError + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.saveTeam(team));
    }

}
