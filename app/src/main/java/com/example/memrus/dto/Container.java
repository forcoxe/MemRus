package com.example.memrus.dto;
import java.io.Serializable;

public class Container implements Serializable{
    private int id;
    private String name;
    private int category;


    public Container(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Container(int id, String name, int category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return

                name;
    }
}
