package com.swapnil.ecommerce.services;

import com.swapnil.ecommerce.Dtos.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto productDto) throws Exception;

    ProductDto getProductByName(String name);

    List<ProductDto> getExpensiveProduct(int minPrice);

    List<ProductDto> searchProduct(String searchParam);

}
