package com.kupferwerk.coppercard.core.module;

import com.kupferwerk.coppercard.core.Webservice;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class WebserviceModule_ProvideWebserviceFactory implements Factory<Webservice> {
  private final WebserviceModule module;

  public WebserviceModule_ProvideWebserviceFactory(WebserviceModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Webservice get() {  
    Webservice provided = module.provideWebservice();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Webservice> create(WebserviceModule module) {  
    return new WebserviceModule_ProvideWebserviceFactory(module);
  }
}

