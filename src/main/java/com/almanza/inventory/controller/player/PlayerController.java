package com.almanza.inventory.controller.player;

import com.almanza.inventory.controller.player.dto.PlayerDTO;
import com.almanza.inventory.controller.player.dto.PlayerToAddDTO;
import com.almanza.inventory.controller.player.dto.PlayerToUpdateDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PlayerController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<PlayerDTO> getPlayer();

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PlayerDTO createPlayer(@RequestBody PlayerToAddDTO playerToAddDTO);

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerToUpdateDTO playerToUpdateDTO);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<List<PlayerDTO>> deletePlayer(@PathVariable Integer id);
}
