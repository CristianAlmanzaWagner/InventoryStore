package com.almanza.inventory.service.impl;

import com.almanza.inventory.models.ShoeModel;
import com.almanza.inventory.models.ShoeToAddModel;
import com.almanza.inventory.models.ShoeToUpdateModel;
import com.almanza.inventory.service.ShoeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoeServiceImpl implements ShoeService {

    @Override
    public ResponseEntity<List<ShoeModel>> getShoes() {
        return ResponseEntity.status(HttpStatus.OK).body(
            List.of(
            new ShoeModel(1, "Ultraboost 21", "Adidas"),
            new ShoeModel(2, "Air Max 97", "Nike"),
            new ShoeModel(3, "RS-Z Men's Sneakers", "Puma")
            )
        );
    }

    @Override
    public ResponseEntity<ShoeModel> createShoe(ShoeToAddModel shoeToAddModel) {
        Integer randomNumber = (int) (Math.random()*500+1);
        return ResponseEntity.status(HttpStatus.OK).body(
            ShoeModel.builder()
                .id(randomNumber)
                .name(shoeToAddModel.getName())
                .brand(shoeToAddModel.getBrand())
                .build()
        );
    }

    @Override
    public ResponseEntity<ShoeModel> updateShoe(ShoeToUpdateModel shoeToUpdateModel) {
        List<ShoeModel> shoeList = new ArrayList<>(
            List.of(
                new ShoeModel(1, "Ultraboost 21", "Adidas"),
                new ShoeModel(2, "Air Max 97", "Nike"),
                new ShoeModel(3, "RS-Z Men's Sneakers", "Puma")
            )
        );

        Optional<ShoeModel> shoeToFind = shoeList.stream()
            .filter(shoeModel -> shoeToUpdateModel.getId().equals(shoeModel.getId()))
            .findAny();

        if (shoeToFind.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                ShoeModel.builder()
                    .id(shoeToFind.get().getId())
                    .name(shoeToUpdateModel.getName())
                    .brand(shoeToUpdateModel.getBrand())
                    .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<ShoeModel>> deleteShoe(Integer id) {
        List<ShoeModel> shoeList = new LinkedList<>(
            List.of(
                new ShoeModel(1, "Ultraboost 21", "Adidas"),
                new ShoeModel(2, "Air Max 97", "Nike"),
                new ShoeModel(3, "RS-Z Men's Sneakers", "Puma")
            )
        );

        Optional<ShoeModel> shoeToFind = shoeList.stream()
            .filter(shoeModel -> id.equals(shoeModel.getId()))
            .findAny();

        if (shoeToFind.isPresent()) {
            shoeList.remove(shoeToFind.get());

            return ResponseEntity.status(HttpStatus.OK).body(shoeList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
