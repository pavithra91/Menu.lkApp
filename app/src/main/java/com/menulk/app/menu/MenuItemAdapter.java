package com.menulk.app.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    public MenuItemAdapter(Context context, ArrayList<MenuItem> shopList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MenuItemViewHolder extends RecyclerView.ViewHolder{
        public MenuItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
