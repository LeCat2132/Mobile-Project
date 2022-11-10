package com.example.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class daily_units {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("weathercode")
    @Expose
    private String weathercode;
    @SerializedName("temperature_2m_max")
    @Expose
    private String temperature2mMax;
    @SerializedName("temperature_2m_min")
    @Expose
    private String temperature2mMin;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }

    public String getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(String temperature2mMax) {
        this.temperature2mMax = temperature2mMax;
    }

    public String getTemperature2mMin() {
        return temperature2mMin;
    }

    public void setTemperature2mMin(String temperature2mMin) {
        this.temperature2mMin = temperature2mMin;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
