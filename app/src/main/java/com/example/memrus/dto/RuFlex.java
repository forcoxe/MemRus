package com.example.memrus.dto;
import java.io.Serializable;

public class RuFlex implements Serializable{
    private int id;
    private RuWord word;
    private String meaningRu;
    private String meaningEn;
    private String meaningEs;


    public RuFlex() {
    }

    public RuFlex(int id, RuWord word, String meaningRu, String meaningEn, String meaningEs) {
        this.id = id;
        this.word = word;
        this.meaningRu = meaningRu;
        this.meaningEn = meaningEn;
        this.meaningEs = meaningEs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RuWord getWord() {
        return word;
    }

    public void setWord(RuWord word) {
        this.word = word;
    }

    public String getMeaningRu() {
        return meaningRu;
    }

    public void setMeaningRu(String meaningRu) {
        this.meaningRu = meaningRu;
    }

    public String getMeaningEn() {
        return meaningEn;
    }

    public void setMeaningEn(String meaningEn) {
        this.meaningEn = meaningEn;
    }

    public String getMeaningEs() {
        return meaningEs;
    }

    public void setMeaningEs(String meaningEs) {
        this.meaningEs = meaningEs;
    }
}
