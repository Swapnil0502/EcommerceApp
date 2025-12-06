package com.swapnil.ecommerce.Repository;

import com.swapnil.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    // findById JPA inbuilt query

    // JPA custom query
    Optional<Product>findByTitle(@Param("name")String name);

    // HQL query object based
    @Query("select p FROM Product p WHERE p.price > :minPrice")
    List<Product> getExpensiveProduct(@Param("minPrice") int minPrice);

    //Native sql query raw query as written in db
    @Query(value = "select * from product where :searchParam = null or :searchParam = ' ' or title like concat('%', :searchParam ,'%') or description like concat('%' , :searchParam , '%')",nativeQuery = true)
    List<Product> searchProduct(@Param("searchParam") String searchParam);

}
