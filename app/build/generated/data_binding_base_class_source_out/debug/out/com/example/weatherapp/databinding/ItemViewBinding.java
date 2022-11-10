// Generated by view binder compiler. Do not edit!
package com.example.weatherapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.weatherapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemViewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView descriptionoutput;

  @NonNull
  public final TextView timeoutput;

  @NonNull
  public final TextView titleoutput;

  private ItemViewBinding(@NonNull RelativeLayout rootView, @NonNull TextView descriptionoutput,
      @NonNull TextView timeoutput, @NonNull TextView titleoutput) {
    this.rootView = rootView;
    this.descriptionoutput = descriptionoutput;
    this.timeoutput = timeoutput;
    this.titleoutput = titleoutput;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.descriptionoutput;
      TextView descriptionoutput = ViewBindings.findChildViewById(rootView, id);
      if (descriptionoutput == null) {
        break missingId;
      }

      id = R.id.timeoutput;
      TextView timeoutput = ViewBindings.findChildViewById(rootView, id);
      if (timeoutput == null) {
        break missingId;
      }

      id = R.id.titleoutput;
      TextView titleoutput = ViewBindings.findChildViewById(rootView, id);
      if (titleoutput == null) {
        break missingId;
      }

      return new ItemViewBinding((RelativeLayout) rootView, descriptionoutput, timeoutput,
          titleoutput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}