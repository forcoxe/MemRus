package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.memrus.dal.EnWordDAL;
import com.example.memrus.dal.RuEnWordDAL;
import com.example.memrus.dto.EnWord;
import com.example.memrus.dto.RuEn;
import com.example.memrus.dto.RuWord;

import java.util.ArrayList;

public class WordDetail extends AppCompatActivity {

    private TextView textoMeaning;
    private TextView textoAccent;

    private RuWord ruWord;
    private RuEnWordDAL ruEnWordDAL;
    private ArrayList<RuEn> ruEns;
    private EnWordDAL enWordDAL;
    private ArrayList<EnWord> enWords;
    private EnWord enWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);

        textoMeaning = (TextView) findViewById(R.id.textViewEnglish);
        textoAccent = (TextView) findViewById(R.id.textViewAccent);

        int quePa = (int) getIntent().getSerializableExtra("position");
        this.ruWord = (RuWord) getIntent().getSerializableExtra("ruword");

        this.ruEnWordDAL = new RuEnWordDAL(getApplicationContext(),new RuEn());
        this.enWordDAL = new EnWordDAL(getApplicationContext(),new EnWord());

        Log.w("Palabra rusa que pasó: ",String.valueOf(ruWord.getId()));

        ruEns = ruEnWordDAL.seleccionar(ruWord);
        Log.w("El RUEN: ",ruEns.get(0).getRuWord().getId() + " - " +ruEns.get(0).getEnWord().getId());


        Log.w("Palabra en inglés: ",String.valueOf(ruEns.get(0).getEnWord().getId() + " - "));
        enWord = enWordDAL.seleccionar(ruEns.get(0));


        textoAccent.setText(ruWord.getAccent());
        textoMeaning.setText(enWord.getWord());

        Log.w("Puchko: ","Hola ");
        Log.w("Puchko2: ",String.valueOf(quePa));
    }
}
