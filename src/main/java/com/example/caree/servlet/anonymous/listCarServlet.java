package com.example.caree.servlet.anonymous;

import com.example.caree.dao.CarJdbcDao;
import com.example.caree.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = listCarServlet.URL)
public class listCarServlet extends HttpServlet {

    public static final String URL = ("/list-car");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarJdbcDao CarJdbcDao = new CarJdbcDao();
        List<Car> cars = CarJdbcDao.findAll();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/list-car.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("car_id"));
        CarJdbcDao carDao = new CarJdbcDao();
        carDao.deleteById(carId);
        response.sendRedirect(request.getContextPath() + URL);
    }
}