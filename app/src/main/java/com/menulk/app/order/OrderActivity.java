package com.menulk.app.order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.menulk.app.AppCode.CustomerOrder;
import com.menulk.app.R;
import com.menulk.app.profile.CheckoutActivity;
import com.squareup.picasso.Picasso;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView itemname = (TextView) findViewById(R.id.item_name);
        TextView itemDescription = (TextView) findViewById(R.id.item_description);
        TextView itemPrice = (TextView) findViewById(R.id.item_price);
        Button _addtoCart = (Button) findViewById(R.id.addtoCart);
        // itemImage = (ImageView) findViewById(R.id.ima);

        String name = getIntent().getStringExtra("ItemName");
        final String _description = getIntent().getStringExtra("Description");
        final String _price = getIntent().getStringExtra("Price");
       // String iImageURL = getIntent().getStringExtra("ImageURL");

        itemname.setText(name);
        itemDescription.setText(_description);
       // itemPrice.setText(_price);
        //Picasso.with(context).load(iImageURL).into(shopImage);

        _addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerOrder _order = new CustomerOrder("",1,1, _price,_description,"'" );
                Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
                intent.putExtra("CustomerOrderList", _order);
                startActivity(intent);
            }
        });
    }
}
