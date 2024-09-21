package com.example.baitap1.controller;

import com.example.baitap1.dao.implement.UserDaoImp;
import com.example.baitap1.model.UserModel;
import com.example.baitap1.controller.Logout;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {
    private UserDaoImp userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String secretQuestion = request.getParameter("secretQuestion");
        String secretAnswer = request.getParameter("secretAnswer");
        String newPassword = request.getParameter("newPassword");

        UserModel user = userDao.getUser(username);
        if (user != null && secretQuestion.equals(user.getSecretQuestion()) && secretAnswer.equals(user.getSecretAnswer())) {
            user.setPassword(newPassword);
            userDao.updateUser(user);
            // logout
            request.getSession().removeAttribute("user");
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            // Show error message
            response.getWriter().println("Invalid details. Please try again.");
        }
    }
}