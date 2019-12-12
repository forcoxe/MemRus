package com.example.memrus.dto;

public class DeckWord {
    private Deck deck;
    private RuWord word;


    public DeckWord() {
    }

    public DeckWord(Deck deck, RuWord word) {
        this.deck = deck;
        this.word = word;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public RuWord getWord() {
        return word;
    }

    public void setWord(RuWord word) {
        this.word = word;
    }


}
