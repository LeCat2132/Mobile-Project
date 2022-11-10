package com.example.weatherapp.Hourly_Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherapp.R;

public class Hourly_ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView txtDay;
    TextView txtTemp;

    public Hourly_ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.weather_image_view);
        txtDay = itemView.findViewById(R.id.time_text_view);
        txtTemp = itemView.findViewById(R.id.temp_text_view);

    }

}
