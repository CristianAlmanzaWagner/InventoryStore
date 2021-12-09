package com.almanza.inventory.controller.impl;

import com.almanza.inventory.controller.ProductController;
import com.almanza.inventory.controller.dto.ProductDTO;
import com.almanza.inventory.controller.dto.ProductToAddDTO;
import com.almanza.inventory.controller.dto.ProductToUpdateDTO;
import com.almanza.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Product controller implementation.
 */
@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {

    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductToAddDTO productToAddDTO) {
        productService.createProduct(productToAddDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productService.createProduct(productToAddDTO));
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductToUpdateDTO productToUpdateDTO) {
        if (productService.updateProduct(productToUpdateDTO) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productToUpdateDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<ProductDTO>> deleteProduct(Integer id) {
        if (productService.deleteProduct(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
