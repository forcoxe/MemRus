package com.example.memrus.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.memrus.dto.EnWord;
import com.example.memrus.dto.RuEn;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;


public class EnWordDAL {

    private DatabaseHelper dbHelper; // obtener el helper
    private EnWord enWord;

    public EnWordDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.enWord = new EnWord();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public EnWordDAL(Context context, EnWord enWord) {
        this.dbHelper = new DatabaseHelper(context);
        this.enWord = enWord;
    }

    public EnWord seleccionar(RuEn ruEn)
    {
        ArrayList<EnWord> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        Cursor consulta = db.rawQuery("SELECT * FROM en_words WHERE id_en_word = ?", new String[]{ String.valueOf(ruEn.getEnWord().getId())});


        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String word = consulta.getString(1);




                EnWord enWord = new EnWord(id,word);
                lista.add(enWord);
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

    public EnWord getWord()
    {
        return this.enWord;
    }
}
