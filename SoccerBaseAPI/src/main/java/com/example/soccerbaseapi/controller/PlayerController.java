package com.example.soccerbaseapi.controller;

import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.requestModel.PlayerRequest;
import com.example.soccerbaseapi.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/player")
public class
PlayerController {

    private final PlayerService playerService;

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
    public List<Player> getByFilters(@RequestBody PlayerRequest playerRequest) {
        return playerService.getByFilters(
                playerRequest.getName(),
                playerRequest.getMinAge()-1,
                playerRequest.getMaxAge()+1,
                playerRequest.getFoot(),
                playerRequest.getCountryIds() == null ? "" : playerRequest.getCountryIds(),
                playerRequest.getTeamIds() == null ? "" : playerRequest.getTeamIds()
        );
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
