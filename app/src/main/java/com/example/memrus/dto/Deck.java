package com.example.memrus.dto;
import java.io.Serializable;

public class Deck implements Serializable{

    private int id;
    private String name;
    private Container container;

    public Deck() {
    }

    public Deck(int id, String name, Container container) {
        this.id = id;
        this.name = name;

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

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }


}
