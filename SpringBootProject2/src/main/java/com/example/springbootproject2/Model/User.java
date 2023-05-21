package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class User {


    @NotNull(message = "id should be not null")
    @Max(value=2,message = "id must be 3 numbers")
    private int id;

    @Pattern(regexp = "^.{5}$", message = "Username must be 5 characters long")//فاضي نشيك
    private String username;

    @NotEmpty(message = "password  must not be empty")
    @Size(max=6, message = "password must be 6 numbers")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$", message = "Password must contain both letters and digits")
    private String password;

    @NotEmpty(message = "email  must not be empty")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{6,}$",
            message = "Password must be at least 6 characters long and contain both letters and digits")
    private String email;


    @NotEmpty(message = "role  must not be empty")
    @Pattern(regexp = "(customer|admin)$", message = "User role must be either 'customer' or 'admin'")
    private String role;



    @Positive(message = "balance must to be positive")
    private double balance;

}
