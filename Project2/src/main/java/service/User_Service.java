package service;

import model.Product;
import model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class User_Service {
    private ArrayList<User> userList=new ArrayList<>();

    public ArrayList<User> getUser(){
        return userList;
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void updateUser(int index, User user) {
        userList.set(index,user);
    }
    public void deleteUser(int index) {
        userList.remove(index);
    }



public int
   public static User getUser(String userid) {
       for (User user : userList) {
            if (user.getId().equals(userid)) {
                return user;
           }
        }
        return null;
   }
}
