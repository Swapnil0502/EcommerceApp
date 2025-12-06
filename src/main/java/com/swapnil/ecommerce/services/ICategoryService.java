package com.swapnil.ecommerce.services;

import com.swapnil.ecommerce.Dtos.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDto> getAllCategories() throws IOException;

    CategoryDto getCategoryById(int id) throws IOException;
//
//    List<CategoryDto> getAllRestCategories() ;
//
//    CategoryDto getCategoryByIdRest(int id);
}
