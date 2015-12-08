package com.kupferwerk.coppercard.core.module;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WebserviceModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final WebserviceModule module;
  private final Provider<Context> contextProvider;

  public WebserviceModule_ProvideRetrofitFactory(WebserviceModule module, Provider<Context> contextProvider) {  
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public Retrofit get() {  
    Retrofit provided = module.provideRetrofit(contextProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Retrofit> create(WebserviceModule module, Provider<Context> contextProvider) {  
    return new WebserviceModule_ProvideRetrofitFactory(module, contextProvider);
  }
}

