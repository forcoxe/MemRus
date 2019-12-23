package com.example.memrus.dal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.memrus.dto.DeckWord;
import com.example.memrus.dto.RuWord;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;

public class RuWordDAL {

    private DatabaseHelper dbHelper; // obtener el helper
    private RuWord ruWord;

    public boolean insertar(String word, String latin, String accent, int level)
    {
        this.ruWord.setWord(word);
        this.ruWord.setLatin(latin);
        this.ruWord.setAccent(accent);
        this.ruWord.setId(level);
        return this.tryInsert();
    }

    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

/*
        String[] argumentos = new String[]{"Breaking Bad","Suspenso","36"};
        db.execSQL("INSERT INTO serie(nombre,categoria,capitulos) VALUES(?,?,?);", argumentos);
*/

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("ru_word", this.ruWord.getWord());
        c.put("ru_word_l",this.ruWord.getLatin());
        c.put("ru_word_a",this.ruWord.getAccent());
        c.put("learn_level",this.ruWord.getLearnLevel());

        try {
            db.insert("ru_words", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public RuWordDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.ruWord = new RuWord();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public RuWordDAL(Context context, RuWord ruWord) {
        this.dbHelper = new DatabaseHelper(context);
        this.ruWord = ruWord;
    }

    public RuWord seleccionar(DeckWord deckWord)
    {
        ArrayList<RuWord> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();



        Cursor consulta = db.rawQuery("SELECT * FROM ru_words WHERE id_ru_word = ?", new String[]{ String.valueOf(deckWord.getWord().getId())});


        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String word = consulta.getString(1);
                String latin = consulta.getString(2);
                String accent = consulta.getString(3);
                int learnLevel = consulta.getInt(4);



                RuWord ruWord = new RuWord(id,word,latin,accent,learnLevel);
                lista.add(ruWord);
                /*
                // forma B
                Serie serie = new Serie();
                serie.setId(id);
                serie.setNombre(nombre);*/

            } while(consulta.moveToNext());

        }

        // EJ: Where con parámetros
        // Cursor consulta = db.rawQuery("SELECT * FROM serie WHERE categoria = ?", new String[]{ String.valueOf("Sci-fi") });

        return lista.get(0);
    }

    public RuWord getWord()
    {
        return this.ruWord;
    }
}
