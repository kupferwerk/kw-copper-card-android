package com.kupferwerk.common.webservice;

import com.kupferwerk.common.models.ApiResult;
import com.kupferwerk.common.models.Session;
import com.kupferwerk.common.models.User;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface CopperCardService {

   /**
    * join a selected session/estimation round
    */
   @FormUrlEncoded
   @POST ("join/")
   Call<User> join(@Field ("sessionid") String sessionid, @Field ("name") String userName,
         @Field ("platform") String platform, @Field ("uuid") String uuid);

   /**
    * getting a list with all opened sessions
    */
   @GET ("sessions/")
   Call<ArrayList<Session>> getSessions();

   // TODO ------------------------------------------------------------------------------------------------------------
   // TODO These calls have to be implemented on server side too!
   // TODO ------------------------------------------------------------------------------------------------------------

   /**
    * sedning the estimation to round
    */
   @FormUrlEncoded
   @POST ("estimate/")
   Call<ApiResult> estimate(String uuid, String value);

   /**
    * open a new session
    */
   @FormUrlEncoded
   @POST ("create/")
   Call<ApiResult> createSession(String sessionId, String presetId);

   /**
    * refresh the current session to retrieve estimation from developers
    */
   @FormUrlEncoded
   @GET ("refresh/")
   Call<ArrayList<User>> refreshSession(String sesstionId);

   /**
    * reset all estimation for all users
    */
   @FormUrlEncoded
   @POST ("reset/")
   Call<ArrayList<User>> resetSession(String sesstionId);

   /**
    * close session for good
    */
   @FormUrlEncoded
   @DELETE ("terminate/")
   Call<ApiResult> closeSession(String sessionId);
}
