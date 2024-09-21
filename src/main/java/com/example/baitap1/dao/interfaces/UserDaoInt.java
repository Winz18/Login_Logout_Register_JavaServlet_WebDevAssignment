package com.example.baitap1.dao.interfaces;

import com.example.baitap1.model.UserModel;

public interface UserDaoInt {
    UserModel getUser(String username);
    boolean addUser(UserModel user);
    boolean updateUser(UserModel user);
}
