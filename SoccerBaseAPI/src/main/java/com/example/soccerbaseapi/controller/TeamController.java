package com.example.soccerbaseapi.controller;

import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Player> getAllVote() {
        return playerService.getAll();
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
