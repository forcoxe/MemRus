package com.example.memrus;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.memrus.dal.DeckWordDAL;
import com.example.memrus.dal.RuWordDAL;
import com.example.memrus.dto.DeckWord;
import com.example.memrus.dto.RuWord;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public ArrayList<String>wordList = new ArrayList<>();
    private int position = 0;




    public SliderAdapter(Context context, ArrayList<RuWord> ruWords){

        for (int i = 0; i < ruWords.size(); i++) {
            Log.w("Palabra ID: ",String.valueOf(ruWords.get(i).getId()));
            Log.w("Palabra WORD: ",ruWords.get(i).getWord());
            wordList.add(ruWords.get(i).getWord());
        }


        /*
        wordList.add("привет");
        wordList.add("спасибо");
        wordList.add("поко");

         */
        this.context = context;
    }
    @Override
    public int getCount() {
        return wordList.size();
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.activity_slide, container, false);
        this.position = position;
        TextView wordInScreen = (TextView) view.findViewById(R.id.textWord);



        wordInScreen.setText(wordList.get(position));


        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
