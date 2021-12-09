package com.almanza.inventory.controller;

import com.almanza.inventory.controller.dto.ProductDTO;
import com.almanza.inventory.controller.dto.ProductToAddDTO;
import com.almanza.inventory.controller.dto.ProductToUpdateDTO;
import com.almanza.inventory.controller.impl.ProductControllerImpl;
import com.almanza.inventory.enums.ProductTypeEnum;
import com.almanza.inventory.service.ProductService;
import com.almanza.inventory.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductControllerTest {

    @InjectMocks
    ProductService productService = new ProductServiceImpl();
    ProductController productController = new ProductControllerImpl(productService);

    @Test
    public void getProductTest() {
        ResponseEntity<List<ProductDTO>> responseEntity = productController.getProducts();

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void createProductTest() {
        ResponseEntity<ProductDTO> responseEntity = productController.createProduct(
            ProductToAddDTO.builder()
                .productType(ProductTypeEnum.PANTS)
                .color("Blue")
                .creationDate(LocalDateTime.now())
                .build()
        );

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void updateProductTest() {
        ResponseEntity<ProductDTO> responseEntity = productController.updateProduct(
            ProductToUpdateDTO.builder()
                .id(1)
                .productType(ProductTypeEnum.PANTS)
                .color("Red")
                .creationDate(LocalDateTime.now())
                .build()
        );

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void deleteProductTest() {
        ResponseEntity<List<ProductDTO>> responseEntity = productController.deleteProduct(1);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
