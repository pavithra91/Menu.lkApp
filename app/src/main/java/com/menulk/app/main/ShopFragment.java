package com.menulk.app.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.android.volley.toolbox.Volley;
import com.menulk.app.R;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    ArrayList<Shop> models;
    ShopAdapter shopAdapter;
    RecyclerView recyclerView;
    String URL = "http://testrestfullapi.azurewebsites.net/api/Service/Get";

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
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

        requestQueue.add(objectRequest);

        final View view = inflater.inflate(R.layout.activity_shop, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.shoprecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);


        models = getData();
        final ShopAdapter adapter = new ShopAdapter(c,models);
        recyclerView.setAdapter(adapter);

        return view;
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