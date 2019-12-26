package com.example.memrus.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.memrus.dto.Container;
import com.example.memrus.dto.Deck;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;


public class DeckDAL {

    private DatabaseHelper dbHelper; // obtener el helper
    private Deck deck;


    public DeckDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.deck = new Deck();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public DeckDAL(Context context, Deck deck) {
        this.dbHelper = new DatabaseHelper(context);
        this.deck = deck;
    }

    public boolean insertar() {
        return this.tryInsert();
    }

    public boolean insertar(String name,Container container)
    {
        this.deck.setName(name);

        this.deck.setContainer(container);

        return this.tryInsert();
    }
    public ArrayList<Deck> seleccionar(Container container)
    {
        ArrayList<Deck> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM decks WHERE id_container = ?", new String[]{ String.valueOf(container.getId())});


        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String nombre = consulta.getString(1);
                Container con = new Container(consulta.getInt(1));

                Deck deck = new Deck(id,nombre,con);
                lista.add(deck);
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

    public ArrayList<Deck> seleccionar()
    {
        ArrayList<Deck> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM deck", null);

        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String nombre = consulta.getString(1);
                Container container = new Container(consulta.getInt(1));

                Deck deck = new Deck(id,nombre,container);
                lista.add(deck);
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


    public boolean actualizar(int id, Deck deck)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("name", deck.getName());
        c.put("category", deck.getName());


        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "deck",
                    c,
                    "id = ?",
                    new String[] { String.valueOf(id) }
            );
            // if(filasAfectadas > 0) return true; else return false;
            return (filasAfectadas > 0);
        } catch (Exception e) {

        }

        return false;
    }


    public boolean actualizar(Container container)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("name", deck.getName());


        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "deck",
                    c,
                    "id = ?",
                    new String[] { String.valueOf(container.getId()) }
            );
            // if(filasAfectadas > 0) return true; else return false;
            return (filasAfectadas > 0);
        } catch (Exception e) {

        }

        return false;
    }

    public boolean eliminar(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int filasAfectadas;

/*        db.delete("serie","id = ? and nombre = ?",
                new String[] {
                        String.valueOf(id),
                        String.valueOf("the boys")
                });*/

        try {
            filasAfectadas = db.delete("decks","id_deck = ?",
                    new String[] { String.valueOf(id) });
        } catch (Exception e) {
            return false;
        }

        return (filasAfectadas == 1);

    }


    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

/*
        String[] argumentos = new String[]{"Breaking Bad","Suspenso","36"};
        db.execSQL("INSERT INTO serie(nombre,categoria,capitulos) VALUES(?,?,?);", argumentos);
*/

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("name", this.deck.getName());
        c.put("id_container", this.deck.getContainer().getId());


        try {
            db.insert("decks", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Deck getDeck()
    {
        return this.deck;
    }
}
