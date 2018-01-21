package com.menulk.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.menulk.app.main.SearchFragment;
import com.menulk.app.main.ShopFragment;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ShopFragment shopfragment = new ShopFragment();
                    FragmentTransaction shoptransaction = getSupportFragmentManager().beginTransaction();
                    shoptransaction.replace(R.id.content,shopfragment);
                    shoptransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    SearchFragment searchfragment = new SearchFragment();
                    FragmentTransaction searchtransaction = getSupportFragmentManager().beginTransaction();
                    searchtransaction.replace(R.id.content,searchfragment);
                    searchtransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    SearchFragment profilefragment = new SearchFragment();
                    FragmentTransaction profiletransaction = getSupportFragmentManager().beginTransaction();
                    profiletransaction.replace(R.id.content,profilefragment);
                    profiletransaction.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ShopFragment shopfragment = new ShopFragment();
        FragmentTransaction shoptransaction = getSupportFragmentManager().beginTransaction();
        shoptransaction.replace(R.id.content,shopfragment);
        shoptransaction.commit();
    }

}
