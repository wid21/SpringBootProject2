package com.example.springbootproject2.Controller;

import com.example.springbootproject2.ApiResponse.ApiResponse;
import com.example.springbootproject2.Model.User;
import com.example.springbootproject2.Service.ServiceMerchant;
import com.example.springbootproject2.Service.ServiceMerchantStock;
import com.example.springbootproject2.Service.ServiceProduct;
import com.example.springbootproject2.Service.ServiceUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ControllerUser {

    private final ServiceUser serviceUser;
    private final ServiceMerchantStock serviceMerchantStock;
    private final ServiceProduct serviceProduct;


    @GetMapping("/get")
    public ResponseEntity getUser() {
        ArrayList<User> users = serviceUser.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceUser.addUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = serviceUser.updateUser(id, user);
        if (isupdated) {
            return ResponseEntity.status(200).body(new ApiResponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isdeleted = serviceUser.deleteUser(id);
        if (isdeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body (new ApiResponse("wrong id"));
    }

   @PutMapping("/purches/{userId}/{productId}/{merchantId}")
    public ResponseEntity addproduct(@PathVariable int userId, @PathVariable int productId, @PathVariable int merchantId) {

        if(serviceUser.searchID(userId) == -1){
            return ResponseEntity.status(400).body(new ApiResponse("bad request user not found"));
        }
        if (serviceMerchantStock.searchStockId(productId,merchantId) == -1){
            return ResponseEntity.status(400).body(new ApiResponse("bad request do not have item with this product"));
        }

       if (serviceUser.searchID(userId) != -1) {
           if(serviceMerchantStock.isStock(productId, merchantId)){
               if(serviceUser.getBalance(userId) >= serviceProduct.getPrice(productId))
               serviceUser.deductedBalance(userId, serviceProduct.getPrice(productId));
               serviceMerchantStock.reduceStock(productId, merchantId);
               return ResponseEntity.status(200).body(new ApiResponse(" Perches successful! "));
           }}
           return ResponseEntity.status(400).body(new ApiResponse("bad request! do not have balance"));
   }

}