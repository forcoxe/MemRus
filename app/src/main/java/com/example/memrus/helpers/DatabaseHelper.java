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

        db.execSQL("create table containers(id_container INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, category INTEGER);");
        db.execSQL("create table decks (id_deck INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, id_container INTEGER, FOREIGN KEY (id_container) REFERENCES Containers(id_container));");
        db.execSQL("create table ru_words(id_ru_word INTEGER PRIMARY KEY AUTOINCREMENT, ru_word TEXT, ru_word_l TEXT, ru_word_a TEXT, learn_level INTEGER);");
        db.execSQL("create table en_words(id_en_word INTEGER PRIMARY KEY AUTOINCREMENT, en_word TEXT);");
        db.execSQL("create table es_words(id_es_word INTEGER PRIMARY KEY AUTOINCREMENT, es_word TEXT);");
        db.execSQL("create table examples(id_example INTEGER PRIMARY KEY AUTOINCREMENT, content TEXT, content_en TEXT, type INTEGER);");
        db.execSQL("create table deck_rus_words(id_deck INTEGER, id_word INTEGER , FOREIGN KEY (id_deck) REFERENCES Decks(id_deck), FOREIGN KEY (id_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ru_en(id_en_word INTEGER, id_ru_word INTEGER,  FOREIGN KEY (id_en_word) REFERENCES En_words(id_en_word), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ru_es(id_es_word INTEGER, id_ru_word INTEGER, FOREIGN KEY (id_es_word) REFERENCES Es_words(id_es_word), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");
        db.execSQL("create table ex_words(id_example INTEGER, id_ru_word INTEGER, FOREIGN KEY (id_example) REFERENCES Examples(id_example), FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");

       db.execSQL("create table ru_flex(id_flex INTEGER PRIMARY KEY AUTOINCREMENT, id_ru_word INTEGER, flex_desc_en TEXT, flex_desc_es TEXT, FOREIGN KEY (id_ru_word) REFERENCES Ru_words(id_ru_word));");

        //POBLAR TABLAS
        db.execSQL("insert into containers values(NULL,'verbs1',0);");
        db.execSQL("insert into containers values(NULL,'nouns1',0);");
        db.execSQL("insert into containers values(NULL,'adjectives1',0);");

        db.execSQL("insert into decks values(NULL,'verbs1 - 1','1');");
        db.execSQL("insert into decks values(NULL,'verbs1 - 2','1');");
        db.execSQL("insert into decks values(NULL,'verbs1 - 3','1');");
        db.execSQL("insert into decks values(NULL,'nouns1 - 1','2');");
        db.execSQL("insert into decks values(NULL,'adjectives1 - 1','3');");


        db.execSQL("insert into ru_words values(NULL,'удалять','udalyat','удаля́ть',0);");
        db.execSQL("insert into ru_words values(NULL,'умереть','umeret','умере́ть',0);");
        db.execSQL("insert into ru_words values(NULL,'верить','verit','ве́рить',0);");
        db.execSQL("insert into ru_words values(NULL,'слово','slovo','сло́во',0);");
        db.execSQL("insert into ru_words values(NULL,'дом','dom','до́м',0);");
        db.execSQL("insert into ru_words values(NULL,'прекрасный','prekrasnyy','прекра́сный',0);");
        db.execSQL("insert into ru_words values(NULL,'хорошенький','khoroshen-kiy','хоро́шенький',0);");
        db.execSQL("insert into ru_words values(NULL,'бежать','bezhat','бежа́́ть',0);");
        db.execSQL("insert into ru_words values(NULL,'класть','klast','кла́сть',0);");

        // DECK VERBS

        db.execSQL("insert into deck_rus_words values(1,1);");
        db.execSQL("insert into deck_rus_words values(1,2);");
        db.execSQL("insert into deck_rus_words values(1,3);");
        db.execSQL("insert into deck_rus_words values(2,8);");
        db.execSQL("insert into deck_rus_words values(3,9);");
        //DECK NOUNS
        db.execSQL("insert into deck_rus_words values(4,4);");
        db.execSQL("insert into deck_rus_words values(4,5);");
        //DECK Adjectvives
        db.execSQL("insert into deck_rus_words values(5,6);");

        db.execSQL("insert into en_words values(NULL,'die');");
        db.execSQL("insert into en_words values(NULL,'delete');");
        db.execSQL("insert into en_words values(NULL,'believe');");
        db.execSQL("insert into en_words values(NULL,'word');");
        db.execSQL("insert into en_words values(NULL,'house');");
        db.execSQL("insert into en_words values(NULL,'beautiful');");
        db.execSQL("insert into en_words values(NULL,'run');");
        db.execSQL("insert into en_words values(NULL,'put');");

        db.execSQL("insert into ru_en values(2,1);");
        db.execSQL("insert into ru_en values(1,2);");
        db.execSQL("insert into ru_en values(3,3);");
        db.execSQL("insert into ru_en values(4,4);");
        db.execSQL("insert into ru_en values(5,5);");
        db.execSQL("insert into ru_en values(6,6);");
        db.execSQL("insert into ru_en values(6,7);");
        db.execSQL("insert into ru_en values(7,8);");
        db.execSQL("insert into ru_en values(8,9);");

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
