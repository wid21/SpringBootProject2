package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    @NotNull(message = "id should be not null")
    @Min(value = 3, message = "length of id should be 3 ")
    private int id;

    @NotEmpty(message = "name  must not be empty")
    @Size(min=3, message = "name must be 3 numbers")
    private String name;

    @NotNull(message = "price must not be empty")
    @PositiveOrZero(message = "price must be positive number")
    private int price;

    @NotNull(message = "category ID must be not empty")
   @Min(value = 3, message = "length of categoryID should be 3 ")
    private int categoryID ;

}
