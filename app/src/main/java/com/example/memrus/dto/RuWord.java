package com.example.memrus.dto;

public class RuWord {

    private int id;
    private String word;
    private String latin;
    private String accent;

    public RuWord() {
    }

    public RuWord(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public RuWord(int id, String word, String latin, String accent) {
        this.id = id;
        this.word = word;
        this.latin = latin;
        this.accent = accent;
    }


    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getAccent() {
        return accent;
    }

    public void setAccent(String accent) {
        this.accent = accent;
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
