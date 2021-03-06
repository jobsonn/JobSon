package com.example.bhavinjobanputra.jobson;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BhaVin Jobanputra on 08-10-2016.
 */
public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.MyViewHolder> {

    private List<Item_list> itemList;
    Fragment a;

    public Item_Adapter(Fragment a, List<Item_list> itemList){
        this.a = a;
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView prodcut_id,category,size,brand,price;
        public NetworkImageView i_image;
        public MyViewHolder(View view)
        {
            super(view);
            view.setOnClickListener(this);
            i_image = (NetworkImageView) view.findViewById(R.id.icon);
            prodcut_id = (TextView) view.findViewById(R.id.product_id);
            category = (TextView) view.findViewById(R.id.category);
            size = (TextView) view.findViewById(R.id.size);
            brand= (TextView) view.findViewById(R.id.brand);
            price = (TextView) view.findViewById(R.id.price);
         }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Item_list item_list = itemList.get(position);
            Intent i = new Intent(a.getContext(),Description_Item.class);
            i.putExtra("product",item_list.getProduct_id());
            a.startActivity(i);
        }
    }



    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder,int position){
        Item_list i_list = itemList.get(position);
        holder.prodcut_id.setText(i_list.getProduct_id());
        holder.category.setText(i_list.getCategory());
        holder.size.setText(i_list.getSize());
        holder.brand.setText(i_list.getBrand());
        holder.price.setText(i_list.getPrice());
        holder.i_image.setImageUrl(i_list.getImage(),i_list.getImageLoader());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
