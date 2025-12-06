package com.swapnil.ecommerce.Gateway.api;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Gateway.ICategoryGateway;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component("restGateway")
public class FakeStoreRestGateway implements ICategoryGateway {

//    private RestTemplate restTemplate;

    private RestTemplateBuilder restTemplateBuilder;
public FakeStoreRestGateway(RestTemplateBuilder restTemplateBuilder){
    this.restTemplateBuilder = restTemplateBuilder;
}

//    public FakeStoreRestGateway(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }

    @Override
    public List<CategoryDto>getAllCategories() throws
            IOException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        CategoryDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", CategoryDto[].class);
if(response==null)
    throw new IOException(
            "null"
    );

        return Arrays.asList(response);
    }

    @Override
    public CategoryDto getCategoryById(int id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject("https://fakestoreapi.com/products/"+id,CategoryDto.class);
    }
}
