// Generated by view binder compiler. Do not edit!
package com.example.weatherapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.weatherapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class WeatherHourlyItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatTextView tempTextView;

  @NonNull
  public final AppCompatTextView timeTextView;

  @NonNull
  public final AppCompatImageView weatherImageView;

  private WeatherHourlyItemBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatTextView tempTextView, @NonNull AppCompatTextView timeTextView,
      @NonNull AppCompatImageView weatherImageView) {
    this.rootView = rootView;
    this.tempTextView = tempTextView;
    this.timeTextView = timeTextView;
    this.weatherImageView = weatherImageView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static WeatherHourlyItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static WeatherHourlyItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.weather_hourly_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static WeatherHourlyItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.temp_text_view;
      AppCompatTextView tempTextView = ViewBindings.findChildViewById(rootView, id);
      if (tempTextView == null) {
        break missingId;
      }

      id = R.id.time_text_view;
      AppCompatTextView timeTextView = ViewBindings.findChildViewById(rootView, id);
      if (timeTextView == null) {
        break missingId;
      }

      id = R.id.weather_image_view;
      AppCompatImageView weatherImageView = ViewBindings.findChildViewById(rootView, id);
      if (weatherImageView == null) {
        break missingId;
      }

      return new WeatherHourlyItemBinding((LinearLayout) rootView, tempTextView, timeTextView,
          weatherImageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
