package com.menulk.app.menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menulk.app.R;
import com.menulk.app.order.OrderActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pavithraj on 1/18/2018.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder> {
    private ArrayList<MenuItem> itemList;
    private Context context;
    protected static ImageView sImage;

    public MenuItemAdapter(Context context, ArrayList<MenuItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.menu_card, null);
        MenuItemViewHolder MIVH = new MenuItemViewHolder(itemView);

        return MIVH;
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder holder, int position) {

        final int _index = position;

        holder.iName.setText(itemList.get(position).getItemName());
        holder.iDescription.setText(itemList.get(position).getDescription());
        holder.iPrice.setText(itemList.get(position).getPrice());


        Picasso.with(context).load(itemList.get(position).getImage()).resize(100,100).into(sImage);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("ItemName", itemList.get(_index).getItemName());
                intent.putExtra("Description", itemList.get(_index).getDescription());
                intent.putExtra("Price", itemList.get(_index).getPrice());
                intent.putExtra("ImageURL", itemList.get(_index).getImage());
                intent.putExtra("ItemID", itemList.get(_index).getItemID());
                intent.putExtra("RestaurantID", itemList.get(_index).getRestaurantID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MenuItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView iName;
        protected TextView iDescription;
        protected TextView iPrice;
        protected LinearLayout layout;

        public MenuItemViewHolder(View itemView) {
            super(itemView);
            iName =  (TextView) itemView.findViewById(R.id.item_name);
            iDescription = (TextView)  itemView.findViewById(R.id.item_description);
            iPrice = (TextView)  itemView.findViewById(R.id.item_price);
            sImage = (ImageView) itemView.findViewById(R.id.list_image);
            layout = (LinearLayout)itemView.findViewById(R.id.linear_layout_card);
        }
    }
}
