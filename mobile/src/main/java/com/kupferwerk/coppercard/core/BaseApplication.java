package com.kupferwerk.coppercard.core;

import android.app.Application;

public class BaseApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Injector.init(this);
   }


}
