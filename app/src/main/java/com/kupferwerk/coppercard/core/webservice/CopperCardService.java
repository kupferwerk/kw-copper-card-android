package com.kupferwerk.coppercard.core.webservice;

import com.kupferwerk.coppercard.model.Session;
import com.kupferwerk.coppercard.model.User;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface CopperCardService {
   @FormUrlEncoded
   @POST ("join/")
   Call<User> createUser(@Field ("name") String name, @Field ("platform") String platform, @Field("uuid") String uuid);

   @GET ("sessions/")
   Call<ArrayList<Session>> getSessions();
}
