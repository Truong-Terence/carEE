package com.example.caree.model;

public class Category {
    private String name;
    private Long category_id;

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return category_id;
    }
    public void setId(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

}
