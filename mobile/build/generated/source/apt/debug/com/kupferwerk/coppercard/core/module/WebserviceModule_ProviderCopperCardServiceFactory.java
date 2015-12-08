package com.kupferwerk.coppercard.core.module;

import com.kupferwerk.common.webservice.CopperCardService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WebserviceModule_ProviderCopperCardServiceFactory implements Factory<CopperCardService> {
  private final WebserviceModule module;
  private final Provider<Retrofit> retrofitProvider;

  public WebserviceModule_ProviderCopperCardServiceFactory(WebserviceModule module, Provider<Retrofit> retrofitProvider) {  
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CopperCardService get() {  
    CopperCardService provided = module.providerCopperCardService(retrofitProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<CopperCardService> create(WebserviceModule module, Provider<Retrofit> retrofitProvider) {  
    return new WebserviceModule_ProviderCopperCardServiceFactory(module, retrofitProvider);
  }
}

