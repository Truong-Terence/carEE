package com.example.caree.servlet.anonymous;

import com.example.caree.dao.CarDao;
import com.example.caree.dao.CarJdbcDao;
import com.example.caree.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/car-view")
public class CarViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDao carDao = new CarJdbcDao();
        String idParam = request.getParameter("car_id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        Long carId = Long.parseLong(idParam);
        Car car = carDao.findById(carId);

//        if (car == null) {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }

        request.setAttribute("car", car);
        request.getRequestDispatcher("/WEB-INF/car-view.jsp").forward(request, response);
    }
}
