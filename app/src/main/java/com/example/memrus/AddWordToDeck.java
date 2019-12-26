package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.memrus.dal.ContainerDAL;
import com.example.memrus.dal.DeckDAL;
import com.example.memrus.dal.DeckWordDAL;
import com.example.memrus.dto.Container;
import com.example.memrus.dto.Deck;
import com.example.memrus.dto.DeckWord;
import com.example.memrus.dto.RuWord;

import java.util.ArrayList;

public class AddWordToDeck extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private ArrayAdapter<Container> adapter;
    private ContainerDAL containerDAL;
    private ArrayList<Container> containers;

    private DeckDAL deckDAL;
    private ListView listaDeckView;
    private int codPosicion = 0;
    private ArrayAdapter<Deck> adapter2;
    private ArrayList<Deck> listDecks;

    private int positionOur = 0;

    private DeckWordDAL deckWordDAL;
    ArrayList<DeckWord> deckWords2;

    private RuWord ruWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word_to_deck);

        this.ruWord = (RuWord) getIntent().getSerializableExtra("ruwordadd");

        this.containerDAL = new ContainerDAL(getApplicationContext(),new Container());
        this.containers = containerDAL.seleccionar2();

        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.adapter = new ArrayAdapter<Container>(getApplicationContext(),android.R.layout.simple_spinner_item, this.containers){


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLACK);

                return view;
            }

        };



        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.color_dropdown);


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        this.deckDAL = new DeckDAL(getApplicationContext(), new Deck());

        this.listDecks = deckDAL.seleccionar(containers.get(0));



        //Esto es para poner la cantidad de palabras dentro de un determinado deck
        deckWordDAL = new DeckWordDAL(getApplicationContext(),new DeckWord());
        deckWords2 = new ArrayList<>();

        for (int a = 0; a < listDecks.size() ; a++) {

            deckWords2 = deckWordDAL.seleccionar(listDecks.get(a));
            listDecks.get(a).setCantidad(deckWords2.size());
        }

        // i.- Enlazar la interfaz gráfica al componente


        this.listaDeckView = (ListView) findViewById(R.id.listDeckusAdd);


        // ii.- Crear ArrayAdapter y asociarlo al cRud
        this.adapter2 = new ArrayAdapter<Deck>(
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
                addWords(posicion);
            }
        });


        // iii.- Asociar el ArrayAdapter al componente ListView
        this.listaDeckView.setAdapter(adapter2);

    }
    public void addWords(int i){

        //Esto es para poner la cantidad de palabras dentro de un determinado deck
        deckWordDAL = new DeckWordDAL(getApplicationContext(),new DeckWord());
        deckWords2 = new ArrayList<>();

        for (int e = 0; e < listDecks.size() ; e++) {

            deckWords2 = deckWordDAL.seleccionar(listDecks.get(e));
            listDecks.get(e).setCantidad(deckWords2.size());
        }


        DeckWordDAL deckWord = new DeckWordDAL(getApplicationContext(),new DeckWord());
        if(deckWord.insertar(listDecks.get(i),ruWord)){
            Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
            actualizarLista();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        this.positionOur = position;

        adapter2.clear();

        deckWordDAL = new DeckWordDAL(getApplicationContext(),new DeckWord());
        deckWords2 = new ArrayList<>();

        ArrayList<Deck> decks2 = deckDAL.seleccionar(containers.get(position));

        for (int e = 0; e < deckDAL.seleccionar(containers.get(position)).size() ; e++) {

            deckWords2 = deckWordDAL.seleccionar(decks2.get(e));
            decks2.get(e).setCantidad(deckWords2.size());
        }



        adapter2.addAll(decks2);
        adapter2.notifyDataSetChanged();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void actualizarLista() {
        adapter2.clear();


        deckWordDAL = new DeckWordDAL(getApplicationContext(),new DeckWord());
        deckWords2 = new ArrayList<>();

        ArrayList<Deck> decks2 = deckDAL.seleccionar(containers.get(positionOur));

        for (int e = 0; e < deckDAL.seleccionar(containers.get(positionOur)).size() ; e++) {

            deckWords2 = deckWordDAL.seleccionar(decks2.get(e));
            decks2.get(e).setCantidad(deckWords2.size());
        }

        adapter2.addAll(decks2);
        adapter.notifyDataSetChanged();
    }
}
