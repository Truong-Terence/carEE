package com.example.caree.dao;

import com.example.caree.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface UserDao extends GenericDao <User, Long>{
    User findByUsername(String username);
}
