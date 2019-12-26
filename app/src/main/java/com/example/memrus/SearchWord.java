package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.memrus.dal.EnWordDAL;
import com.example.memrus.dal.RuEnWordDAL;
import com.example.memrus.dal.RuWordDAL;
import com.example.memrus.dto.EnWord;
import com.example.memrus.dto.RuEn;
import com.example.memrus.dto.RuWord;

import java.util.ArrayList;


public class SearchWord extends AppCompatActivity {

    private ListView listaSearchView;
    private int codPosicion = 0;
    private ArrayAdapter<RuWord> adapter;
    private ArrayList<RuWord> listRuWords;
    private ArrayList<RuEn> ruEns;
    private RuWordDAL ruWordDAL;
    private RuEnWordDAL ruEnWordDAL;
    private EnWordDAL enWordDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_word);
        String acha = (String) getIntent().getSerializableExtra("search");
        acha = acha.toLowerCase();
        Log.w("ESAA", acha);

        this.ruWordDAL = new RuWordDAL(getApplicationContext(),new RuWord());
        this.ruEnWordDAL = new RuEnWordDAL(getApplicationContext(), new RuEn());
        this.enWordDAL = new EnWordDAL(getApplicationContext(),new EnWord());
        this.listRuWords = new ArrayList<>();
        this.ruEns = new ArrayList<>();

        boolean ver = ruEns.isEmpty();
        Log.w("EL RUENS DE SEARCH: ",String.valueOf(ver));



        if(ruEnWordDAL.seleccionar(enWordDAL.seleccionar(acha)).isEmpty()) {

            listRuWords.add(new RuWord(0, "No results"));
            this.listaSearchView = (ListView) findViewById(R.id.listSearch);

            // ii.- Crear ArrayAdapter y asociarlo al cRud
            this.adapter = new ArrayAdapter<RuWord>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    this.listRuWords
            ) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView textView = (TextView) view.findViewById(android.R.id.text1);

                    /*YOUR CHOICE OF COLOR*/
                    textView.setTextColor(Color.BLACK);

                    return view;
                }
            };
            this.listaSearchView.setAdapter(adapter);


        }
        else {
            ruEns = ruEnWordDAL.seleccionar(enWordDAL.seleccionar(acha));

            for (int i = 0; i < ruEns.size(); i++) {
                listRuWords.add(ruWordDAL.seleccionar(ruEns.get(i)));
            }



        // i.- Enlazar la interfaz gráfica al componente
        this.listaSearchView = (ListView) findViewById(R.id.listSearch);


        // ii.- Crear ArrayAdapter y asociarlo al cRud
        this.adapter = new ArrayAdapter<RuWord>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                this.listRuWords
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

        listaSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirListaAddDecksActivity();
            }
        });


        // iii.- Asociar el ArrayAdapter al componente ListView
        this.listaSearchView.setAdapter(adapter);
        }

    }

    private void abrirListaAddDecksActivity() {
        Intent intento = new Intent(SearchWord.this, AddWordToDeck.class);

        RuWord r = (RuWord) listRuWords.get(codPosicion);

        intento.putExtra("ruwordadd", r);


        startActivityForResult(intento, 100);
    }
}
