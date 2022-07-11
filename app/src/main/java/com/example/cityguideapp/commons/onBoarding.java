package com.example.cityguideapp.commons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.helperClasses.SliderAdapter;
import com.example.cityguideapp.user.UserDashboard;

public class onBoarding extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted,next_btn;
    Animation animation;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);
        next_btn= findViewById(R.id.next_btn);

        //  call adapter

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDots(int position) {
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i  = 0; i < dots.length; i++ ) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(45);
            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }


    public void skip(View view) {
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPosition + 1);

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



        }


        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;
            if(position == 0 ) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }else if (position == 1 ) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }else if (position == 2) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }else {
                animation = AnimationUtils.loadAnimation(onBoarding.this,R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }

            if(position == 3) {
                next_btn.setVisibility(View.INVISIBLE);
            } else {
                next_btn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}