package com.example.springbootproject2.Controller;

import com.example.springbootproject2.ApiResponse.ApiResponse;
import com.example.springbootproject2.Model.Category;
import com.example.springbootproject2.Service.ServiceCategory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;

@RequestMapping("/api/v1/Category")
@RestController
@RequiredArgsConstructor
public class ControllerCategory {

    private final ServiceCategory serviceCategory;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        ArrayList<Category>categories=serviceCategory.getCategories();
        return ResponseEntity.status(200).body(categories);
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceCategory.addCategories(category);
        return ResponseEntity.status(400).body(new ApiResponse("catogery added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable int id , @Valid@RequestBody Category category , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isupdated = serviceCategory.updateCategories(id,category);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponse("catogary updated "));
        }
            return ResponseEntity.status(400).body(new ApiResponse("wrong id "));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id ){
        boolean isdeleted = serviceCategory.deleteCategories(id);
        if( isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("catogary  deleted "));
        }
           return ResponseEntity.status(400).body(new ApiResponse("wrong id "));
    }



}


