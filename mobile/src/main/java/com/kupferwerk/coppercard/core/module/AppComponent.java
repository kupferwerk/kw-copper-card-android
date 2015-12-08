package com.kupferwerk.coppercard.core.module;

import android.content.Context;

import com.kupferwerk.coppercard.LoginActivity;
import com.kupferwerk.coppercard.core.BaseApplication;
import com.kupferwerk.coppercard.core.Webservice;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {ApplicationModule.class, WebserviceModule.class})
public interface AppComponent {

   BaseApplication application();

   Context context();

   void inject(LoginActivity loginActivity);

   void inject(Webservice webservice);
}
