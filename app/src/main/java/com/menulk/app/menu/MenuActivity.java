package com.menulk.app.menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menulk.app.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    ArrayList<MenuItem> models  = new ArrayList<>();;
    MenuItemAdapter menuItemAdapter;
    RecyclerView recyclerView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView shopname = (TextView) findViewById(R.id.shopname);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView deliveryTime = (TextView) findViewById(R.id.deliveryTime);
        TextView tags = (TextView) findViewById(R.id.tags);
        ImageView shopImage = (ImageView) findViewById(R.id.mainImage);

        String  iShopname = getIntent().getStringExtra("ShopName");
        String iRating = getIntent().getStringExtra("Rating");
        String iDeliveryTime = getIntent().getStringExtra("OpenTime");
        String iImageURL = getIntent().getStringExtra("ImageURL");
        String iTags = getIntent().getStringExtra("Tags");
        String Response = getIntent().getStringExtra("RESTresponse");

        Log.e("R_Name", Response);

       try {
            JSONArray response= new JSONArray(Response);

            for(int i=0; i<response.length();i++)
            {
                JSONObject json_data = response.getJSONObject(i);

                MenuItem menuItem = new MenuItem(json_data.getString("ItemID"), json_data.getString("RestaurantID") ,json_data.getString("ItemName"),json_data.getString("Description"),json_data.getString("Price"), json_data.getString("ItemImage"));
                models.add(menuItem);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        shopname.setText(iShopname);
        rating.setText(iRating);
        deliveryTime.setText(iDeliveryTime);
        tags.setText(iTags);
        Picasso.with(context).load(iImageURL).into(shopImage);

        recyclerView = (RecyclerView) findViewById(R.id.meunrecyclerView);
        //models = getData();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        menuItemAdapter = new MenuItemAdapter(MenuActivity.this, models);
        recyclerView.setAdapter(menuItemAdapter);
    }

    public static ArrayList<MenuItem> getData()
    {
        ArrayList<MenuItem> menuItemList = new ArrayList<>();
        MenuItem s = new MenuItem("2","2","Latte","Made with espresso and steamed milk.","RS. 300", "");
        menuItemList.add(s);

        MenuItem s2 = new MenuItem("1","2","Cappuccino","Prepared with double espresso, and steamed milk foam.","RS. 450", "");
        menuItemList.add(s2);

        return menuItemList;
    }
}
