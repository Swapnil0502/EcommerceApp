package com.swapnil.ecommerce.Gateway.api;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;


public interface FakestoreCategoryApi {
    @GET("products")
    Call<List<CategoryDto>> getAllCategories()throws IOException;

    @GET("products/{id}")
    Call<CategoryDto> getCategoriesById(@Path("id") int id)throws IOException;


}
