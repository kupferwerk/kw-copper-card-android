package com.kupferwerk.coppercard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kupferwerk.coppercard.model.User;
import com.kupferwerk.coppercard.session.SessionActivity;
import com.kupferwerk.coppercard.utils.ImageUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

   @Bind (R.id.name)
   TextView email;
   @Bind (R.id.profilePic)
   ImageView profilePic;
   @Bind (R.id.android)
   RadioButton btnAndroid;
   @Bind (R.id.ios)
   RadioButton btnIos;

   @OnClick (R.id.signIn)
   protected void onSignIn() {
      if (email.getText() != null && getSessionId() != null) {
         User user = new User(getSessionId(), email.getText()
               .toString(), "", getPlattform());
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
      ImageUtils.loadImage(this, R.drawable.placeholder, profilePic);
   }
}

