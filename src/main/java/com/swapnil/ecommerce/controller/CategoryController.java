package com.swapnil.ecommerce.controller;

import com.swapnil.ecommerce.Dtos.CategoryDto;
import com.swapnil.ecommerce.Dtos.ProductDto;
import com.swapnil.ecommerce.services.ICategoryService;
import com.swapnil.ecommerce.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IProductService productService;

    public CategoryController(ICategoryService categoryService,IProductService productService){
        this.categoryService=categoryService;
        this.productService=productService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() throws IOException {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") int id) throws IOException {
        return categoryService.getCategoryById(id);
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

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam(required = false ) String name)  {
        if (name != null && !name.isBlank()) {
            ProductDto product = productService.getProductByName(name);
            return ResponseEntity.ok(product);
        } else {
            List<ProductDto> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        }
    }
    @GetMapping("/getProductById/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) throws Exception{
        return productService.createProduct(productDto);
    }

    @GetMapping("/expensive")
    public List<ProductDto> getExpensiveProduct(@RequestParam("minPrice") int minPrice){
        return productService.getExpensiveProduct(minPrice);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProduct(@RequestParam("searchParam") String searchParam){
        return productService.searchProduct(searchParam);
    }

    //we can mention the exception handler here so that it will be automatically applied to all the controller methods

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found Please check again");
//    }
}
