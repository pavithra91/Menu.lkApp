package com.menulk.app.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.menulk.app.R;

import java.util.List;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private List<Shop> shopList;

    public ShopAdapter(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.shop_card, parent, false);

        return new ShopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        Shop s = shopList.get(position);
        holder.sName.setText(s.ShopName);
        holder.sRating.setText(s.Rating);
        holder.sOpenTime.setText(s.OpenTime);
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
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
