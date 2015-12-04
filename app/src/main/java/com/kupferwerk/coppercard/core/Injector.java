package com.kupferwerk.coppercard.core;

import com.kupferwerk.coppercard.core.module.AppComponent;
import com.kupferwerk.coppercard.core.module.ApplicationModule;
import com.kupferwerk.coppercard.core.module.DaggerAppComponent;
import com.kupferwerk.coppercard.core.module.WebserviceModule;

public final class Injector {

   public static AppComponent appComponent;

   public static void init(BaseApplication application) {
      appComponent =
            DaggerAppComponent.builder().applicationModule(new ApplicationModule(application))
                  .webserviceModule(new WebserviceModule()).build();
   }

   public static AppComponent getAppComponent() {
      return appComponent;
   }
}
