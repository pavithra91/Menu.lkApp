package com.menulk.app.profile;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.menulk.app.AppCode.CustomerOrder;
import com.menulk.app.R;

public class CheckoutActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        CustomerOrder list = intent.getParcelableExtra("CustomerOrderList");

        Log.e("Item Name",  list.getItemDescription());

        TabHost tabHost = getTabHost();

        TabHost.TabSpec _quickOrder = tabHost.newTabSpec("Quick Order");
        _quickOrder.setIndicator("Quick Order");
        Intent _quickOrderIntent = new Intent(this, QuickOrderActivity.class);
        _quickOrder.setContent(_quickOrderIntent);

        TabHost.TabSpec _login = tabHost.newTabSpec("Login");
        // setting Title and Icon for the Tab
        _login.setIndicator("Login");
        Intent _loginIntent = new Intent(this, LoginActivity.class);
        _login.setContent(_loginIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(_quickOrder);
        tabHost.addTab(_login);
    }
}
