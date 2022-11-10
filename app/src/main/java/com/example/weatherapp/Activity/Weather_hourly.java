package com.example.weatherapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import com.example.weatherapp.Adapter.Item;
import com.example.weatherapp.Hourly_Adapter.Hourly_Adapter;
import com.example.weatherapp.Hourly_Adapter.Hourly_Item;
import com.example.weatherapp.R;
import com.example.weatherapp.databinding.WeatherHourlyBinding;
import com.example.weatherapp.models.WeatherResponse;
import com.google.gson.Gson;

public class Weather_hourly extends Activity {

    private WeatherHourlyBinding binding;
    private WeatherResponse response = null;
    private int position = 0;
    private List<Hourly_Item> items_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WeatherHourlyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupDismissFrameLayout();
        setVariables();
        InitRecylerView();
    }

    private void setupDismissFrameLayout() {
            binding.draggableFrame.setSwipeable(true);
    }

    private void setVariables() {
        Intent intent = getIntent();

        String result = intent.getStringExtra("Data");
        response = new Gson().fromJson(result,WeatherResponse.class);

        String _position = intent.getStringExtra("Position");
        position = Integer.parseInt(_position) + 1;

        String item_sent = intent.getStringExtra("Clicked-day");
        Item items = new Gson().fromJson(item_sent, Item.class);

        binding.cardView.setCardBackgroundColor(items.getBgColor());
        binding.dayNameTextView.setText(items.getDay());

        binding.hourlyAnimationView.setAnimation(
                response.WeatherCodeFigure(response.getDaily().getWeathercode().get(position)));
        binding.hourlyAnimationView.playAnimation();

        binding.minTempTextView.setText("" + items.getMinTemp());
        binding.maxTempTextView.setText("" + items.getMaxTemp());

        binding.txtSunrise.setText("" + items.getSunrise());
        binding.txtSunset.setText("" + items.getSunset());


    }

    private void InitRecylerView() {

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(new Hourly_Adapter(getApplicationContext(), items_list));

        if (items_list.size() != 0)
            items_list.clear();

        for(int i = 0; i < 24; i++)
        {
            items_list.add(new Hourly_Item(response.getHourly().getTime().get(24*position+i).substring(11),
                    response.WeatherCodeItem(response.getHourly().getWeathercode().get(24*position+i)),
                    response.getHourly().getTemperature2m().get(24*position+i))
            );
        }

    }
}