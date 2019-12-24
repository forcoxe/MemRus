package com.example.memrus.dto;
import java.io.Serializable;

public class EnWord implements Serializable {

    private int id;
    private String word;

    public EnWord() {
    }

    public EnWord(int id) {
        this.id = id;
    }

    public EnWord(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


}
