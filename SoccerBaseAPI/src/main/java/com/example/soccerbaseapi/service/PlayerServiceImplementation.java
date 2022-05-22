package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Optional<Player> getById(String id) {
        return playerRepository.findById(id);
    }

    public List<Player> getByName(String name) {
        List<Player> players = new ArrayList<>(playerRepository.findAll());
        players.removeIf(player1 -> !player1.getName().matches(".*" + name + ".*"));
        return players;
    }

    public List<Player> getByTeamId(String teamId) {
        List<Player> players = new ArrayList<>(playerRepository.findAll());
        players.removeIf(player1 -> !player1.getCurrentTeamId().equals(teamId));
        return players;
    }

    public List<Player> getByCountryId(String countryId) {
        List<Player> players = new ArrayList<>(playerRepository.findAll());
        players.removeIf(player1 -> !player1.getCountryId().equals(countryId));
        return players;
    }

    public List<Player> getByFilters(String name, Integer minAge, Integer maxAge,
                                     String foot, String countryIds, String teamIds, String ids) {
        List<Player> players = new ArrayList<>(playerRepository.findAll());
        ArrayList<String> countryIdList;
        ArrayList<String> teamIdList ;
        if (!countryIds.isEmpty())
            countryIdList = new ArrayList<String>(Arrays.asList(countryIds.split(",")));
        else
            countryIdList = new ArrayList<String>();
        if (!teamIds.isEmpty())
            teamIdList = new ArrayList<String>(Arrays.asList(teamIds.split(",")));
        else
            teamIdList = new ArrayList<>();
        players.removeIf(player1 -> (!player1.getName().matches(".*" + name + ".*"))
                        || (minAge != null && player1.getAge() < minAge)
                        || (maxAge != null && player1.getAge() > maxAge)
                        || (!foot.isEmpty() && !player1.getFoot().equals(foot))
                        || (countryIdList.size() != 0 && !countryIdList.contains(player1.getCountryId()))
                        || (teamIdList.size() != 0 && !teamIdList.contains(player1.getCurrentTeamId()))
        );
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
