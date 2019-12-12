package com.example.memrus.dto;

public class Deck {

    private int id;
    private String name;
    private int category;
    private Container container;

    public Deck() {
    }

    public Deck(int id, String name, int category, Container container) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.container = container;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }


}
