package com.example.caree.dao;

import com.example.caree.model.Car;
import com.example.caree.model.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarJdbcDao implements CarDao {

    @Override
    public boolean create(Car entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO car(name, description, image, price, category_id) VALUES(?,?,?,?,?)";
        boolean insertOk = false;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, entity.getName());
            prepareStatement.setString(2, entity.getDescription());
            prepareStatement.setString(3, entity.getImage());
            prepareStatement.setDouble(4, entity.getPrice());
            prepareStatement.setLong(5, entity.getCategory_id());

            int rowsAffected = prepareStatement.executeUpdate();

            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertOk;
    }
    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT car_id, name, description, image, price, category_id FROM car";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Car c = mapToCar(resultSet);
                carList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
    private static Car mapToCar(ResultSet resultSet) throws SQLException {
        Long car_id = resultSet.getLong("car_id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        String image = resultSet.getString("image");
        Double price = resultSet.getDouble("price");
        int categoryId = resultSet.getInt("category_id");
        Category category = CategoryJdbcDao.getCategoryById(categoryId);
        return new Car(car_id, name, description,image, price, category);
    }
    @Override
    public Car findById(Long carId) {
        String query = "SELECT * FROM car WHERE car_id = ?";
        Car car = null;
        try {
            Connection connection = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = mapToCar(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
    @Override
    public void update(Car entity) {

    }

    @Override
    public void delete(Car entity) {

    }

    public void deleteById(Long carId) {
        try {
        Connection connection = ConnectionManager.getInstance();
         PreparedStatement statement = connection.prepareStatement("DELETE FROM car WHERE car_id = ?");
        statement.setLong(1, carId);
        statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findByName(String nameFind) {
        Car carFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT name, description, image, price, category_id FROM car WHERE name=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nameFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carFound = mapToCar(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carFound;
    }
}
