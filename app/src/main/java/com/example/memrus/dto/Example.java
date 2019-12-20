package com.example.memrus.dto;
import java.io.Serializable;

public class Example implements Serializable{
    private int id;
    private String content;

    public Example() {
    }

    public Example(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
