package packagename.app.com.appname.core;

import packagename.app.com.appname.core.module.AppComponent;
import packagename.app.com.appname.core.module.ApplicationModule;
import packagename.app.com.appname.core.module.DaggerAppComponent;
import packagename.app.com.appname.core.module.WebserviceModule;

public final class Injector {

   public static AppComponent appComponent;

   public static void init(BaseApplication application) {
      appComponent =
            DaggerAppComponent.builder().applicationModule(new ApplicationModule(application))
                  .webserviceModule(new WebserviceModule()).build();
   }

   public static AppComponent getAppComponent() {
      return appComponent;
   }
}
