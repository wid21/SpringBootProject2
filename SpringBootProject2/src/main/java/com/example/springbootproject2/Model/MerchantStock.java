package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MerchantStock {



    @NotNull(message = "id should be not null")
    @Min(value = 3, message = "length of id should 3 length ")
    private int id;

    @NotNull(message = "merchant id should be not null")
    @Min(value = 3, message = "length of merchantId should be 3 ")
    private int merchantId;

    @NotNull(message = "product id should not be null")
    @Min(value = 3, message = "length of productid should be 3 ")
    private int productid;

    @NotNull(message = "merchantId should not be null")
    @Min(value = 10, message = "stock should have 10 products or more  ")
    private int stock;

}
