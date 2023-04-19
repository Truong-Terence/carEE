package com.example.caree.model;


public class Car {
    private Long car_id;
    private final String name;
    private final String description;
    private final String image;
    private final Double price;
    private final Category category;

    public Car(Long car_id, String name, String description, String image, Double price, Category category) {
        this.car_id = car_id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
    }
    public Car(String name, String description, String image, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
    }

    public Long getCar_id() {
        return car_id;
    }

    public String getName() { return name;}

    public String getDescription() { return description; }

    public String getImage() { return image; }

    public Double getPrice() { return price; }

    public Long getCategory_id() { return category.getId();}

    public Category getCategory() {
        return category;
    }

}
