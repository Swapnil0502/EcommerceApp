package com.swapnil.ecommerce.Mapper;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category toEntity(CategoryDto dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static List<CategoryDto> toDtoList(List<Category> categories){
        return categories.stream().map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

}
