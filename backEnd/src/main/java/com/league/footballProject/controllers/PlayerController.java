package com.league.footballProject.controllers;

import com.league.footballProject.commons.Player;
import com.league.footballProject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(playerService.getPlayers(),HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);
    }

}
