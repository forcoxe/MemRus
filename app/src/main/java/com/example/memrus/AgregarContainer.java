package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.memrus.dal.ContainerDAL;
import com.example.memrus.dal.DeckDAL;
import com.example.memrus.dal.DeckWordDAL;
import com.example.memrus.dto.Container;
import com.example.memrus.dto.Deck;

public class AgregarContainer extends AppCompatActivity {

    private EditText nombreAgregar;
    private Button buttonAgregar;
    private ContainerDAL containerDAL;
    private DeckDAL deckDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_container);

        this.nombreAgregar = (EditText) findViewById(R.id.editTextContainer);
        this.buttonAgregar = (Button) findViewById(R.id.buttonAgregarContainer);

        this.containerDAL = new ContainerDAL(getApplicationContext(),new Container());
        this.deckDAL = new DeckDAL(getApplicationContext(),new Deck());

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarContainer();
            }
        });

    }

    private void agregarContainer(){
        Toast toast = Toast.makeText(getApplicationContext(),"Agregao", Toast.LENGTH_SHORT);
        Toast toast2 = Toast.makeText(getApplicationContext(),"No Agregao", Toast.LENGTH_SHORT);

        String a = String.valueOf(nombreAgregar.getText());
        Log.w("WHAT: ",a);

        if(containerDAL.insertar(a,1)){

            int idea = containerDAL.seleccionar2().get(containerDAL.seleccionar2().size()-1).getId();


            Log.w("Datos",containerDAL.getContainer().getName()+"  -  "+idea);
            deckDAL.insertar(containerDAL.getContainer().getName()+" - 1",new Container(idea));

            toast.show();

        }
        else
            toast2.show();

    }
}
