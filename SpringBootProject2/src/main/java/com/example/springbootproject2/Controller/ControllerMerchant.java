package com.example.springbootproject2.Controller;


import com.example.springbootproject2.ApiResponse.ApiResponse;
import com.example.springbootproject2.Model.Merchant;
import com.example.springbootproject2.Service.ServiceMerchant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/v1/Merchant")
@RestController
@RequiredArgsConstructor
public class ControllerMerchant {

    private final ServiceMerchant serviceMerchant;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant>merchants =serviceMerchant.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceMerchant.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse(" Merchant added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id , @RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated = serviceMerchant.updateMerchant(id,merchant);
        if(isupdated){
            return ResponseEntity.status(200).body("Merchant updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMerchant(@PathVariable int id ){
        boolean isdeleted= serviceMerchant.deleteMerchant(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("Merchant deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
}
