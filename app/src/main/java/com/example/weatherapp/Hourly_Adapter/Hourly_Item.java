package com.example.weatherapp.Hourly_Adapter;

public class Hourly_Item  {
    String day;
    int image;
    Double temp;

    public Hourly_Item(String day, int image, Double temp) {
        this.day = day;
        this.image = image;
        this.temp = temp;
    };

    public Hourly_Item addItem() {
        return this;
    }

    public String getDay() {
        return day;
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

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double maxTemp) {
        this.temp = maxTemp;
    }


}
