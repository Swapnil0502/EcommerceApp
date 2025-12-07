package com.swapnil.ecommerce.controller;

import com.swapnil.ecommerce.Dtos.ProductDto;
import com.swapnil.ecommerce.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService=productService;
    }

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
}
