package com.example.baitap1.services.implement;

import com.example.baitap1.services.interfaces.UserServiesInt;
import com.example.baitap1.dao.implement.UserDaoImp;
import com.example.baitap1.dao.interfaces.UserDaoInt;
import com.example.baitap1.model.UserModel;

public class UserServicesImp implements UserServiesInt {
    private UserDaoInt userDao = new UserDaoImp();

    @Override
    public UserModel getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public boolean addUser(UserModel user) {
        return userDao.addUser(user);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = userDao.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean checkUser(String username) {
        return userDao.getUser(username) != null;
    }

    public static void main(String[] args) {
        UserServiesInt userServicesInt = new UserServicesImp();
        UserModel user = new UserModel();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@gmail.com");
        user.setRole(1);
        user.setPhone("0123456789");
        user.setCreatedDate(new java.util.Date());
        System.out.println(userServicesInt.addUser(user));
    }
}

