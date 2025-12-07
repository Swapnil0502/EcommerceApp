package com.swapnil.ecommerce.controller;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.services.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final ICategoryService categoryService;


    public CategoryController(ICategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() throws IOException {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Long id) throws IOException {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/createCategory")
    public CategoryDto createCategory(@RequestBody CategoryDto req) throws IOException {
        return categoryService.createCategory(req);
    }

//    @GetMapping("/restCategories")
//    public List<CategoryDto> getAllRestCategories()  {
//        return categoryService.getAllRestCategories();
//    }
//
//    @GetMapping("/rest/{id}")
//    public CategoryDto getCategoryByIdRest(@PathVariable("id") int id){
//        return categoryService.getCategoryByIdRest(id);
//    }



    //we can mention the exception handler here so that it will be automatically applied to all the controller methods

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found Please check again");
//    }
}
