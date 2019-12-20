package com.example.memrus.dto;
import java.io.Serializable;

public class RuEs implements Serializable {
    private RuWord ruWord;
    private EsWord esWord;

    public RuEs() {
    }

    public RuEs(RuWord ruWord, EsWord esWord) {
        this.ruWord = ruWord;
        this.esWord = esWord;
    }

    public RuWord getRuWord() {
        return ruWord;
    }

    public void setRuWord(RuWord ruWord) {
        this.ruWord = ruWord;
    }

    public EsWord getEsWord() {
        return esWord;
    }

    public void setEsWord(EsWord esWord) {
        this.esWord = esWord;
    }
}
