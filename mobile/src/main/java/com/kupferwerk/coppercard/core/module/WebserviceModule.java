package com.kupferwerk.coppercard.core.module;

import android.content.Context;

import com.kupferwerk.common.webservice.CopperCardService;
import com.kupferwerk.common.webservice.logging.LoggingInterceptor;
import com.kupferwerk.coppercard.BuildConfig;
import com.kupferwerk.coppercard.R;
import com.kupferwerk.coppercard.core.Webservice;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.Executors;

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
   Picasso providePicasso(Context context) {
      Picasso.Builder imageLoaderBuilder = new Picasso.Builder(context);
      imageLoaderBuilder.executor(Executors.newSingleThreadExecutor());
      return imageLoaderBuilder.build();
   }

   @Provides
   @Singleton
   Retrofit provideRetrofit(Context context) {
      Retrofit.Builder builder = new Retrofit.Builder().baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(GsonConverterFactory.create());
      if (BuildConfig.DEBUG) {
         OkHttpClient client = new OkHttpClient();
         client.interceptors().add(new LoggingInterceptor());
      }
      return builder.build();
   }

   private OkHttpClient getHttpClient(Context context) {
      final File cacheDirectory = new File(context.getCacheDir().getAbsolutePath(), "HttpCache");
      final Cache cache = new Cache(cacheDirectory, CACHE_SIZE);
      final OkHttpClient client = new OkHttpClient();
      client.setCache(cache);
      return client;
   }

   @Provides
   @Singleton
   CopperCardService providerCopperCardService(Retrofit retrofit) {
      return retrofit.create(CopperCardService.class);
   }

   @Provides
   @Singleton
   Webservice provideWebservice() {
      return new Webservice();
   }
}
