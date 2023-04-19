package com.example.caree.Servlet.anonymous;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        req.setAttribute("username", username);
        req.setAttribute("password", password);

        boolean isInvalid = username.isBlank() || password.isBlank();
        if (isInvalid) {
            req.setAttribute("form_validation_error", true);
        } else {
            try {
                UserService userService = new UserService();
                userService.register(username, password);
                resp.sendRedirect(req.getContextPath() + LoginServlet.URL);
                return;
            } catch (UserAlreadyExistException e) {
                req.setAttribute("duplicate_user_error", true);
            } catch (Exception e) {
                req.setAttribute("register_error", true);
                req.setAttribute("username", username);
                req.setAttribute("password", password);
            }
        }
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }
}
