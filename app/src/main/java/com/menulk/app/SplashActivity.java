package com.menulk.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.menulk.app.main.ShopActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;  //3 Seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {

                                      /*
                                       * Showing splash screen with a timer. This will be useful when you
                                       * want to show case your app logo / company
                                       */
                                      @Override
                                      public void run() {
                                          // This method will be executed once the timer is over
                                          // Start your app main activity
                                          Intent i = new Intent(SplashActivity.this, ShopActivity.class);
                                          startActivity(i);

                                          // close this activity
                                          finish();
                                      }
                                  }, SPLASH_TIME_OUT);

      //  setContentView(R.layout.activity_splash);
    }
}
