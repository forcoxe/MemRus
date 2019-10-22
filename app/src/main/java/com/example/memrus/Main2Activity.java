package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Lista de decks
        ListView lista;
        String[] values = new String[]{"verbs1","nouns1","Interjections1"};
        ArrayAdapter<String> adaptador;
        lista =  findViewById(R.id.listDecks);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        lista.setAdapter(adaptador);



    }
}
