package com.kupferwerk.coppercard.core.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.kupferwerk.common.webservice.CopperCardService;
import com.kupferwerk.coppercard.LoginActivity;
import com.kupferwerk.coppercard.LoginActivity_MembersInjector;
import com.kupferwerk.coppercard.core.BaseApplication;
import com.kupferwerk.coppercard.core.Webservice;
import com.kupferwerk.coppercard.core.Webservice_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerAppComponent implements AppComponent {
  private Provider<BaseApplication> provideBaseApplicationProvider;
  private Provider<Context> provideContextProvider;
  private Provider<Webservice> provideWebserviceProvider;
  private Provider<SharedPreferences> provideSharedPreferencesProvider;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;
  private Provider<Retrofit> provideRetrofitProvider;
  private Provider<CopperCardService> providerCopperCardServiceProvider;
  private MembersInjector<Webservice> webserviceMembersInjector;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideBaseApplicationProvider = ScopedProvider.create(ApplicationModule_ProvideBaseApplicationFactory.create(builder.applicationModule));
    this.provideContextProvider = ScopedProvider.create(ApplicationModule_ProvideContextFactory.create(builder.applicationModule));
    this.provideWebserviceProvider = ScopedProvider.create(WebserviceModule_ProvideWebserviceFactory.create(builder.webserviceModule));
    this.provideSharedPreferencesProvider = ScopedProvider.create(ApplicationModule_ProvideSharedPreferencesFactory.create(builder.applicationModule));
    this.loginActivityMembersInjector = LoginActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideWebserviceProvider, provideSharedPreferencesProvider);
    this.provideRetrofitProvider = ScopedProvider.create(WebserviceModule_ProvideRetrofitFactory.create(builder.webserviceModule, provideContextProvider));
    this.providerCopperCardServiceProvider = ScopedProvider.create(WebserviceModule_ProviderCopperCardServiceFactory.create(builder.webserviceModule, provideRetrofitProvider));
    this.webserviceMembersInjector = Webservice_MembersInjector.create(providerCopperCardServiceProvider);
  }

  @Override
  public BaseApplication application() {  
    return provideBaseApplicationProvider.get();
  }

  @Override
  public Context context() {  
    return provideContextProvider.get();
  }

  @Override
  public void inject(LoginActivity loginActivity) {  
    loginActivityMembersInjector.injectMembers(loginActivity);
  }

  @Override
  public void inject(Webservice webservice) {  
    webserviceMembersInjector.injectMembers(webservice);
  }

  public static final class Builder {
    private ApplicationModule applicationModule;
    private WebserviceModule webserviceModule;
  
    private Builder() {  
    }
  
    public AppComponent build() {  
      if (applicationModule == null) {
        throw new IllegalStateException("applicationModule must be set");
      }
      if (webserviceModule == null) {
        this.webserviceModule = new WebserviceModule();
      }
      return new DaggerAppComponent(this);
    }
  
    public Builder applicationModule(ApplicationModule applicationModule) {  
      if (applicationModule == null) {
        throw new NullPointerException("applicationModule");
      }
      this.applicationModule = applicationModule;
      return this;
    }
  
    public Builder webserviceModule(WebserviceModule webserviceModule) {  
      if (webserviceModule == null) {
        throw new NullPointerException("webserviceModule");
      }
      this.webserviceModule = webserviceModule;
      return this;
    }
  }
}

