package com.example.caree.Servlet.secured;

import com.example.caree.model.User;
import com.example.caree.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = UserProfileServlet.URL)
public class UserProfileServlet extends HttpServlet {

    public static final String URL = "/secured/profile";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        String usernameConnected = (String) session.getAttribute("username");
        User user = userService.fetchUserByUsername(usernameConnected);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}