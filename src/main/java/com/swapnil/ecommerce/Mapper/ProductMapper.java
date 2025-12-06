package com.swapnil.ecommerce.Mapper;

import com.swapnil.ecommerce.Dtos.ProductDto;
import com.swapnil.ecommerce.Entity.Category;
import com.swapnil.ecommerce.Entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .image(product.getImage())
                .color(product.getColor())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public static List<ProductDto> toDtoList(List<Product> products) {
        if (products == null) {
            return List.of();
        }
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Product toEntity(ProductDto productDto, Category category){
        return Product.builder()
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .image(productDto.getImage())
                .color(productDto.getColor())
                .description(productDto.getDescription())
                .discount(productDto.getDiscount())
                .model(productDto.getModel())
                .brand(productDto.getBrand())
                .popular(productDto.isPopular())
                .category(category)
                .build();

    }

}
