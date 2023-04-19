package com.example.caree.dao;

import com.example.caree.model.Car;
import com.example.caree.model.Category;

public interface CategoryDao extends GenericDao <Category, Long> {
    Category findByName(String name);
}
