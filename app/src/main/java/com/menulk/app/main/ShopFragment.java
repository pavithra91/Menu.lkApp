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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    ArrayList<Shop> models;
    ShopAdapter shopAdapter;
    RecyclerView recyclerView;
    final ArrayList<Shop> shopList = new ArrayList<>();

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        /*requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                Log.e("Error Response 2","Request Finish");
            }
        });*/

        final View view = inflater.inflate(R.layout.activity_shop, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.shoprecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);

        Bundle b = getArguments();
        String s = b.getString("response");

        try {
            JSONArray response= new JSONArray(s);

            for(int i=0; i<response.length();i++)
            {
                JSONObject json_data = response.getJSONObject(i);
                Shop shop = new Shop(json_data.getString("R_Name"),json_data.getString("R_Rating"),json_data.getString("R_OpenTime"), json_data.getString("R_Image"));
                shopList.add(shop);
                Log.e("R_Name", String.valueOf(shopList.size()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        models = shopList;
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
