package com.example.weatherapp.models;

import com.example.weatherapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("latitude")
    @Expose
    private double latitude;

    @SerializedName("longitude")
    @Expose
    private double longitude;

    @SerializedName("generationtime_ms")
    @Expose
    private double generationtimeMs;

    @SerializedName("utc_offset_seconds")
    @Expose
    private long utcOffsetSeconds;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    @SerializedName("timezone_abbreviation")
    @Expose
    private String timezoneAbbreviation;

    @SerializedName("elevation")
    @Expose
    private double elevation;

    @SerializedName("current_weather")
    @Expose
    private Current_weather currentWeather;

    @SerializedName("hourly_units")
    @Expose
    private hourly_units hourlyUnits;

    @SerializedName("hourly")
    @Expose
    private Hourly hourly;

    @SerializedName("daily_units")
    @Expose
    private daily_units dailyUnits;

    @SerializedName("daily")
    @Expose
    private Daily daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    public long getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(long utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public Current_weather getCurrentWeather() {
        return currentWeather;
    }

    public hourly_units getHourlyUnits() {
        return hourlyUnits;
    }

    public void setHourlyUnits(hourly_units hourlyUnits) {
        this.hourlyUnits = hourlyUnits;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public daily_units getDailyUnits() {
        return dailyUnits;
    }

    public void setDailyUnits(daily_units dailyUnits) {
        this.dailyUnits = dailyUnits;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public String WeatherCodeString(int weatherCode) {
        if (weatherCode >= 0  && weatherCode <= 3) {
            return "Sunny";
        } else if (weatherCode >=4 && weatherCode <= 9) {
            return "Haze";
        } else if (weatherCode >=10 && weatherCode <= 19) {
            return "Cloudy";
        } else if (weatherCode >=20 && weatherCode <= 29) {
            return "Rainy";
        } else if (weatherCode >=30 && weatherCode <= 39) {
            return "Windy";
        } else if (weatherCode >=40 && weatherCode <= 49) {
            return "Foggy";
        } else if (weatherCode >=50 && weatherCode <= 59) {
            return "Drizzle";
        } else if (weatherCode >=60 && weatherCode <= 69) {
            return "Rainy";
        } else if (weatherCode >=70 && weatherCode <= 79) {
            return "Snow";
        } else if (weatherCode >=80 && weatherCode <= 89) {
            return "Shower rain";
        }
        return "Storm";
    }

    public int WeatherCodeFigure(int weatherCode) {
        if (weatherCode >= 0  && weatherCode <= 3) {
            return R.raw.clear_day;
        } else if (weatherCode >=4 && weatherCode <= 9) {
            return R.raw.cloudy_weather;
        } else if (weatherCode >=10 && weatherCode <= 19) {
            return R.raw.mostly_cloudy;
        } else if (weatherCode >=20 && weatherCode <= 29) {
            return R.raw.rainy_weather;
        } else if (weatherCode >=30 && weatherCode <= 39) {
            return R.raw.windy;
        } else if (weatherCode >=40 && weatherCode <= 49) {
            return R.raw.foggy;
        } else if (weatherCode >=50 && weatherCode <= 59) {
            return R.raw.drizzle;
        } else if (weatherCode >=60 && weatherCode <= 69) {
            return R.raw.rainy_weather;
        } else if (weatherCode >=70 && weatherCode <= 79) {
            return R.raw.snow_weather;
        } else if (weatherCode >=80 && weatherCode <= 89) {
            return R.raw.shower_rain;
        }
        return R.raw.storm_weather;
    }

    public int WeatherCodeItem(int weatherCode) {
        if (weatherCode >= 0  && weatherCode <= 3) {
            return R.drawable.ic_clear_day;
        } else if (weatherCode >=4 && weatherCode <= 9) {
            return R.drawable.ic_cloudy_weather;
        } else if (weatherCode >=10 && weatherCode <= 19) {
            return R.drawable.ic_mostly_cloudy;
        } else if (weatherCode >=20 && weatherCode <= 29) {
            return R.drawable.ic_rainy_weather;
        } else if (weatherCode >=30 && weatherCode <= 39) {
            return R.drawable.ic_storm_weather;
        } else if (weatherCode >=40 && weatherCode <= 49) {
            return R.drawable.ic_broken_clouds;
        } else if (weatherCode >=50 && weatherCode <= 59) {
            return R.drawable.ic_rainy_weather;
        } else if (weatherCode >=60 && weatherCode <= 69) {
            return R.drawable.ic_rainy_weather;
        } else if (weatherCode >=70 && weatherCode <= 79) {
            return R.drawable.ic_snow_weather;
        } else if (weatherCode >=80 && weatherCode <= 89) {
            return R.drawable.ic_shower_rain;
        }
        return R.drawable.ic_storm_weather;
    }
}
