package com.example.memrus.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import com.example.memrus.dto.Deck;
import com.example.memrus.dto.DeckWord;
import com.example.memrus.dto.RuWord;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;

public class DeckWordDAL {

    private DatabaseHelper dbHelper; // obtener el helper
    private DeckWord deckWord;

    public DeckWordDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.deckWord = new DeckWord();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public DeckWordDAL(Context context, DeckWord deckWord) {
        this.dbHelper = new DatabaseHelper(context);
        this.deckWord = deckWord;
    }

    public boolean insertar(Deck deck,RuWord ruWord)
    {
        this.deckWord.setDeck(deck);
        this.deckWord.setWord(ruWord);

        return this.tryInsert();
    }

    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

/*
        String[] argumentos = new String[]{"Breaking Bad","Suspenso","36"};
        db.execSQL("INSERT INTO serie(nombre,categoria,capitulos) VALUES(?,?,?);", argumentos);
*/

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("id_deck", this.deckWord.getDeck().getId());
        c.put("id_word",this.deckWord.getWord().getId());


        try {
            db.insert("deck_rus_words", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public ArrayList<DeckWord> seleccionar(Deck deck)
    {
        ArrayList<DeckWord> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM deck_rus_words WHERE id_deck = ?", new String[]{ String.valueOf(deck.getId())});


        if(consulta.moveToFirst()) {
            do {
                Deck con = new Deck(consulta.getInt(0));
                int id = consulta.getInt(1);



                DeckWord deckWord = new DeckWord(con,new RuWord(id));
                lista.add(deckWord);
                /*
                // forma B
                Serie serie = new Serie();
                serie.setId(id);
                serie.setNombre(nombre);*/

            } while(consulta.moveToNext());

        }

        // EJ: Where con parámetros
        // Cursor consulta = db.rawQuery("SELECT * FROM serie WHERE categoria = ?", new String[]{ String.valueOf("Sci-fi") });

        return lista;
    }

    public DeckWord getDeckWord()
    {
        return this.deckWord;
    }

}
