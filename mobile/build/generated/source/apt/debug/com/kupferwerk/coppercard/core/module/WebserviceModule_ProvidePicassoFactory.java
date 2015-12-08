package com.kupferwerk.coppercard.core.module;

import android.content.Context;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WebserviceModule_ProvidePicassoFactory implements Factory<Picasso> {
  private final WebserviceModule module;
  private final Provider<Context> contextProvider;

  public WebserviceModule_ProvidePicassoFactory(WebserviceModule module, Provider<Context> contextProvider) {  
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public Picasso get() {  
    Picasso provided = module.providePicasso(contextProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Picasso> create(WebserviceModule module, Provider<Context> contextProvider) {  
    return new WebserviceModule_ProvidePicassoFactory(module, contextProvider);
  }
}

