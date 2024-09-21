package com.example.baitap1.controller;

import com.example.baitap1.model.UserModel;
import com.example.baitap1.services.implement.UserServicesImp;
import com.example.baitap1.services.interfaces.UserServiesInt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private UserServiesInt userServicesInt = new UserServicesImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserModel user = userServicesInt.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("message", "Username or password is incorrect");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
