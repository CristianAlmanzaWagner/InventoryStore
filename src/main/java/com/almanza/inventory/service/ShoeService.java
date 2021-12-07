package com.almanza.inventory.service;

import com.almanza.inventory.models.ShoeModel;
import com.almanza.inventory.models.ShoeToAddModel;
import com.almanza.inventory.models.ShoeToUpdateModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ShoeService {

    ResponseEntity<List<ShoeModel>> getShoes();
    ResponseEntity<ShoeModel> createShoe(@RequestBody ShoeToAddModel shoeToAddModel);
    ResponseEntity<ShoeModel> updateShoe(@RequestBody ShoeToUpdateModel shoeToUpdateModel);
    ResponseEntity<List<ShoeModel>> deleteShoe(@PathVariable Integer id);
}
