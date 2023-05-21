package com.example.springbootproject2.Service;

import com.example.springbootproject2.Model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class ServiceUser {


    ArrayList<User>users=new ArrayList<>();

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUsers(User user){

        users.add(user);
    }

    public boolean updateUser(@PathVariable int id , @RequestBody @Valid User user){
        for (int i =0 ; i<users.size(); i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id ){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(users);
                return true;
            }
        }
        return false;
    }


    //serach foe id in list of users
    public int searchID(int id){
        for(int i = 0 ; i<users.size();i++)
            if(users.get(i).getId() == id)
                return i;
        return -1;
    }

    //check for the balance then reduce the price of the product
    public boolean changeBalance(int userId ,double price){
        if(users.get(searchID(userId)).getBalance() >= price) {
            users.get(searchID(userId)).setBalance(users.get(searchID(userId)).getBalance() - price);
            return true;
        }
        return false;
    }


}
