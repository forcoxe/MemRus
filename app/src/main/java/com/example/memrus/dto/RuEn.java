package com.example.memrus.dto;

public class RuEn {
    private RuWord ruWord;
    private EnWord enWord;

    public RuEn() {
    }

    public RuEn(RuWord ruWord, EnWord enWord) {
        this.ruWord = ruWord;
        this.enWord = enWord;
    }

    public RuWord getRuWord() {
        return ruWord;
    }

    public void setRuWord(RuWord ruWord) {
        this.ruWord = ruWord;
    }

    public EnWord getEnWord() {
        return enWord;
    }

    public void setEnWord(EnWord enWord) {
        this.enWord = enWord;
    }
}
