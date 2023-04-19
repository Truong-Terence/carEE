package com.example.caree.dao;

import com.example.caree.model.User;

public interface UserDao extends GenericDao <User, Long>{
    User findByUsername(String username);
}
