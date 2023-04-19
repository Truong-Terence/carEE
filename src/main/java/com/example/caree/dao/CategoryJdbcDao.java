package com.example.caree.dao;

import com.example.caree.model.Car;
import com.example.caree.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao {


    public static Category getCategoryById(int id)  {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT * FROM category WHERE category_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return mapToCategory(resultSet);
                } else {
                    return null;
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Category mapToCategory(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        return new Category(name);
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public boolean create(Category entity) {
        return false;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        String sql = "SELECT * FROM category";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category category = mapToCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing SQL query", e);
        }
        return categories;
    }

    @Override
    public Category findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }
}
