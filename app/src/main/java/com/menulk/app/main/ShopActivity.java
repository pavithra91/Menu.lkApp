package com.menulk.app.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.menulk.app.R;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private ShopAdapter shopAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);



        //RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        //recList.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //recList.setLayoutManager(llm);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.activity_shop, container,false);
        recycleView = (RecyclerView) layout.findViewById(R.id.cardList);
        shopAdapter = new ShopAdapter(getData());
        recycleView.setAdapter(shopAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        return layout;
    }

    public static List<Shop> getData()
    {
        List<Shop> shopList = new ArrayList<>();
        Shop s = new Shop();
        s.ShopName = "Coffee Bean";
        s.Rating = "4.5";
        s.OpenTime = "9AM-10PM";
        shopList.add(s);

        Shop s2 = new Shop();
        s2.ShopName = "Praneetha";
        s2.Rating = "3.8";
        s2.OpenTime = "9AM-10PM";
        shopList.add(s2);

        return shopList;
    }
}
