package com.example.caree.dao;

import com.example.caree.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao{

    @Override
    public boolean create(User entity) {
        Connection connection = ConnectionManager.getInstance();
        String query = "INSERT INTO user(username, password) VALUES(?,?)";
        boolean insertOk = false;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, entity.getUsername());
            prepareStatement.setString(2, entity.getPassword());

            int rowsAffected = prepareStatement.executeUpdate();

            insertOk = rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertOk;
    }
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT username, password FROM user";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User u = mapToUser(resultSet);
                userList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new User(username, password);
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findByUsername(String usernameFind) {
        User userFound = null;
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT username, password FROM user WHERE username=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usernameFind);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userFound = mapToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
