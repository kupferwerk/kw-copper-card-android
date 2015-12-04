package com.kupferwerk.coppercard.core.webservice;

import com.kupferwerk.coppercard.model.User;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface CopperCardService {
   //   users/?name=yolso&platform=ios
   @FormUrlEncoded
   @POST ("join/")
   Call<User> createUser(@Field ("name") String name, @Field ("platform") String platform);
}
