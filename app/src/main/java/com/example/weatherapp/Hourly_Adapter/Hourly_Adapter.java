package com.example.weatherapp.Hourly_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

import java.util.List;


public class Hourly_Adapter extends RecyclerView.Adapter<Hourly_ViewHolder>{

    Context context;
    List<Hourly_Item> items;


    public Hourly_Adapter(Context context, List<Hourly_Item> items){
        this.context = context;
        this.items = items;
    }
    @NonNull

    @Override
    public Hourly_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Hourly_ViewHolder(LayoutInflater.from(context).inflate(R.layout.weather_hourly_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Hourly_ViewHolder holder, int position) {
        holder.txtDay.setText(items.get(position).getDay());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.txtTemp.setText(items.get(position).getTemp().toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}