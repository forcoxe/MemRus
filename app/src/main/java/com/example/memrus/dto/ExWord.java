package com.example.memrus.dto;
import java.io.Serializable;

public class ExWord implements Serializable{
    private Example example;
    private RuWord word;


    public ExWord() {
    }

    public ExWord(Example example, RuWord word) {
        this.example = example;
        this.word = word;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public RuWord getWord() {
        return word;
    }

    public void setWord(RuWord word) {
        this.word = word;
    }
}
