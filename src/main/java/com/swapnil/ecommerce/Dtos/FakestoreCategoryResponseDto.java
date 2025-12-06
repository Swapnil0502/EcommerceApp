package com.swapnil.ecommerce.Dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakestoreCategoryResponseDto {

    private String message;
    private Boolean status;
     private List<CategoryDto> categories;
    
    public List<CategoryDto> getCategories() {
        return categories;
    }

}
