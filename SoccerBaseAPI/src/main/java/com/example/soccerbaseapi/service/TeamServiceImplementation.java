package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImplementation implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @Override
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }
    @Override
    public Player save(Player player) {
        playerRepository.save(player);
        return player;
    }
    @Override
    public boolean delete(String id) {
        try {
            playerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
