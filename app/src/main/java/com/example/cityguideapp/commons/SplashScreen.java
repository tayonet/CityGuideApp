package com.example.cityguideapp.commons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.user.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    ImageView backgroundImage;
    TextView powered_by_line;

    // Animations

    Animation sideAnim,bottomAnim;
      SharedPreferences onBoardingSharedPreferences;

    private static int SPLASH_TIMER = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        // Hooks

        backgroundImage = findViewById(R.id.background_image);
        powered_by_line = findViewById(R.id.powered_by_line);

        // hooks
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        // set animations on elements defined before
        backgroundImage.setAnimation(sideAnim);
        powered_by_line.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingSharedPreferences = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardingSharedPreferences.getBoolean("firstTime",true);

              //  if(isFirstTime) {
//                    SharedPreferences.Editor editor = onBoardingSharedPreferences.edit();
//                    editor.putBoolean("firstTime",false);
//                    editor.commit();
                    startActivity(new Intent(SplashScreen.this, onBoarding.class));
                    finish();

//                } else  {
//                    startActivity(new Intent(SplashScreen.this, UserDashboard.class));
//                    finish();
//                }

            }
        },SPLASH_TIMER);

    }
}