package com.example.weatherapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements OnItemClickListener{

    Context context;
    List<Item> items;
    private final OnItemClickListener listener;

    public MyAdapter(Context context, List<Item> items, OnItemClickListener listener){
        this.context = context;
        this.items = items;
        this.listener = listener;
    }
    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtDay.setText(items.get(position).getDay());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.txtSunrise.setText(items.get(position).getSunrise());
        holder.txtSunset.setText(items.get(position).getSunset());
        holder.txtMinTemp.setText(items.get(position).getMinTemp().toString());
        holder.txtMaxTemp.setText(items.get(position).getMaxTemp().toString());
        holder.bgColor.setBackgroundResource(items.get(position).getBgColor());
        holder.bind(items.get(position), listener, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(Item item, int position) {

    }
}