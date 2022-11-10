package com.example.weatherapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.weatherapp.Adapter.Item;
import com.example.weatherapp.Adapter.MyAdapter;
import com.example.weatherapp.Adapter.OnItemClickListener;
import com.example.weatherapp.Network_Check;
import com.example.weatherapp.NoteApp.NoteMainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.TextViewFactory;
import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.models.WeatherResponse;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient = null; // biến kiểm tra vị trí người dùng
    private ActivityMainBinding binding; // binding Main Activity để có thể truy cập vào các layout khác
    private Typeface typeface;
    private WeatherResponse response = null; // biến chứa toàn bộ kêt quả thời tiết
    private Toolbar toolbar;

    private double latitude = 0; // lấy vị trí để tạo URL
    private double longitude = 0; // lấy vị trí để tạo URL
    private URL url; // URL gọi API khi khởi tạo ứng dụng

     //---------------- INIT INSTANCES
    SharedPreferences mSharedPreferences;
    private boolean result = false;
    private LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    private List<Item> items = new ArrayList<>();
    //
    //--------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mSharedPreferences = getSharedPreferences("WeatherData",Context.MODE_PRIVATE);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_navigation);

        CallAPIloginAsyncTask getData = new CallAPIloginAsyncTask();
        getData.execute();

        setupTextSwitchers();
        InitSwipeLayout();
        InitSearchView();

    }

    @Override
    protected void onPause() {
        super.onPause();
        StoreData();
    }

    private void requestWeather(String cityName) {
        if (Network_Check.isNetworkAvailable(this)) {
            getCurrentWeather(cityName);
        } else {
            Toast.makeText(this,"No Internet connection",Toast.LENGTH_LONG).show();
            binding.swipeLayout.setRefreshing(false);
        }
    }

    private void getCurrentWeather(String cityName) {
        Geocoder geocoder = new Geocoder(MainActivity.this);
        List<Address> addressList;
        try {
            addressList = geocoder.getFromLocationName(cityName, 1);

            if (addressList != null && addressList.size() != 0){
                latitude = addressList.get(0).getLatitude();
                longitude = addressList.get(0).getLongitude();
                binding.toolbarLayout.cityNameTextView.setText(cityName);

                if (latitude == 0 && longitude == 0) {
                    return;
                }
                else {
                    CallAPIloginAsyncTask getData = new CallAPIloginAsyncTask();
                    getData.execute();
                }
            }
            else {
                Toast.makeText(MainActivity.this,"No weather data for this city currently",
                        Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void InitRecylerView() {

        binding.contentMainLayout.recyclerView.setLayoutManager(linearLayout);
        binding.contentMainLayout.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.contentMainLayout.recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, new OnItemClickListener() {
            @Override
            public void onItemClick(Item item, int position) {
                Intent intent = new Intent(MainActivity.this, Weather_hourly.class);
                intent.putExtra("Data", new Gson().toJson(response));
                intent.putExtra("Position", "" + position);
                intent.putExtra("Clicked-day", new Gson().toJson(item));
                startActivity(intent);
            }
        }));

    }

    private void Display_Info() {

        InitRecylerView();

        if (items.size() != 0)
            items.clear();

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(response.getTimezone()));
        DateFormat formatter = new SimpleDateFormat("EEEE");
        DateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy");
        List<String> dayInWeek = new ArrayList<>();

        binding.contentMainLayout.dateTextView.setText(sdf.format(calendar.getTime()));

        binding.contentMainLayout.todayMaterialCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Weather_hourly.class);
                intent.putExtra("Data", new Gson().toJson(response));
                intent.putExtra("Position", "" + -1);
                String currentDay = formatter.format(calendar.getTime());
                Item item = (new Item(currentDay,
                        response.WeatherCodeItem(response.getDaily().getWeathercode().get(0)),
                        response.getDaily().getSunrise().get(0).substring(11),
                        response.getDaily().getSunset().get(0).substring(11),
                        response.getDaily().getTemperature2mMin().get(0),
                        response.getDaily().getTemperature2mMax().get(0),
                        R.drawable.adaptercolor));
                intent.putExtra("Clicked-day", new Gson().toJson(item));
                startActivity(intent);
            }
        });


        for(int i = 0; i < 6; i++)
        {
            calendar.add(Calendar.DATE, 1);
            dayInWeek.add(formatter.format(calendar.getTime()));
            items.add(new Item(dayInWeek.get(i),
                    response.WeatherCodeItem(response.getDaily().getWeathercode().get(i+1)),
                    response.getDaily().getSunrise().get(i+1).substring(11),
                    response.getDaily().getSunset().get(i+1).substring(11),
                    response.getDaily().getTemperature2mMin().get(i+1),
                    response.getDaily().getTemperature2mMax().get(i+1),
                    R.drawable.adaptercolor));
        }

        binding.toolbarLayout.cityNameTextView.setText(convertCityName(response.getTimezone()));

        binding.contentMainLayout.tempTextView.setText(response.getCurrentWeather().getTemperature() + "");
        binding.contentMainLayout.descriptionTextView.setText(response.WeatherCodeString(response.getCurrentWeather().getWeathercode()));

        binding.contentMainLayout.sunriseTextView.setText(response.getDaily().getSunrise().get(0).substring(11));
        binding.contentMainLayout.sunsetTextView.setText(response.getDaily().getSunset().get(0).substring(11));
        binding.contentMainLayout.windTextView.setText(response.getCurrentWeather().getWindspeed() + "km/h");

        binding.contentMainLayout.animationView.setAnimation(response.WeatherCodeFigure(response.getCurrentWeather().getWeathercode()));
        binding.contentMainLayout.animationView.playAnimation();

        if (response.WeatherCodeString(response.getCurrentWeather().getWeathercode()).equals("Sunny")) {
            binding.swipeLayout.setBackgroundResource(R.drawable.aaaa);

        }
        else
        {
            binding.swipeLayout.setBackgroundResource(R.drawable.night_fall);
    
        }
    }

    private void InitSwipeLayout() {
        binding.swipeLayout.setColorSchemeColors(getResources().getColor(R.color.purple_200),
                getResources().getColor(R.color.black),
                getResources().getColor(R.color.teal_700),
                getResources().getColor(R.color.white));

        binding.swipeLayout.setOnRefreshListener(() -> {
            String city = binding.toolbarLayout.cityNameTextView.getText().toString();
            if (!city.equals(""))
                requestWeather(city);
            else {
                Toast.makeText(this,
                        "No Internet connection",
                        Toast.LENGTH_LONG).show();
                Display_Info();
            }
            binding.swipeLayout.setRefreshing(false);

        });

    }

    private void setupTextSwitchers() {
        binding.contentMainLayout.tempTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.TempTextView, true, typeface));
        binding.contentMainLayout.tempTextView.setInAnimation(MainActivity.this, R.anim.slide_in_right);
        binding.contentMainLayout.tempTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_left);

        binding.contentMainLayout.descriptionTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.DescriptionTextView, true, typeface));
        binding.contentMainLayout.descriptionTextView.setInAnimation(MainActivity.this, R.anim.slide_in_right);
        binding.contentMainLayout.descriptionTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_left);

        binding.contentMainLayout.sunriseTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.HumidityTextView, false, typeface));
        binding.contentMainLayout.sunriseTextView.setInAnimation(MainActivity.this, R.anim.slide_in_bottom);
        binding.contentMainLayout.sunriseTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_top);

        binding.contentMainLayout.sunsetTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.HumidityTextView, false, typeface));
        binding.contentMainLayout.sunsetTextView.setInAnimation(MainActivity.this, R.anim.slide_in_bottom);
        binding.contentMainLayout.sunsetTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_top);

        binding.contentMainLayout.windTextView.setFactory(new TextViewFactory(MainActivity.this, R.style.WindSpeedTextView, false, typeface));
        binding.contentMainLayout.windTextView.setInAnimation(MainActivity.this, R.anim.slide_in_bottom);
        binding.contentMainLayout.windTextView.setOutAnimation(MainActivity.this, R.anim.slide_out_top);
    }

    private void InitSearchView() {



        binding.toolbarLayout.searchView.setOnQueryTextFocusChangeListener((view, b) -> {
            if (b) {
                binding.toolbarLayout.cityNameTextView.setVisibility(View.INVISIBLE);
            }
            else
            {
                binding.toolbarLayout.cityNameTextView.setVisibility(View.VISIBLE);
            }
        });

        binding.toolbarLayout.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String city) {
                requestWeather(city);
                binding.toolbarLayout.searchView.setIconified(true);
                binding.toolbarLayout.searchView.setIconified(true);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private String GetData() {
        String result = null;
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) url.openConnection();

            int httpResult = connection.getResponseCode();

            if (httpResult == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                String line = reader.readLine();
                try {
                    while(line != null) {
                        stringBuilder.append(line).append("\n");
                        line = reader.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                result = stringBuilder.toString();

            }
            else {
                result = connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
            connection.disconnect();
        }
        return result;
    }

    private void CreateURL() throws MalformedURLException {
        //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset&current_weather=true&timezone=auto
        String url_string = "https://api.open-meteo.com/v1/forecast?latitude=";

        url_string = url_string + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset&current_weather=true&timezone=auto";
        url = new URL(url_string);
    }

    @NonNull
    private String convertCityName(String name) {
        int i = name.indexOf('/');
        return name.substring(i+1).replace('_',' ');
    }




    // Tham khao cach su dung API de lay thong tin ve
    @SuppressLint("StaticFieldLeak")
    private class CallAPIloginAsyncTask extends AsyncTask<Network_Check,Void,String> {

        private Dialog customProcessDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShowProgressDialog();

            CheckLocationEnable();
            if (Network_Check.isNetworkAvailable(MainActivity.this)) {
                result = true;
            }
        }

        @Override
        protected void onPostExecute(String result1) {
            super.onPostExecute(result1);
            cancelProgressDialog();

            if (!result1.equals("")) {
                response = new Gson().fromJson(result1, WeatherResponse.class);
            }
            else
            {
                ReadData();
            }

            Display_Info();

        }

        @Override
        protected String doInBackground(Network_Check... networkChecks) {
            // Lấy vị trí hiện tại để URL
            Log.i("result ", "" + result);
            if (result) {
                while(latitude == 0 || longitude == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    CreateURL();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return GetData();
            }
            else
                return "";

        }

        private void ShowProgressDialog() {
            customProcessDialog = new Dialog(MainActivity.this);

            customProcessDialog.setContentView(R.layout.dialog_custom_progress);
            customProcessDialog.show();
        }

        private void cancelProgressDialog() {
            customProcessDialog.dismiss();
        }

    }

    // STORE DATA
    private void StoreData() {
        String Stored_data = new Gson().toJson(response);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("WEATHER_RESPONSE", Stored_data);
        editor.apply();
    }

    // READ STORED DATA
    private void ReadData() {
        String Read_data = mSharedPreferences.getString("WEATHER_RESPONSE","");
        if (!Read_data.equals("")) {
            response = new Gson().fromJson(Read_data, WeatherResponse.class);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.note:
                // User chose the "Settings" item, show the app settings UI...
                Intent i = new Intent(this, NoteMainActivity.class);
                startActivity(i);
                return true;

            case R.id.calendar:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



    // START :  Location check
    private void CheckLocationEnable() {
        if (!isLocationEnable()) {
            Toast.makeText(
                    this,
                    "Your location provider is turned off. Please turn it on !",
                    Toast.LENGTH_LONG
            ).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);

        } else {
            Dexter.withActivity(this)
                    .withPermissions(
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                    .withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                            if (report.areAllPermissionsGranted()) {
                                requestLocationData();
                            }

                            if (report.isAnyPermissionPermanentlyDenied()) {
                                Toast.makeText((MainActivity.this), "Access denied", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                            showRationDialogForPermissions();
                        }
                    }).onSameThread()
                    .check();
        }
    }

    private final LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
            Network_Check();
        }
    };

    private void requestLocationData() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private void Network_Check() {
        if (Network_Check.isNetworkAvailable(this)) {
            Toast.makeText(this,
                    "Internet connected",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,
                    "No Internet connection",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void showRationDialogForPermissions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Permissions are denied, please turn it on")
                .setPositiveButton(
                        "GO TO SETTINGS",
                        (dialogInterface, i) -> {
                            try {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",getPackageName(),null);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                            catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                ).setNegativeButton(
                        "Cancel",
                        (dialogInterface, i) -> {
                            try {
                                finish();
                                System.exit(0);
                            }
                            catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                            }
                        });
        builder.show();
    }

    private boolean isLocationEnable() {
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        return  ( locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
    }
    // END : Location check
}