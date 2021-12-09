package com.almanza.inventory.service;

import com.almanza.inventory.controller.dto.ProductDTO;
import com.almanza.inventory.controller.dto.ProductToAddDTO;
import com.almanza.inventory.controller.dto.ProductToUpdateDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * The Product service interface.
 */
public interface ProductService {

    /**
     * This function is used to get the product list.
     *
     * @return Product list.
     */
    List<ProductDTO> getProducts();

    /**
     * This function is used to create a product.
     *
     * @param productToAddDTO This param is used to add a product.
     * @return The product created.
     */
    ProductDTO createProduct(@RequestBody ProductToAddDTO productToAddDTO);

    /**
     * This function is used to update a product.
     *
     * @param productToUpdateDTO This param is used to update a product.
     * @return The product updated.
     */
    ProductDTO updateProduct(@RequestBody ProductToUpdateDTO productToUpdateDTO);

    /**
     * This function is used to delete a product by id.
     *
     * @param id The param is used to delete a product.
     * @return The product list without the deleted product.
     */
    List<ProductDTO> deleteProduct(@PathVariable Integer id);
}
