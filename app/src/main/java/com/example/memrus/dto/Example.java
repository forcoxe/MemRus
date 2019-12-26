package com.example.memrus.dto;
import java.io.Serializable;

public class Example implements Serializable{
    private int id;
    private String content;
    private String contentEn;
    private int isRussian;

    public Example() {
    }

    public Example(int id) {
        this.id = id;
    }

    public Example(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Example(int id, String content, String contentEn) {
        this.id = id;
        this.content = content;
        this.contentEn = contentEn;
    }

    public Example(int id, String content, String contentEn, int isRussian) {
        this.id = id;
        this.content = content;
        this.contentEn = contentEn;
        this.isRussian = isRussian;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public int getIsRussian() {
        return isRussian;
    }

    public void setIsRussian(int isRussian) {
        this.isRussian = isRussian;
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
