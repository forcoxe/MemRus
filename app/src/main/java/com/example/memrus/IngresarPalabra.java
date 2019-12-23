package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.memrus.dal.RuWordDAL;
import com.example.memrus.dto.RuWord;

public class IngresarPalabra extends AppCompatActivity {

    private RuWordDAL ruWordDAL;
    private EditText editTextRU;
    private EditText editTextLA;
    private EditText editTextAC;
    private Button buttonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_palabra);

        ruWordDAL = new RuWordDAL(getApplicationContext(),new RuWord());

        buttonIngresar = (Button) findViewById(R.id.btIngresar);



        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresarDatos();
            }
        });


    }

    private void ingresarDatos(){


    }
}
