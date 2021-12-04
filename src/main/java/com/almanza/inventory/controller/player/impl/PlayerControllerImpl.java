package com.almanza.inventory.controller.player.impl;

import com.almanza.inventory.controller.player.PlayerController;
import com.almanza.inventory.controller.player.dto.PlayerDTO;
import com.almanza.inventory.controller.player.dto.PlayerToAddDTO;
import com.almanza.inventory.controller.player.dto.PlayerToUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/players")
public class PlayerControllerImpl implements PlayerController {

    @Override
    public List<PlayerDTO> getPlayer() {
        return List.of(
                new PlayerDTO(1, "Messi", 30),
                new PlayerDTO(2, "Cristiano", 7),
                new PlayerDTO(3, "Neymar", 10)
        );
    }

    @Override
    public PlayerDTO createPlayer(PlayerToAddDTO playerToAddDTO) {
        int randomNum = (int)(Math.random()*500+1);
        return PlayerDTO.builder()
            .id(randomNum)
            .name(playerToAddDTO.getName())
            .number(playerToAddDTO.getNumber())
            .build();
    }

    @Override
    public ResponseEntity<PlayerDTO> updatePlayer(PlayerToUpdateDTO playerToUpdateDTO) {
        List<PlayerDTO> playerList = Arrays.asList(
                new PlayerDTO(1, "Messi", 30),
                new PlayerDTO(2, "Cristiano", 7),
                new PlayerDTO(3, "Neymar", 10)
        );

        Optional<PlayerDTO> playerToFind = playerList.stream()
                .filter(playerDTO -> playerToUpdateDTO.getId().equals(playerDTO.getId()))
                .findAny();

        if (playerToFind.isPresent()) {
            PlayerDTO playerUpdated = PlayerDTO.builder()
                .id(playerToFind.get().getId())
                .name(playerToUpdateDTO.getName())
                .number(playerToUpdateDTO.getNumber())
                .build();

            return ResponseEntity.status(HttpStatus.OK).body(playerUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<PlayerDTO>> deletePlayer(Integer id) {
        List<PlayerDTO> playerList = new LinkedList<PlayerDTO>(
            List.of(
                new PlayerDTO(1, "Messi", 30),
                new PlayerDTO(2, "Cristiano", 7),
                new PlayerDTO(3, "Neymar", 10)
            )
        );

        Optional<PlayerDTO> playerToFind = playerList.stream()
            .filter(playerDTO -> id.equals(playerDTO.getId()))
            .findAny();

        if (playerToFind.isPresent()) {
            playerList.remove(playerToFind.get());
            return ResponseEntity.status(HttpStatus.OK).body(playerList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
