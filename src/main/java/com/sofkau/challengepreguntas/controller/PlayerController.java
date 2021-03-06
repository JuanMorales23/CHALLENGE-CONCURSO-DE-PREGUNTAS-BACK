package com.sofkau.challengepreguntas.controller;

import com.sofkau.challengepreguntas.entities.Player;
import com.sofkau.challengepreguntas.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @GetMapping
    public List<Player> findAll(){
        return playerService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody Player player){
        playerService.save(player);
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable("id") String id){
        return playerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        playerService.delete(id);
    }


    @GetMapping("/exist/{name}")
    public boolean existingPlayer(@PathVariable("name") String name){
        return playerService.existingPlayer(name);
    }

    @GetMapping("/getId/{name}")
    public String getIdByName(@PathVariable("name") String name){
        return playerService.getIdByName(name);
    }

    @PutMapping
    public void update(@RequestBody Player player){
        playerService.updateScore(player);
    }
}
