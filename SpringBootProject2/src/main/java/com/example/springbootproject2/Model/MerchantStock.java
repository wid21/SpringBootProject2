package com.example.springbootproject2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MerchantStock {



    @NotNull(message = "id should be not null")
    private int id;

    @NotNull(message = "merchant id should be not null")
    private int merchantId;

    @NotNull(message = "product id should not be null")
    private int productid;

    @NotNull(message = "merchantId should not be null")
    @Min(value = 10, message = "Stock must have at least 10 prducts! ")
    private int stock;

}
