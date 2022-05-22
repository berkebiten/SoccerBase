package com.example.soccerbaseapi.controller;

import com.example.soccerbaseapi.model.Team;
import com.example.soccerbaseapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/team")
public class
TeamController {

    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping(value = "/getAll")
    public List<Team> getAllVote() {
        return teamService.getAll();
    }

    @PostMapping(value = "/insert")
    public Team save(@RequestBody Team team) {
        return teamService.save(team);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestParam String id) {
        return teamService.delete(id);
    }
}
