package com.example.weatherapp.Adapter;

public class Item  {
    String day;
    int image;
    String sunrise;
    String sunset;
    Double minTemp;
    Double maxTemp;
    int bgColor;

    public Item(String day, int image, String sunrise, String sunset, Double minTemp, Double maxTemp, int bgColor) {

        this.day = day;
        this.image = image;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.bgColor = bgColor;
    };

    public Item addItem() {
        return this;
    }

    public String getDay() {
        return day;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise){
        this.sunrise = sunrise;
    }

    public String getSunset(){ return sunset;}

    public void setSunset(String sunset){
        this.sunset = sunset;
    }


    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }


}
