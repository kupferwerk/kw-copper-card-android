package com.kupferwerk.coppercard.core.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.kupferwerk.coppercard.core.BaseApplication;
import com.kupferwerk.coppercard.core.CrashTracker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

   private static final String FREELETICS_PREFERENCES = "coppercard_preferences";
   private BaseApplication application;
   private Context context;
   private SharedPreferences sharedPreferences;

   public ApplicationModule(BaseApplication application) {
      this.application = application;
      this.context = application.getApplicationContext();
      this.sharedPreferences = application.getSharedPreferences(FREELETICS_PREFERENCES, Context.MODE_PRIVATE);
   }

   @Provides
   @Singleton
   BaseApplication provideBaseApplication() {
      return application;
   }

   @Provides
   @Singleton
   Context provideContext() {
      return context;
   }

   @Provides
   @Singleton
   CrashTracker provideCrashTracker(BaseApplication application) {
      CrashTracker crashTracker = new CrashTracker(application);
      crashTracker.init();
      return crashTracker;
   }

   @Provides
   @Singleton
   SharedPreferences provideSharedPreferences() {
      return sharedPreferences;
   }

   /* TODO: Add here more application specific provided objects. */
}
