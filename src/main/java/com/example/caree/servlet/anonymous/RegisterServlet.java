package com.example.caree.servlet.anonymous;

import com.example.caree.exception.UserAlreadyExistException;
import com.example.caree.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = RegisterServlet.URL)
public class RegisterServlet extends HttpServlet {

    public static final String URL = "/register";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        request.setAttribute("username", username);
        request.setAttribute("password", password);

        boolean isInvalid = username.isBlank() || password.isBlank();
        if (isInvalid) {
            request.setAttribute("form_validation_error", true);
        } else {
            try {
                UserService userService = new UserService();
                userService.register(username, password);
                response.sendRedirect(request.getContextPath() + LoginServlet.URL);
                return;
            } catch (UserAlreadyExistException e) {
                request.setAttribute("duplicate_user_error", true);
            } catch (Exception e) {
                request.setAttribute("register_error", true);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
            }
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
