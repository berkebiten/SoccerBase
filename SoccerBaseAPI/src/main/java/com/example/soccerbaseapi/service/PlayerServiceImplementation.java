package com.example.soccerbaseapi.service;

import com.example.soccerbaseapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImplementation implements com.example.soccerbaseapi.service.PlayerService {
    private com.example.soccerbaseapi.repository.PlayerRepository bookRepository;

    @Autowired
    public PlayerServiceImplementation(com.example.soccerbaseapi.repository.PlayerRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Player> getAll(){
        List<Player> players = new ArrayList<>();
        bookRepository.findAll().forEach(players::add);
        return players;
    }


    @Override
    public Player save(Player player){
        bookRepository.save(player);
        return player;
    }
    @Override
    public boolean  delete(String id){
        try {
            bookRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return  false;
        }


    }
}
