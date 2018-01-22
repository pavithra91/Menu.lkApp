package com.menulk.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.menulk.app.main.Shop;
import com.menulk.app.main.ShopActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;  //3 Seconds
    String URL = "http://testrestfullapi.azurewebsites.net/api/Service/Get";
    String respondString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        respondString = response.toString();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response",error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);

        requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                Log.e("Error Response 2","Request Finish");

                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */
                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        intent.putExtra("shopList", respondString);
                        startActivity(intent);

                        Log.e("Splash Screen",respondString);

                        // close this activity
                        finish();
                    }
                }, SPLASH_TIME_OUT);
            }
        });



      //  setContentView(R.layout.activity_splash);
    }
}
