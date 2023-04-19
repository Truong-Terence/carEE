package com.example.caree.servlet.anonymous;

import com.example.caree.dao.CategoryDao;
import com.example.caree.dao.CategoryJdbcDao;
import com.example.caree.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/list-categories")
public class ListCategoryServlet extends HttpServlet {

    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = new CategoryJdbcDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDao.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/list-category.jsp").forward(request, response);
    }
}
