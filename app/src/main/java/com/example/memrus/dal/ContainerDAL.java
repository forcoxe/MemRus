package com.example.memrus.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.memrus.dto.Container;
import com.example.memrus.helpers.DatabaseHelper;

import java.util.ArrayList;


public class ContainerDAL {
    private DatabaseHelper dbHelper; // obtener el helper
    private Container container;

    public ContainerDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.container = new Container();
        // Testing
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public ContainerDAL(Context context, Container container) {
        this.dbHelper = new DatabaseHelper(context);
        this.container = container;
    }

    public boolean insertar() {
        return this.tryInsert();
    }

    public boolean insertar(String name, int category)
    {
        this.container.setName(name);
        this.container.setCategory(category);


        return this.tryInsert();
    }

    public ArrayList<Container> seleccionar()
    {
        ArrayList<Container> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM container", null);

        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String nombre = consulta.getString(1);
                int category = consulta.getInt(2);

                Container container = new Container(id,nombre,category);
                lista.add(container);
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


    public boolean actualizar(int id, Container container)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("name", container.getName());
        c.put("category", container.getCategory());
        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "container",
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
        c.put("container", container.getName());
        c.put("container", container.getCategory());

        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "container",
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
            filasAfectadas = db.delete("container","id = ?",
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
        c.put("nombre", this.container.getName());
        c.put("nombre", this.container.getCategory());


        try {
            db.insert("container", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public Container getContainer()
    {
        return this.container;
    }
}
