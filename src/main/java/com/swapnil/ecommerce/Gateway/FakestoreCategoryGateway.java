package com.swapnil.ecommerce.Gateway;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Gateway.api.FakestoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
//@Primary
public class FakestoreCategoryGateway implements ICategoryGateway{

    private FakestoreCategoryApi fakestoreCategoryApi;


    FakestoreCategoryGateway(FakestoreCategoryApi fakestoreCategoryApi){
        this.fakestoreCategoryApi=fakestoreCategoryApi;

    }


    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        List<CategoryDto> response = this.fakestoreCategoryApi.getAllCategories().execute().body();

        return response;
    }

    @Override
    public CategoryDto getCategoryById(int id) throws IOException {
        return this.fakestoreCategoryApi.getCategoriesById(id).execute().body();
    }


//
//    @Override
//    public List<CategoryDto> getAllRestCategories() {
//        ParameterizedTypeReference<List<CategoryDto>> typeRef = new ParameterizedTypeReference<>() {};
//        return restTemplate.exchange(
//                "https://fakestoreapi.com/products",
//                HttpMethod.GET,
//                null,
//                typeRef
//        ).getBody();
//    }
//
//    @Override
//    public CategoryDto getCategoryByIdRest(int id){
//        return restTemplate.getForObject("https://fakestoreapi.com/products/"+id,CategoryDto.class);
//    }
}
