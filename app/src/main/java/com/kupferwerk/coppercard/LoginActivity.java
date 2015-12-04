package com.kupferwerk.coppercard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.coppercard.utils.ImageUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

   @Bind (R.id.name)
   TextView email;
   @Bind (R.id.profilePic)
   ImageView profilePic;

   public static void start(Activity activity) {
      Intent starter = new Intent(activity, LoginActivity.class);
      activity.startActivity(starter);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
      ButterKnife.bind(this);
      ImageUtils.loadImage(this, R.drawable.placeholder, profilePic);
   }
}

