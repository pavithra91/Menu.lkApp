package com.menulk.app.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.menulk.app.R;
import com.squareup.picasso.Picasso;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView itemname = (TextView) findViewById(R.id.item_name);
        TextView itemDescription = (TextView) findViewById(R.id.item_description);
        TextView itemPrice = (TextView) findViewById(R.id.item_price);
        // itemImage = (ImageView) findViewById(R.id.ima);

        String name = getIntent().getStringExtra("ItemName");
        String _description = getIntent().getStringExtra("Description");
        String _price = getIntent().getStringExtra("Price");
       // String iImageURL = getIntent().getStringExtra("ImageURL");

        Log.e("Splash Screen",name);
        Log.e("Splash Screen",_description);
        Log.e("Splash Screen",_price);

        itemname.setText(name);
        itemDescription.setText(_description);
       // itemPrice.setText(_price);
        //Picasso.with(context).load(iImageURL).into(shopImage);
    }
}
