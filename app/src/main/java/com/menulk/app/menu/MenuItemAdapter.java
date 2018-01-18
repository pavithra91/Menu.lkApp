package com.menulk.app.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.menulk.app.R;

import java.util.ArrayList;

/**
 * Created by pavithraj on 1/18/2018.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder> {
    private ArrayList<MenuItem> itemList;
    private Context context;

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

        holder.iName.setText(itemList.get(position).getItemName());
        holder.iDescription.setText(itemList.get(position).getDescription());
        holder.iPrice.setText(itemList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MenuItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView iName;
        protected TextView iDescription;
        protected TextView iPrice;
        public MenuItemViewHolder(View itemView) {
            super(itemView);
            iName =  (TextView) itemView.findViewById(R.id.item_name);
            iDescription = (TextView)  itemView.findViewById(R.id.item_description);
            iPrice = (TextView)  itemView.findViewById(R.id.item_price);
        }
    }
}
