package com.example.caree.service;

import com.example.caree.dao.UserDao;
import com.example.caree.dao.UserJdbcDao;
import com.example.caree.exception.UserAlreadyExistException;
import com.example.caree.model.User;

import java.util.List;

public class UserService {

    UserDao userJdbcDao = new UserJdbcDao();

    public void register(String username, String password) throws Exception {
        User user = userJdbcDao.findByUsername(username);
        if (user != null) {
            throw new UserAlreadyExistException(username);
        } else {
            User newUser = new User(username, password);
            if (!userJdbcDao.create(newUser)) {
                throw new Exception("Cannot register user");
            }
        }
    }

    public User login(String username, String password) {
        User user = userJdbcDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    List<User> fetchAllUsers() {
        return userJdbcDao.findAll();
    }


    public User fetchUserByUsername(String usernameConnected) {
        return userJdbcDao.findByUsername(usernameConnected);
    }
}