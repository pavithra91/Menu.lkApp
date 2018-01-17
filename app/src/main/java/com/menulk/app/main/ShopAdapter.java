package com.menulk.app.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.menulk.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private ArrayList<Shop> shopList;
    private Context context;

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
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        holder.sName.setText(shopList.get(position).getShopName());
        holder.sRating.setText(shopList.get(position).getRating());
        holder.sOpenTime.setText(shopList.get(position).getOpenTime());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder{
        protected TextView sName;
        protected TextView sRating;
        protected TextView sOpenTime;
        public ShopViewHolder(View itemView) {
            super(itemView);
            sName =  (TextView) itemView.findViewById(R.id.shopname);
            sRating = (TextView)  itemView.findViewById(R.id.rating);
            sOpenTime = (TextView)  itemView.findViewById(R.id.opentime);

        }
    }
}
