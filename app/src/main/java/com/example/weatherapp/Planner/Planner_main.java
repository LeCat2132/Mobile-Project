package com.example.weatherapp.Planner;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weatherapp.R;

public class  Planner_main extends Activity {

    CustomCalendarGridView customCalendarGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planner_activity_main);
        customCalendarGridView = findViewById(R.id.main_view);
    }


}