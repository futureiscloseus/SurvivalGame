package com.futureiscloseuscorporation.survivle;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainSurface mainSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.parseColor("#7f111111"));           //SetStatusBarColor
        getWindow().setNavigationBarColor(Color.parseColor("#7f111111"));       //SetNavigationBarColor



        View decorView = getWindow().getDecorView();                                       //Set StatusBar and NavigationBarColor Listener
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {

                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        @Override
                                        public void run() {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    hideSystemUI();
                                                }
                                            });
                                        }
                                    },
                                    5000
                            );

                        } else {


                        }
                    }
                });





        hideSystemUI();         //Hide system UI




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            final WindowInsetsController controller = getWindow().getInsetsController();        //FullScreen for android higher 6
            if (controller != null) controller.hide(WindowInsets.Type.statusBars());

        }



       // if(mainSurface == null)
            mainSurface = new MainSurface(this);

        setContentView(mainSurface);


    }

    private void hideSystemUI() {                                                               //Method for hide system ui

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE

                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);


    }

}