package com.example.baitap1.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.baitap1.ConnectDB;
import com.example.baitap1.dao.interfaces.UserDaoInt;
import com.example.baitap1.model.UserModel;

public class UserDaoImp implements UserDaoInt {
    private Connection connection;

    public UserDaoImp() {
        this.connection = ConnectDB.getConnection();
    }

    @Override
    public UserModel getUser(String username) {
        UserModel user = null;
        try {
            String sql = "SELECT * FROM baitap1 WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getInt("role"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("created_date"));
                user.setSecretQuestion(rs.getString("secret_question"));
                user.setSecretAnswer(rs.getString("secret_answer"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(UserModel user) {
        String sql = "INSERT INTO baitap1 (username, password, email, role, phone, created_date, secret_question, secret_answer) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getRole());
            ps.setString(5, user.getPhone());
            ps.setDate(6, new java.sql.Date(user.getCreatedDate().getTime()));
            ps.setString(7, user.getSecretQuestion());
            ps.setString(8, user.getSecretAnswer());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(UserModel user) {
        String sql = "UPDATE baitap1 SET password = ?, email = ?, phone = ?, secret_question = ?, secret_answer = ? WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getSecretQuestion());
            ps.setString(5, user.getSecretAnswer());
            ps.setString(6, user.getUsername());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}