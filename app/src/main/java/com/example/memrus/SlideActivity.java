package com.example.memrus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class SlideActivity extends AppCompatActivity {

    private SliderAdapter sliderAapter;
    private ViewPager mSlideViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);

        sliderAapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAapter);
    }
}
