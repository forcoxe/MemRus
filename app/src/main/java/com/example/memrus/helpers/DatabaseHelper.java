package com.example.memrus.helpers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Definimos los atributos para el nombre de la BD
    // y su versión de nuestra aplicación
    public static final String DATABASE_NAME = "memrus.db";
    public static final int DATABASE_VERSION = 1;

    // Elaboramos el constructor en base a los parámetros necesarios
    // por la superclase (padre)
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Método obligatorio de la interfaz para crear la base de datos
    // en caso de que la app ejecutada en el teléfono móvil
    // no la tenga creada.
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table container(id_container INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, category INTEGER);");
        db.execSQL("create table decks (id_deck INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, id_container INTEGER, FOREIGN KEY (id_container) REFERENCES Container(id_container));");
        db.execSQL("create table ru_words(id_ru_word INTEGER PRIMARY KEY AUTOINCREMENT, ru_word TEXT, ru_word_l TEXT, ru_word_a TEXT, learn_level INTEGER);");
        db.execSQL("create table en_words(id_en_word INTEGER PRIMARY KEY AUTOINCREMENT, en_word TEXT);");
        db.execSQL("create table es_words(id_es_word INTEGER PRIMARY KEY AUTOINCREMENT, es_word TEXT);");
        db.execSQL("create table examples(id_example INTEGER PRIMARY KEY AUTOINCREMENT, content TEXT);");
        db.execSQL("create table deck_rus_words(id_deck INTEGER, id_word INTEGER , FOREIGN KEY (id_deck) REFERENCES Decks(id_deck), FOREIGN KEY (id_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ru_en(id_en_word INTEGER, id_ru_word INTEGER,  FOREIGN KEY (id_en_word) REFERENCES En_words(id_en_word), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ru_es(id_es_word INTEGER, id_ru_word INTEGER, FOREIGN KEY (id_es_word) REFERENCES Es_words(id_es_word), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ex_words(id_example INTEGER, id_ru_word INTEGER, FOREIGN KEY (id_example) REFERENCES Examples(id_example), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");

       db.execSQL("create table ru_flex(id_flex INTEGER PRIMARY KEY AUTOINCREMENT, id_ru_word INTEGER, flex_desc_en TEXT, flex_desc_es TEXT, FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
