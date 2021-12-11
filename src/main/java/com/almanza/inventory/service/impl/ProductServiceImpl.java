package com.almanza.inventory.service.impl;

import com.almanza.inventory.controller.dto.ProductDTO;
import com.almanza.inventory.controller.dto.ProductToAddDTO;
import com.almanza.inventory.controller.dto.ProductToUpdateDTO;
import com.almanza.inventory.enums.ProductTypeEnum;
import com.almanza.inventory.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * The Product service implementation.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductDTO> getProducts() {
        return List.of(
            new ProductDTO(1, ProductTypeEnum.SHIRT, "Red", LocalDateTime.now()),
            new ProductDTO(2, ProductTypeEnum.SHOES, "Golden", LocalDateTime.now()),
            new ProductDTO(3, ProductTypeEnum.PANTS, "Black", LocalDateTime.now()),
            new ProductDTO(4, ProductTypeEnum.GLOVES, "Gray", LocalDateTime.now()),
            new ProductDTO(5, ProductTypeEnum.UNDERPANTS, "Blue", LocalDateTime.now()),
            new ProductDTO(6, ProductTypeEnum.JACKET, "White", LocalDateTime.now())
        );
    }

    @Override
    public ProductDTO createProduct(ProductToAddDTO productToAddDTO) {
        Integer randomNumber = (int) (Math.random()*500+1);
        return ProductDTO.builder()
            .id(randomNumber)
            .productType(productToAddDTO.getProductType())
            .color(productToAddDTO.getColor())
            .creationDate(productToAddDTO.getCreationDate())
            .build();
    }

    @Override
    public ProductDTO updateProduct(ProductToUpdateDTO productToUpdateDTO) {
        List<ProductDTO> productList = new ArrayList<>(
            List.of(
                new ProductDTO(1, ProductTypeEnum.SHIRT, "Red", LocalDateTime.now()),
                new ProductDTO(2, ProductTypeEnum.SHOES, "Golden", LocalDateTime.now()),
                new ProductDTO(3, ProductTypeEnum.PANTS, "Black", LocalDateTime.now()),
                new ProductDTO(4, ProductTypeEnum.GLOVES, "Gray", LocalDateTime.now()),
                new ProductDTO(5, ProductTypeEnum.UNDERPANTS, "Blue", LocalDateTime.now()),
                new ProductDTO(6, ProductTypeEnum.JACKET, "White", LocalDateTime.now())
            )
        );

        Optional<ProductDTO> productToFind = productList.stream()
            .filter(productDTO -> productToUpdateDTO.getId().equals(productDTO.getId()))
            .findAny();

        if (productToFind.isPresent()) {
            return ProductDTO.builder()
                .id(productToFind.get().getId())
                .productType(productToUpdateDTO.getProductType())
                .color(productToUpdateDTO.getColor())
                .creationDate(productToUpdateDTO.getCreationDate())
                .build();

        } else {
            return null;
        }
    }

    @Override
    public List<ProductDTO> deleteProduct(Integer id) {
        List<ProductDTO> productList = new LinkedList<>(
            List.of(
                new ProductDTO(1, ProductTypeEnum.SHIRT, "Red", LocalDateTime.now()),
                new ProductDTO(2, ProductTypeEnum.SHOES, "Golden", LocalDateTime.now()),
                new ProductDTO(3, ProductTypeEnum.PANTS, "Black", LocalDateTime.now()),
                new ProductDTO(4, ProductTypeEnum.GLOVES, "Gray", LocalDateTime.now()),
                new ProductDTO(5, ProductTypeEnum.UNDERPANTS, "Blue", LocalDateTime.now()),
                new ProductDTO(6, ProductTypeEnum.JACKET, "White", LocalDateTime.now())
            )
        );

        Optional<ProductDTO> productToFind = productList.stream()
            .filter(productDTO -> id.equals(productDTO.getId()))
            .findAny();

        if (productToFind.isPresent()) {
            productList.remove(productToFind.get());

            return productList;
        } else {
            return null;
        }
    }
}
