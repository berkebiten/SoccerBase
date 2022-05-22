package com.example.soccerbaseapi.controller;

import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.service.PlayerService;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/player")
public class
PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerController(com.example.soccerbaseapi.service.PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = "/getAll")
    public List<Player> getAll() {
        return playerService.getAll();
    }

    @GetMapping(value = "/getById")
    public Optional<Player> getById(@RequestParam String id) {
        return playerService.getById(id);
    }

    @GetMapping(value = "/getByName")
    public List<Player> getByName(@RequestParam String name) {
        return playerService.getByName(name);
    }

    @GetMapping(value = "/getByTeamId")
    public List<Player> getByTeamId(@RequestParam String teamId) {
        return playerService.getByTeamId(teamId);
    }
    @GetMapping(value = "/getByCountryId")
    public List<Player> getByCountryId(@RequestParam String countryId) {
        return playerService.getByCountryId(countryId);
    }
    @GetMapping(value = "/getByFilters")
    public List<Player> getByFilters(@RequestParam @Nullable String name,
                                       @RequestParam @Nullable Integer minAge,
                                       @RequestParam @Nullable Integer maxAge,
                                       @RequestParam @Nullable String foot,
                                       @RequestParam @Nullable String countryIds,
                                       @RequestParam @Nullable String teamIds) {
        return playerService.getByFilters(name,minAge,maxAge,foot,countryIds,countryIds,teamIds);
    }
    @PostMapping(value = "/insert")
    public Player save(@RequestBody Player player) {
        return playerService.save(player);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestParam String id) {
        return playerService.delete(id);
    }
}
