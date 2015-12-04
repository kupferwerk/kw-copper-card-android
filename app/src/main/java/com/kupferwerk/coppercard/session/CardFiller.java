package com.kupferwerk.coppercard.session;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardFiller {

    public static void fillCardWithValues(ImageView imgValue, ImageView imgHeader, TextView txtValue, TextView txtHeader, String value) {
        if (":coffee:".equals(value)) {
            imgValue.setVisibility(View.VISIBLE);
            imgHeader.setVisibility(View.VISIBLE);
            txtValue.setVisibility(View.GONE);
            txtHeader.setVisibility(View.GONE);
            return;
        }
        if (":noplan:".equals(value)) {
            value = "?";
        }
        txtValue.setVisibility(View.VISIBLE);
        txtHeader.setVisibility(View.VISIBLE);
        imgValue.setVisibility(View.GONE);
        imgHeader.setVisibility(View.GONE);

        txtHeader.setText(value);
        txtValue.setText(value);
    }

    public static GradientDrawable createCardBackground(int color, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setStroke(radius, Color.WHITE);
        drawable.setCornerRadius(radius);

        return drawable;
    }

}
