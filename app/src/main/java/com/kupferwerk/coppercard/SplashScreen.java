package com.kupferwerk.coppercard;

import android.os.Bundle;

import com.kupferwerk.coppercard.core.BaseActionBarActivity;
import com.kupferwerk.coppercard.core.CrashTracker;
import com.kupferwerk.coppercard.core.Injector;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit.Retrofit;

public class SplashScreen extends BaseActionBarActivity {

   @Inject
   Picasso picasso;

   @Inject
   Retrofit restAdapter;

   @Inject
   CrashTracker crashTracker;

   @Override
   protected int getLayoutResourceId() {
      return R.layout.activity_splash_screen;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Injector.getAppComponent()
            .inject(this);
      LoginActivity.start(this);
   }
}
