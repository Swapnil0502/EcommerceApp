package com.swapnil.ecommerce.services;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Entity.Category;
import com.swapnil.ecommerce.Mapper.CategoryMapper;
import com.swapnil.ecommerce.Repository.CategoryRepository;
import com.swapnil.ecommerce.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepo;
    public CategoryService(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        List<Category> categories = categoryRepo.findAll();
        return CategoryMapper.toDtoList(categories);
    }

    @Override
    public CategoryDto getCategoryById(Long id) throws IOException {
        Category category = categoryRepo.findById(id).orElseThrow(()-> new NotFoundException("Category Not Found"));
        return CategoryMapper.toDto(category);
    }


    @Override
    public CategoryDto createCategory(CategoryDto req){
        Category category = categoryRepo.save(CategoryMapper.toEntity(req));
        return CategoryMapper.toDto(category);
    }
}
