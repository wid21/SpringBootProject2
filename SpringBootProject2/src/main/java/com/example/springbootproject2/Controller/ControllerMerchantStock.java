package com.example.springbootproject2.Controller;


import com.example.springbootproject2.ApiResponse.ApiResponse;
import com.example.springbootproject2.Model.MerchantStock;
import com.example.springbootproject2.Service.ServiceMerchantStock;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/api/v1/MerchantStock")
@RestController
@RequiredArgsConstructor
public class ControllerMerchantStock {

    private final ServiceMerchantStock serviceMerchantStock;
    @GetMapping("/get")
    public ResponseEntity getStocks(){
        ArrayList <MerchantStock> stocks = serviceMerchantStock.getStocks();
        return ResponseEntity.status(200) .body(stocks);
    }

    @PostMapping("/add")
    public ResponseEntity addStocks(@RequestBody @Valid MerchantStock merchantStock, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviceMerchantStock.addStocks(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("data added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateStock(@PathVariable int id ,  @RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated =serviceMerchantStock.updateStocks(id,merchantStock);
        if(isUpdated){
            return ResponseEntity.status(400).body(new ApiResponse("stock updated"));
        }
            return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStocks(@PathVariable int id){
        boolean isdeleted =serviceMerchantStock.deleteStocks(id);
        if(isdeleted){
            return ResponseEntity.status(400).body(new ApiResponse("stock delete"));
        }
           return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @PutMapping("/addProduct/{productid}/{marchantid}/{stock}")
    public ResponseEntity addProductToMerchantStock(@PathVariable int productid ,@PathVariable int marchantid , @PathVariable int stock){
        if (serviceMerchantStock.addProductToMerchantStock(productid, marchantid, stock)) {
            return ResponseEntity.status(200).body(new ApiResponse("product added to MerchantStock"));
        }
            return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
}
}

