package com.almanza.inventory.controller;

import com.almanza.inventory.models.ShoeModel;
import com.almanza.inventory.models.ShoeToAddModel;
import com.almanza.inventory.models.ShoeToUpdateModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ShoeController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ShoeModel>> getShoes();

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoeModel> createShoe(@RequestBody ShoeToAddModel shoeToAddModel);

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoeModel> updateShoe(@RequestBody ShoeToUpdateModel shoeToUpdateModel);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<List<ShoeModel>> deleteShoe(@PathVariable Integer id);
}
