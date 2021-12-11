package com.almanza.inventory.controller;

import com.almanza.inventory.controller.dto.ProductDTO;
import com.almanza.inventory.controller.dto.ProductToAddDTO;
import com.almanza.inventory.controller.dto.ProductToUpdateDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Product controller interface.
 */
public interface ProductController {

    /**
     * This function is used to get the product list.
     *
     * @return ResponseEntity from the product list.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> getProducts();

    /**
     * This function is used to create a product.
     *
     * @param productToAddDTO This param is used to add a product.
     * @return ResponseEntity from the product created.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductToAddDTO productToAddDTO);

    /**
     * This function is used to update a product.
     *
     * @param productToUpdateDTO This param is used to update a product.
     * @return ResponseEntity from the product updated.
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductToUpdateDTO productToUpdateDTO);

    /**
     * This function is used to delete a product by id.
     *
     * @param id The param is used to delete a product.
     * @return ResponseEntity from the product list without the deleted product.
     */
    @DeleteMapping(path = "/{id}")
    ResponseEntity<List<ProductDTO>> deleteProduct(@PathVariable Integer id);
}
