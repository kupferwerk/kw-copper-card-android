package com.kupferwerk.coppercard.core;

import com.kupferwerk.common.models.Session;
import com.kupferwerk.common.models.User;
import com.kupferwerk.common.webservice.CopperCardService;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

public class Webservice {

   public static class Callback<T> implements retrofit.Callback<T> {

      @Override
      public void onResponse(Response<T> response, Retrofit retrofit) {

      }

      @Override
      public void onFailure(Throwable t) {

      }
   }

   @Inject
   CopperCardService service;

   public Webservice() {
      Injector.getAppComponent().inject(this);
   }

   public void join(final String sessionId, final User user, Webservice.Callback<User> callback) {
      Call<User> call = service.join(sessionId, user.getName(), user.getPlatform(), user.getUuid());
      call.enqueue(callback);
   }

   public void getSessions(Webservice.Callback<ArrayList<Session>> callback) {
      Call<ArrayList<Session>> call = service.getSessions();
      call.enqueue(callback);
   }
}
