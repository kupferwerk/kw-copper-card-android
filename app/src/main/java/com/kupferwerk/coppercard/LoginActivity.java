package com.kupferwerk.coppercard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kupferwerk.coppercard.core.Injector;
import com.kupferwerk.coppercard.core.webservice.CopperCardService;
import com.kupferwerk.coppercard.model.User;
import com.kupferwerk.coppercard.session.SessionActivity;
import com.kupferwerk.coppercard.utils.ImageUtils;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity implements Callback<User> {

   @Bind (R.id.name)
   TextView email;
   @Bind (R.id.profilePic)
   ImageView profilePic;
   @Bind (R.id.android)
   RadioButton btnAndroid;
   @Bind (R.id.ios)
   RadioButton btnIos;
   @Bind (R.id.toolbar)
   Toolbar toolbar;

   @Inject
   Retrofit restAdapter;

   @Override
   public void onResponse(Response<User> response, Retrofit retrofit) {
      String userId = response.body()
            .getUserId();
      Toast.makeText(this, userId + " " + response.body()
            .getColor(), Toast.LENGTH_SHORT)
            .show();
   }

   @Override
   public void onFailure(Throwable t) {
      Toast.makeText(this, "Smthin went wrong dawgiie", Toast.LENGTH_SHORT)
            .show();
   }

   @OnClick (R.id.signIn)
   protected void onSignIn() {
      if (email.getText() != null) {
         User user = new User(getSessionId(), email.getText()
               .toString(), "", getPlattform());
         CopperCardService service = restAdapter.create(CopperCardService.class);
         Call<User> call = service.createUser(user.getName(), user.getPlatform());
         call.enqueue(this);
      } else {
         Toast.makeText(this, "Please fill out everything! dawg", Toast.LENGTH_SHORT)
               .show();
      }

      Intent intent = new Intent(this, SessionActivity.class);
      startActivity(intent);
   }

   private String getPlattform() {
      if (btnAndroid.isChecked()) {
         return "android";
      } else if (btnIos.isChecked()) {
         return "ios";
      } else {
         return "windows";
      }
   }

   private String getSessionId() {
      return "";
   }

   public static void start(Activity activity) {
      Intent starter = new Intent(activity, LoginActivity.class);
      activity.startActivity(starter);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
      ButterKnife.bind(this);
      Injector.getAppComponent()
            .inject(this);
      ImageUtils.loadImage(this, R.drawable.placeholder, profilePic);
      initToolbar();
   }

   private void initToolbar() {
      setSupportActionBar(toolbar);
   }
}

