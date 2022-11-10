package com.example.weatherapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

// Kiểm tra máy có kết nối Internet không
public class Network_Check {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) return false;
            NetworkCapabilities activeNetwork = connectivityManager.getNetworkCapabilities(network);
            if (activeNetwork == null) return false;

            if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET))
                return true;
            else return false;

        }
        else {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnectedOrConnecting() )
                return true;
            else return false;
        }
    }

}
