package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.memrus.dal.DeckDAL;
import com.example.memrus.dal.DeckWordDAL;
import com.example.memrus.dal.RuWordDAL;
import com.example.memrus.dto.Deck;
import com.example.memrus.dto.DeckWord;
import com.example.memrus.dto.RuWord;

import java.util.ArrayList;

public class SlideActivity extends AppCompatActivity {

    private SliderAdapter sliderAapter;
    private ViewPager mSlideViewPager;

    private DeckDAL deckDAL;
    private DeckWordDAL deckWordDAL;
    private Deck deck;
    private ArrayList<DeckWord> deckWords;

    private RuWordDAL ruWordDAL;
    private ArrayList<RuWord> ruWords = new ArrayList<>();

    private TextView textViewWord;
    private Button buttonMeaning;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        Log.w("gola","gola");

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        textViewWord = (TextView) findViewById(R.id.textWord);
        buttonMeaning = (Button) findViewById(R.id.btMeaning) ;

        deck = (Deck) getIntent().getSerializableExtra("deck");

        Log.w("Deck Data:",deck.toString());

        deckWordDAL = new DeckWordDAL(getApplicationContext(),new DeckWord());
        ruWordDAL = new RuWordDAL(getApplicationContext(),new RuWord());
        deckWords = deckWordDAL.seleccionar(deck);

        Log.w("PRUEBA01:",deckWords.get(0).toString());
        Log.w("PRUEBA02:",ruWordDAL.seleccionar(deckWords.get(0)).toString());

        //boolean funca = ruWordDAL.insertar("гкоаячстби","hope","dispair",0);





        for (int i = 0; i < deckWords.size(); i++) {
            Log.w("DECK DATA"+i,deckWords.get(i).toString());

            ruWords.add(ruWordDAL.seleccionar(deckWords.get(i)));

        }


        sliderAapter = new SliderAdapter(this, ruWords);

        mSlideViewPager.setAdapter(sliderAapter);
        mSlideViewPager.getAdapter().getCount();


        buttonMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(SlideActivity.this, WordDetail.class);
                int i = mSlideViewPager.getCurrentItem();
                RuWord ruWord = ruWords.get(mSlideViewPager.getCurrentItem());
                intento.putExtra("position", i);
                intento.putExtra("ruword", ruWord);
                startActivityForResult(intento, 100);
            }
        });






    }
}
