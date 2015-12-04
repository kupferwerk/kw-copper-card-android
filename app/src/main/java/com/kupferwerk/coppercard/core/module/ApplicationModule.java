package com.kupferwerk.coppercard.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.kupferwerk.coppercard.core.BaseApplication;
import com.kupferwerk.coppercard.core.CrashTracker;

@Module
public class ApplicationModule {

   private Context context;
   private BaseApplication application;

   public ApplicationModule(BaseApplication application) {
      this.application = application;
      this.context = application.getApplicationContext();
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
   BaseApplication provideBaseApplication() {
      return application;
   }

   @Provides
   @Singleton
   Context provideContext() {
      return context;
   }

   /* TODO: Add here more application specific provided objects. */
}
