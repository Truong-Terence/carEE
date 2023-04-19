package com.example.caree.servlet.anonymous;

import java.io.*;
import java.util.List;

import com.example.caree.dao.CarJdbcDao;
import com.example.caree.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = IndexServlet.URL)
public class IndexServlet extends HttpServlet {

    public static final String URL = ("/");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarJdbcDao CarJdbcDao = new CarJdbcDao();
        List<Car> cars = CarJdbcDao.findAll();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}