package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {


    @NotNull(message = "id should be not null")
    @Min(value = 3, message = "length of id should be 3 ")
    private int id;

    @NotEmpty(message = "name  must not be empty")
    @Size (max = 3, message = "name must be 3 letters")
    private String name;
}
