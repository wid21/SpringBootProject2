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
            }}
                return false;
    }

    public boolean deleteUser(int id ){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(users);
                return true;
            }}
        return false;
    }
    public int getBalance(int userId) {
        for (int b = 0; b < users.size(); b++) {
            if (users.get(b).getId() == userId) {
                return users.get(b).getBalance();
            }}
                   return -1;
    }
    public boolean deductedBalance(int userId, double price) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                if (users.get(i).getBalance() >= price) {
                    users.get(i).setBalance((int) (users.get(i).getBalance() - price));
                }
                return true;
            }}
        return false;
    }
    public int searchID(int id){
        for(int i = 0 ; i<users.size();i++) {
            if (users.get(i).getId() == id) {
                return i;
            }}
                return -1;
    }

}
