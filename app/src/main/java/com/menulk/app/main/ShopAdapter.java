package com.menulk.app.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.menulk.app.R;
import com.menulk.app.menu.MenuActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private ArrayList<Shop> shopList;
    private Context context;
    protected static ImageView sImage;

    public ShopAdapter(Context context, ArrayList<Shop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.shop_card, null);
        ShopViewHolder SVH = new ShopViewHolder(itemView);

        return SVH;
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, final int position) {
        final int _index = position;
        holder.sName.setText(shopList.get(position).getShopName());
        holder.sRating.setText(shopList.get(position).getRating());
        holder.sOpenTime.setText(shopList.get(position).getOpenTime());

        Picasso.with(context).load(shopList.get(position).getImageURL()).into(sImage);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                intent.putExtra("ShopName", shopList.get(_index).getShopName());
                intent.putExtra("Rating", shopList.get(_index).getRating());
                intent.putExtra("OpenTime", shopList.get(_index).getOpenTime());
                intent.putExtra("ImageURL", shopList.get(_index).getImageURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder{
        protected TextView sName;
        protected TextView sRating;
        protected TextView sOpenTime;

        protected LinearLayout layout;

        public ShopViewHolder(View itemView) {
            super(itemView);
            sName =  (TextView) itemView.findViewById(R.id.shopname);
            sRating = (TextView)  itemView.findViewById(R.id.rating);
            sOpenTime = (TextView)  itemView.findViewById(R.id.opentime);
            sImage = (ImageView) itemView.findViewById(R.id.shopImage);
            layout = (LinearLayout)itemView.findViewById(R.id.linear_layout_card);
        }
    }
}
