package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAll();

    Player save(Player player);

    boolean delete(String id);
}
