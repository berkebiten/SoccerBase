package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Team;
import com.example.soccerbaseapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImplementation implements TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImplementation(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }
    @Override
    public Team save(Team team) {
        teamRepository.save(team);
        return team;
    }
    @Override
    public boolean delete(String id) {
        try {
            teamRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
