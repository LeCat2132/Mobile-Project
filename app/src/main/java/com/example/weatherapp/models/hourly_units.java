package com.example.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class hourly_units {
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("temperature_2m")
    @Expose
    private String temperature2m;
    @SerializedName("weathercode")
    @Expose
    private String weathercode;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature2m() {
        return temperature2m;
    }

    public void setTemperature2m(String temperature2m) {
        this.temperature2m = temperature2m;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }
}
