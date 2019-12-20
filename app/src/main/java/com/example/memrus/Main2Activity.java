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
import com.example.memrus.dto.Container;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    private ContainerDAL containerDAL;
    private ListView listaContainer;
    private ArrayAdapter<Container> adapter;
    private ArrayList<Container> listContainers;
    private int codPosicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        this.containerDAL = new ContainerDAL(getApplicationContext(),new Container());
        this.listContainers = new ContainerDAL(getBaseContext()).seleccionar();

        // i.- Enlazar la interfaz gráfica al componente
        this.listaContainer = (ListView) findViewById(R.id.listContainers);


        // ii.- Crear ArrayAdapter y asociarlo al cRud
        this.adapter = new ArrayAdapter<Container>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                this.listContainers
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

        listaContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirListaDecksActivity();
            }
        });


        // iii.- Asociar el ArrayAdapter al componente ListView
        this.listaContainer.setAdapter(adapter);

    }

    private void abrirListaDecksActivity() {
        Intent intento = new Intent(Main2Activity.this, ListaDecks.class);
        Container c = (Container) listContainers.get(codPosicion);

        intento.putExtra("container", c);


        startActivityForResult(intento, 100);
    }
}
