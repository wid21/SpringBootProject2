package com.example.springbootproject2.Service;

import com.example.springbootproject2.Model.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class ServiceProduct {

    ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public boolean updateProducts(@PathVariable int id, @Valid @RequestBody Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(@PathVariable int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;

    }
    //find the price of the product by given id
    public int getPrice(int productid) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productid) {
                products.get(i).getPrice();
                return 1;
            }
        }
        return -1;
    }
}
