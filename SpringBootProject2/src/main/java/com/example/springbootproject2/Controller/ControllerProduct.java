package com.example.springbootproject2.Controller;

import com.example.springbootproject2.ApiResponse.ApiResponse;
import com.example.springbootproject2.Model.Product;
import com.example.springbootproject2.Service.ServiceProduct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ControllerProduct {


    private final ServiceProduct serviceProduct;


    @GetMapping("/get")
    public ResponseEntity getBlog(){
        ArrayList <Product> products = serviceProduct.getProducts();
        return ResponseEntity.status(200).body(products);

    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product , Errors errors ){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        serviceProduct.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("product added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @Valid @RequestBody Product product , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        return ResponseEntity.status(200).body("products updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProducts (@PathVariable int id){

        boolean isdeleted =serviceProduct.deleteProduct(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("products deleted"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
}
