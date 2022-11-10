package com.example.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current_weather {

    @SerializedName("temperature")
    @Expose
    private double temperature;
    @SerializedName("windspeed")
    @Expose
    private double windspeed;
    @SerializedName("winddirection")
    @Expose
    private double winddirection;
    @SerializedName("weathercode")
    @Expose
    private int weathercode;
    @SerializedName("time")
    @Expose
    private String time;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public double getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(double winddirection) {
        this.winddirection = winddirection;
    }

    public int getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(int weathercode) {
        this.weathercode = weathercode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
