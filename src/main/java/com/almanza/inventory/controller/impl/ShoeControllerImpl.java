package com.almanza.inventory.controller.impl;

import com.almanza.inventory.controller.ShoeController;
import com.almanza.inventory.models.ShoeModel;
import com.almanza.inventory.models.ShoeToAddModel;
import com.almanza.inventory.models.ShoeToUpdateModel;
import com.almanza.inventory.service.ShoeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/shoes")
@AllArgsConstructor
public class ShoeControllerImpl implements ShoeController {

    private ShoeService shoeService;

    @Override
    public ResponseEntity<List<ShoeModel>> getShoes() {
        return shoeService.getShoes();
    }

    @Override
    public ResponseEntity<ShoeModel> createShoe(ShoeToAddModel shoeToAddModel) {
        return shoeService.createShoe(shoeToAddModel);
    }

    @Override
    public ResponseEntity<ShoeModel> updateShoe(ShoeToUpdateModel shoeToUpdateModel) {
        return shoeService.updateShoe(shoeToUpdateModel);
    }

    @Override
    public ResponseEntity<List<ShoeModel>> deleteShoe(Integer id) {
        return shoeService.deleteShoe(id);
    }
}
