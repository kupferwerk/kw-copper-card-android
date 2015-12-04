package com.kupferwerk.coppercard.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtils {

   public static void loadImage(Context context, int profilePic, ImageView imageView) {
      Picasso.with(context)
            .load(profilePic)
            .into(imageView);
   }
}
