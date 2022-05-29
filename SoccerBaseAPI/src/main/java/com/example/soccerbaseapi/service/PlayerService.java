package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<Player> getAll();

    Optional<Player> getById(String id);
    List<Player> getByName(String name);
    List<Player> getByTeamId(String teamId);
    List<Player> getByCountryId(String teamId);
    List<Player> getByFilters(String name, Integer minAge, Integer maxAge,
                              String foot, String countryIds, String teamIds);
    Player save(Player player);

    boolean delete(String id);
}
