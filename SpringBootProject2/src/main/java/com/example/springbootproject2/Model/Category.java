package com.example.springbootproject2.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {


    @NotNull(message = "id should be not null")
    private int id;

    @NotEmpty(message = "name  must not be empty")
    @Size(max = 3, message = "name must be 3 numbers")
    private String name;
}
