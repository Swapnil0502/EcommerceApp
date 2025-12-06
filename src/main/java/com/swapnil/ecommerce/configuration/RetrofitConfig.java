package com.swapnil.ecommerce.configuration;

import com.swapnil.ecommerce.Gateway.api.FakestoreCategoryApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${FakestoreUrl}")
    private String fakestoreUrl;

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder().baseUrl(fakestoreUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Bean
    public FakestoreCategoryApi fakestoreCategoryApi(){
        return retrofit().create(FakestoreCategoryApi.class);
    }
}
