package com.example.baitap1.services.interfaces;

import java.security.PublicKey;
import com.example.baitap1.model.UserModel;

public interface UserServiesInt {
    UserModel getUser(String username);
    boolean addUser(UserModel user);
    public UserModel login(String username, String password);
    public boolean checkUser(String username);
}
