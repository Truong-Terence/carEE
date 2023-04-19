package com.example.caree.dao;

import com.example.caree.model.Car;

public interface CarDao extends GenericDao <Car, Long> {

    Car findByName(String name);


}
