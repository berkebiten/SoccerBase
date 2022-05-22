package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAll();

    Team save(Team team);

    boolean delete(String id);
}
