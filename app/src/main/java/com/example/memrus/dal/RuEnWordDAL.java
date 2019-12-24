package com.example.memrus.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.memrus.dto.EnWord;
import com.example.memrus.dto.RuEn;
import com.example.memrus.dto.RuWord;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;


public class RuEnWordDAL {


    private DatabaseHelper dbHelper; // obtener el helper
    private RuEn ruEn;

    public RuEnWordDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.ruEn = new RuEn();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public RuEnWordDAL(Context context, RuEn ruEn) {
        this.dbHelper = new DatabaseHelper(context);
        this.ruEn = ruEn;
    }

    public ArrayList<RuEn> seleccionar(RuWord ruWord)
    {
        ArrayList<RuEn> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM ru_en WHERE id_ru_word = ?", new String[]{ String.valueOf(ruWord.getId())});


        if(consulta.moveToFirst()) {
            do {
                EnWord con2 = new EnWord(consulta.getInt(0));
                RuWord con = new RuWord(consulta.getInt(1));




                RuEn deckWord = new RuEn(con,con2);
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

    public RuEn getRuEnWord()
    {
        return this.ruEn;
    }
}
