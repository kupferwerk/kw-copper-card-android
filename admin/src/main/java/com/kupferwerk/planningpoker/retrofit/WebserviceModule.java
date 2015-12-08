package com.kupferwerk.planningpoker.retrofit;

import android.content.Context;

import com.kupferwerk.planningpoker.R;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module
public class WebserviceModule {

   public static final int CACHE_SIZE = 25 * 1024 * 1024;

   /* TODO: Add here provides methods for retrofit interfaces. */

   @Provides
   @Singleton
   Retrofit provideRetrofit(Context context) {
      Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(context.getString(R.string.base_url))
                  .addConverterFactory(GsonConverterFactory.create());
      if (Boolean.parseBoolean("true")) {
         OkHttpClient client = new OkHttpClient();
         //            client.interceptors()
         //                  .add(new LoggingInterceptor());
      }
      return builder.build();
   }

   private OkHttpClient getHttpClient(Context context) {
      final File cacheDirectory = new File(context.getCacheDir()
            .getAbsolutePath(), "HttpCache");
      final Cache cache = new Cache(cacheDirectory, CACHE_SIZE);
      final OkHttpClient client = new OkHttpClient();
      client.setCache(cache);
      return client;
   }
}


