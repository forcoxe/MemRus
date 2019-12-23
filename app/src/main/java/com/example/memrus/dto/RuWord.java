package com.example.memrus.dto;
import java.io.Serializable;

public class RuWord implements Serializable{

    private int id;
    private String word;
    private String latin;
    private String accent;
    private int learnLevel;

    public RuWord() {
    }

    public RuWord(int id) {
        this.id = id;
    }

    public RuWord(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public RuWord(int id, String word, String latin, String accent, int learnLevel) {
        this.id = id;
        this.word = word;
        this.latin = latin;
        this.accent = accent;
        this.learnLevel = learnLevel;
    }

    public RuWord(int id, String word, String latin, String accent) {
        this.id = id;
        this.word = word;
        this.latin = latin;
        this.accent = accent;
    }


    public int getLearnLevel() {
        return learnLevel;
    }

    public void setLearnLevel(int learnLevel) {
        this.learnLevel = learnLevel;
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


    @Override
    public String toString() {
        return "RuWord{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", latin='" + latin + '\'' +
                ", accent='" + accent + '\'' +
                ", learnLevel=" + learnLevel +
                '}';
    }
}
