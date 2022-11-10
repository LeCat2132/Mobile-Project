package com.example.weatherapp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherapp.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView txtDay;
    TextView txtSunrise;
    TextView txtSunset;
    TextView txtMinTemp;
    TextView txtMaxTemp;
    CardView bgColor;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imgDesc);
        txtDay = itemView.findViewById(R.id.txtDay);
        txtSunrise = itemView.findViewById(R.id.txtSunrise);
        txtSunset = itemView.findViewById(R.id.txtSunset);
        txtMinTemp = itemView.findViewById(R.id.txtMinTemp);
        txtMaxTemp = itemView.findViewById(R.id.txtMaxTemp);
        bgColor = itemView.findViewById(R.id.bgColor);

    }

    public void bind(Item item, OnItemClickListener listener, int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item, position);
            }
        });
    }
}
