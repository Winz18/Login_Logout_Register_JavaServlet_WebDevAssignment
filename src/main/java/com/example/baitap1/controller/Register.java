package com.example.baitap1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.baitap1.model.UserModel;
import com.example.baitap1.services.implement.UserServicesImp;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = new UserModel();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setSecretQuestion(req.getParameter("secretQuestion"));
        user.setSecretAnswer(req.getParameter("secretAnswer"));
        user.setRole(2);
        user.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
        try {
            UserServicesImp userServicesImp = new UserServicesImp();
            if (userServicesImp.addUser(user)) {
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                req.setAttribute("message", "Register failed");
                req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Register failed");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
