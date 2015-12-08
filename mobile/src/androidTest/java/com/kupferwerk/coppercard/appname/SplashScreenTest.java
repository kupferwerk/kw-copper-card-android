package com.kupferwerk.coppercard.appname;

import android.test.ActivityInstrumentationTestCase2;

import com.kupferwerk.coppercard.SplashScreen;

public class SplashScreenTest extends ActivityInstrumentationTestCase2<SplashScreen> {

   private SplashScreen activity;

   public SplashScreenTest() {
      super(SplashScreen.class);
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      activity = getActivity();
   }
}