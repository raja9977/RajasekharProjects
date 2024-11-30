package com.raja.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*; 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String proName;

    @NotBlank(message = "Product brand is required")
    @Size(min = 2, max = 50, message = "Product brand must be between 2 and 50 characters")
    private String proBrand;

    @Positive(message = "Product price must be a positive number")
    private double proPrice;

    @NotBlank(message = "Product description is required")
    @Size(max = 500, message = "Product description cannot exceed 500 characters")
    private String proDescription;

    @NotBlank(message = "Product category is required")
    private String proCategory;
}