package com.menulk.app.order;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.menulk.app.AppCode.CustomerOrder;
import com.menulk.app.R;
import com.menulk.app.profile.CheckoutActivity;
import com.squareup.picasso.Picasso;

public class OrderActivity extends AppCompatActivity {

    ElegantNumberButton btnQty;
    private Context context;
    int Qty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView itemname = (TextView) findViewById(R.id.item_name);
        TextView itemDescription = (TextView) findViewById(R.id.item_description);
        final EditText specialNotes = (EditText) findViewById(R.id.special_instructions);
        ImageView itemImage = (ImageView) findViewById(R.id.itemimage);
        Button _addtoCart = (Button) findViewById(R.id.addtoCart);
        btnQty = findViewById(R.id.incrementButtons);

        btnQty.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qty = Integer.parseInt(btnQty.getNumber());
            }
        });

        String name = getIntent().getStringExtra("ItemName");
        final String _description = getIntent().getStringExtra("Description");
        final String _price = getIntent().getStringExtra("Price");
        final int _itemID = Integer.parseInt(getIntent().getStringExtra("ItemID"));
        final int _restaurantID = Integer.parseInt(getIntent().getStringExtra("RestaurantID"));
        String iImageURL = getIntent().getStringExtra("ImageURL");
        final String _notes = specialNotes.getText().toString();

        itemname.setText(name);
        itemDescription.setText(_description);
       // itemPrice.setText(_price);
        Picasso.with(context).load(iImageURL).into(itemImage);

        _addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerOrder _order = new CustomerOrder("",_restaurantID,_itemID, _price,_description,"", _notes, Qty );
                Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
                intent.putExtra("CustomerOrderList", _order);
                startActivity(intent);
            }
        });
    }
}
