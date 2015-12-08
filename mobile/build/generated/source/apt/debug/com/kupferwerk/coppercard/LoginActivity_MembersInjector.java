package com.kupferwerk.coppercard;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import com.kupferwerk.coppercard.core.Webservice;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<Webservice> serviceProvider;
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public LoginActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Webservice> serviceProvider, Provider<SharedPreferences> sharedPreferencesProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public void injectMembers(LoginActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.service = serviceProvider.get();
    instance.sharedPreferences = sharedPreferencesProvider.get();
  }

  public static MembersInjector<LoginActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Webservice> serviceProvider, Provider<SharedPreferences> sharedPreferencesProvider) {  
      return new LoginActivity_MembersInjector(supertypeInjector, serviceProvider, sharedPreferencesProvider);
  }
}

