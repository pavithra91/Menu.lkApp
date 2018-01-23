package com.menulk.app.menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menulk.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    ArrayList<MenuItem> models;
    MenuItemAdapter menuItemAdapter;
    RecyclerView recyclerView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);

        TextView shopname = (TextView) findViewById(R.id.shopname);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView opentime = (TextView) findViewById(R.id.opentime);
        ImageView shopImage = (ImageView) findViewById(R.id.mainImage);

        String iShopname = getIntent().getStringExtra("ShopName");
        String iRating = getIntent().getStringExtra("Rating");
        String iOpentime = getIntent().getStringExtra("OpenTime");
        String iImageURL = getIntent().getStringExtra("ImageURL");

        shopname.setText(iShopname);
        rating.setText(iRating);
        opentime.setText(iOpentime);
        Picasso.with(context).load(iImageURL).into(shopImage);

        recyclerView = (RecyclerView) findViewById(R.id.meunrecyclerView);
        models = getData();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        menuItemAdapter = new MenuItemAdapter(MenuActivity.this, models);
        recyclerView.setAdapter(menuItemAdapter);
    }

    public static ArrayList<MenuItem> getData()
    {
        ArrayList<MenuItem> menuItemList = new ArrayList<>();
        MenuItem s = new MenuItem("Latte","Made with espresso and steamed milk.","RS. 300", "");
        menuItemList.add(s);

        MenuItem s2 = new MenuItem("Cappuccino","Prepared with double espresso, and steamed milk foam.","RS. 450", "");
        menuItemList.add(s2);

        return menuItemList;
    }
}
