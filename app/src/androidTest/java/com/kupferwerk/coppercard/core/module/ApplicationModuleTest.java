package com.kupferwerk.coppercard.core.module;

import android.test.AndroidTestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class ApplicationModuleTest extends AndroidTestCase {

   private ApplicationModule applicationModule;

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      applicationModule = new ApplicationModule(
            (com.kupferwerk.coppercard.core.BaseApplication) getContext()
                  .getApplicationContext());
   }

   public void testProvideCrashTracker() {
      assertThat(applicationModule.provideCrashTracker(
            (com.kupferwerk.coppercard.core.BaseApplication) getContext()
                  .getApplicationContext()), notNullValue());
   }
}
