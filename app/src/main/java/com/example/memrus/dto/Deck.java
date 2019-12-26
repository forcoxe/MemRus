package com.example.memrus.dto;
import com.example.memrus.dal.DeckWordDAL;

import java.io.Serializable;

public class Deck implements Serializable{

    private int id;
    private String name;
    private Container container;

    private int cantidad = 0;


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Deck() {
    }

    public Deck(int id, String name, Container container) {
        this.id = id;
        this.name = name;

        this.container = container;
    }

    public Deck(int id) {
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

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String toString() {

        return name + "             -           " + cantidad+" words";

    }
}
