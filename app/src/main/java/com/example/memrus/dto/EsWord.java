package com.example.memrus.dto;

public class EsWord {
    private int id;
    private String word;

    public EsWord() {
    }

    public EsWord(int id, String word) {
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
