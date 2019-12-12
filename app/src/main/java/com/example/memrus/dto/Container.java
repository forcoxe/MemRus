package com.example.memrus.dto;

public class Container {
    private int id;
    private String name;


    public Container(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Container() {
    }

    public Container(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
