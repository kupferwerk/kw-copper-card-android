package com.kupferwerk.coppercard.core.module;

import com.kupferwerk.coppercard.core.BaseApplication;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApplicationModule_ProvideBaseApplicationFactory implements Factory<BaseApplication> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideBaseApplicationFactory(ApplicationModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public BaseApplication get() {  
    BaseApplication provided = module.provideBaseApplication();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<BaseApplication> create(ApplicationModule module) {  
    return new ApplicationModule_ProvideBaseApplicationFactory(module);
  }
}

