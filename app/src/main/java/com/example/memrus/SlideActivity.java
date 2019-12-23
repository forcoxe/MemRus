package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        Log.w("gola","gola");

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);

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
    }
}
