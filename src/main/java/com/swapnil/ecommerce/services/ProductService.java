package com.swapnil.ecommerce.services;

import com.swapnil.ecommerce.Dtos.ProductDto;
import com.swapnil.ecommerce.Entity.Category;
import com.swapnil.ecommerce.Entity.Product;
import com.swapnil.ecommerce.Mapper.ProductMapper;
import com.swapnil.ecommerce.Repository.CategoryRepository;
import com.swapnil.ecommerce.Repository.ProductRepository;
import com.swapnil.ecommerce.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository productRepo,CategoryRepository categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ProductMapper.toDtoList(products);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepo.findById(id).orElse(null);
        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws Exception{
        Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow(() -> new Exception("Category Not Found")); // throwing checked exception so need to add in method signature else will not be able to build
        Product saved =  productRepo.save(ProductMapper.toEntity(productDto, category));
        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductDto getProductByName(String name){
      Product product = productRepo.findByTitle(name).orElseThrow(()-> new NotFoundException("Product Not Found")); //using global exception handler that sxtends uncheked exception so no need to add in mthod signature
      return ProductMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getExpensiveProduct(int minPrice){
        List<Product> products = productRepo.getExpensiveProduct(minPrice);
        return ProductMapper.toDtoList(products);
    }

    @Override
    public List<ProductDto> searchProduct(String searchParam){
        List<Product> products = productRepo.searchProduct(searchParam);
        return ProductMapper.toDtoList(products);
    }

}
