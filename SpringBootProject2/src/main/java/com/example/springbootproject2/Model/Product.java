package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    @NotNull(message = "id should be not null")
    //@Pattern(regexp = "^(?!0)\\d{3}$")
    private int id;

    @NotEmpty(message = "name  must not be empty")
    @Size(max=3, message = "name must be 3 numbers")

    private String name;

    @NotNull(message = "price must not be empty")
    @Positive(message = "price must be positive number")
    private double price;

    @NotNull(message = "category ID must be not empty")
   // @Max(value=2,message = "category ID must be 3 numbers")
    private int categoryID ;

}
