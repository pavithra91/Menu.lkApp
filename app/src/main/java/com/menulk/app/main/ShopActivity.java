package com.menulk.app.main;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.menulk.app.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    ArrayList<Shop> models;
    ShopAdapter shopAdapter;
    RecyclerView recyclerView;
    String URL = "http://testrestfullapi.azurewebsites.net/api/Service/Get";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        /* JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        models = getData();
                        Log.e("REST Response",response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response",error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);*/

        recyclerView = (RecyclerView) findViewById(R.id.shoprecyclerView);
        models = getData();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        shopAdapter = new ShopAdapter(ShopActivity.this, models);
        recyclerView.setAdapter(shopAdapter);
    }


    public static ArrayList<Shop> getData()
    {
        ArrayList<Shop> shopList = new ArrayList<>();
        Shop s = new Shop("Coffee Bean","4.5","9AM-10PM", "https://financialtribune.com/sites/default/files/field/image/17january/04-ff-coffee_120-ab.jpg");
        shopList.add(s);

        Shop s2 = new Shop("Praneetha","3.8","9AM-10PM", "https://mediavine-res.cloudinary.com/image/upload/s--CQwblqNQ--/c_limit,f_auto,fl_lossy,h_1080,q_auto,w_1920/v1506850341/u1cy0q8qmqrdjjn7udmx.jpg");
        shopList.add(s2);

        return shopList;
    }
}
