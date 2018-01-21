package com.menulk.app.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.menulk.app.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    ArrayList<Shop> models;
    ShopAdapter shopAdapter;
    RecyclerView recyclerView;
    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

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
