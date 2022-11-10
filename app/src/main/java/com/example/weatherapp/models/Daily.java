package com.example.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Daily {

    @SerializedName("time")
    @Expose
    private List<String> time = null;

    @SerializedName("weathercode")
    @Expose
    private List<Integer> weathercode = null;

    @SerializedName("temperature_2m_max")
    @Expose
    private List<Double> temperature2mMax = null;

    @SerializedName("temperature_2m_min")
    @Expose
    private List<Double> temperature2mMin = null;

    @SerializedName("sunrise")
    @Expose
    private List<String> sunrise = null;

    @SerializedName("sunset")
    @Expose
    private List<String> sunset = null;

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Integer> getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(List<Integer> weathercode) {
        this.weathercode = weathercode;
    }

    public List<Double> getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(List<Double> temperature2mMax) {
        this.temperature2mMax = temperature2mMax;
    }

    public List<Double> getTemperature2mMin() {
        return temperature2mMin;
    }

    public void setTemperature2mMin(List<Double> temperature2mMin) {
        this.temperature2mMin = temperature2mMin;
    }

    public List<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(List<String> sunrise) {
        this.sunrise = sunrise;
    }

    public List<String> getSunset() {
        return sunset;
    }

    public void setSunset(List<String> sunset) {
        this.sunset = sunset;
    }


}
