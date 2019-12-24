package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.memrus.dal.ContainerDAL;
import com.example.memrus.dal.DeckDAL;
import com.example.memrus.dto.Container;
import com.example.memrus.dto.Deck;

import java.util.ArrayList;

public class ListaDecks extends AppCompatActivity {

    private ContainerDAL containerDAL;
    private DeckDAL deckDAL;
    private ListView listaDeckView;
    private int codPosicion = 0;
    private ArrayAdapter<Deck> adapter;
    private ArrayList<Deck> listDecks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_decks);


        this.containerDAL = new ContainerDAL(getApplicationContext(), (Container) getIntent().getSerializableExtra("container") );
        this.deckDAL = new DeckDAL(getApplicationContext(), new Deck());
        this.listDecks = deckDAL.seleccionar(this.containerDAL.getContainer());

        // i.- Enlazar la interfaz gráfica al componente
        this.listaDeckView = (ListView) findViewById(R.id.listDeckus);


        // ii.- Crear ArrayAdapter y asociarlo al cRud
        this.adapter = new ArrayAdapter<Deck>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                this.listDecks
        ){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };

        listaDeckView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirWordsActivity();
            }
        });


        // iii.- Asociar el ArrayAdapter al componente ListView
        this.listaDeckView.setAdapter(adapter);


    }

    private void abrirWordsActivity() {
        Intent intento = new Intent(ListaDecks.this, SlideActivity.class);
        Deck d = (Deck) listDecks.get(codPosicion);

        intento.putExtra("deck", d);


        startActivityForResult(intento, 100);
    }
}
