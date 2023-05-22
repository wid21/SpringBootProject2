package com.example.springbootproject2.Service;

import com.example.springbootproject2.Model.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service

public class ServiceCategory {
    ArrayList<Category> categories=new ArrayList<>();
    public ArrayList<Category> getCategories(){
        return categories;
    }

    public void addCategories(Category category){
        categories.add(category);
    }

    public boolean updateCategories(@PathVariable int id , @RequestBody @Valid Category category){

        for (int i=0; i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.set(i,category);
                return true;
            }}
                return  false ;
    }

    public boolean deleteCategories(@PathVariable int id ){
        for (int i=0; i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }}
                return  false ;
    }
}

