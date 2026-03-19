package org.springproj.web.ui;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springproj.service.TeamService;
import org.springproj.model.Team;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ui")
public class TeamController {

    private final TeamService teamService;


    @GetMapping("/teams")
    String getAllTeams(
            Model model,
            @RequestParam(value = "teamName", required = false) String teamName
    ) {
        log.info("Returning team view");
        if (teamName == null) {
            List<Team> teams = teamService.findAll();
            model.addAttribute("teams", teams);
        }
        else {
            List<Team> teams = new ArrayList<>(1);
            teams.add(teamService.findByName(teamName));
            model.addAttribute("teams", teams);
        }
        return "teamsView";
    }

}
