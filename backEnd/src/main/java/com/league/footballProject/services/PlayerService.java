package com.league.footballProject.services;

import com.league.footballProject.commons.Player;
import com.league.footballProject.database.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    /**
     * get player from the database by ID
     * @param id
     * @return
     */
    public Player getPlayerById(Long id){
        return playerRepository.findById(id).isPresent() ? playerRepository.findById(id).get() : null;
    }

    /**
     * Add Player to DB
     * @param player player to sav
     *
     * @return player ,Null if failed
     */
    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }

}
