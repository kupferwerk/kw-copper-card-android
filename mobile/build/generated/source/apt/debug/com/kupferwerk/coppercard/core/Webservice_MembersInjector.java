package com.kupferwerk.coppercard.core;

import com.kupferwerk.common.webservice.CopperCardService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class Webservice_MembersInjector implements MembersInjector<Webservice> {
  private final Provider<CopperCardService> serviceProvider;

  public Webservice_MembersInjector(Provider<CopperCardService> serviceProvider) {  
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public void injectMembers(Webservice instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.service = serviceProvider.get();
  }

  public static MembersInjector<Webservice> create(Provider<CopperCardService> serviceProvider) {  
      return new Webservice_MembersInjector(serviceProvider);
  }
}

