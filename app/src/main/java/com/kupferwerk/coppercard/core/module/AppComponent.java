package com.kupferwerk.coppercard.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.kupferwerk.coppercard.SplashScreen;
import com.kupferwerk.coppercard.core.BaseApplication;

@Singleton
@Component (modules = { ApplicationModule.class, WebserviceModule.class })
public interface AppComponent {

   BaseApplication application();

   Context context();

   void inject(SplashScreen splashScreen);
}
