package com.swapnil.ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product>products;
}
