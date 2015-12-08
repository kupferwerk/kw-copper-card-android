package com.kupferwerk.coppercard.core.module;

import com.kupferwerk.coppercard.core.BaseApplication;
import com.kupferwerk.coppercard.core.CrashTracker;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApplicationModule_ProvideCrashTrackerFactory implements Factory<CrashTracker> {
  private final ApplicationModule module;
  private final Provider<BaseApplication> applicationProvider;

  public ApplicationModule_ProvideCrashTrackerFactory(ApplicationModule module, Provider<BaseApplication> applicationProvider) {  
    assert module != null;
    this.module = module;
    assert applicationProvider != null;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public CrashTracker get() {  
    CrashTracker provided = module.provideCrashTracker(applicationProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<CrashTracker> create(ApplicationModule module, Provider<BaseApplication> applicationProvider) {  
    return new ApplicationModule_ProvideCrashTrackerFactory(module, applicationProvider);
  }
}

