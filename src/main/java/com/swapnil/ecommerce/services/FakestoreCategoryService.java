package com.swapnil.ecommerce.services;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class FakestoreCategoryService implements ICategoryService {

    private ICategoryGateway iCategoryGateway;

    public FakestoreCategoryService(@Qualifier("restGateway")ICategoryGateway iCategoryGateway){

        this.iCategoryGateway=iCategoryGateway;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }

    @Override
    public CategoryDto getCategoryById(Long id) throws IOException {
        return iCategoryGateway.getCategoryById(id);
    }

//    @Override
//    public List<CategoryDto> getAllRestCategories()  {
//        return iCategoryGateway.getAllRestCategories();
//    }
//
//    @Override
//    public CategoryDto getCategoryByIdRest(int id){
//        return iCategoryGateway.getCategoryByIdRest(id);
//    }

    @Override
    public CategoryDto createCategory(CategoryDto req){
        return null;
    }
}
