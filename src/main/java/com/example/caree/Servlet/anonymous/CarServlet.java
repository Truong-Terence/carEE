package com.example.caree.Servlet.anonymous;

import com.example.caree.dao.CarDao;
import com.example.caree.dao.CarJdbcDao;
import com.example.caree.model.Car;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {

}
