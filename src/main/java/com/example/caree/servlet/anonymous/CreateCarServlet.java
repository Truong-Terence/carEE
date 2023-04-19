package com.example.caree.servlet.anonymous;

import com.example.caree.dao.CarDao;
import com.example.caree.dao.CarJdbcDao;
import com.example.caree.dao.CategoryDao;
import com.example.caree.dao.CategoryJdbcDao;
import com.example.caree.model.Car;
import com.example.caree.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

    @WebServlet(urlPatterns = CreateCarServlet.URL)
public class CreateCarServlet extends HttpServlet {
        public static final String URL = ("/create-car");

        CarDao carDao = new CarJdbcDao();
        CategoryDao categoryDao = new CategoryJdbcDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        Double price = Double.valueOf(request.getParameter("price"));
        Long categoryId = Long.valueOf(request.getParameter("category_id"));

        Category category = categoryDao.findById(Long.valueOf(categoryId));
        Car car = new Car(name, description, image, price, category);
        carDao.create(car);

        response.sendRedirect(request.getContextPath() + "/list-car");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDao.findAll());

        request.getRequestDispatcher("/WEB-INF/add-car.jsp").forward(request, response);
    }
}
