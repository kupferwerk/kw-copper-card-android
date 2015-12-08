package com.kupferwerk.coppercard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kupferwerk.common.models.Session;
import com.kupferwerk.common.models.User;
import com.kupferwerk.coppercard.core.Injector;
import com.kupferwerk.coppercard.core.Webservice;
import com.kupferwerk.coppercard.session.SessionActivity;
import com.kupferwerk.coppercard.utils.ImageUtils;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {

   private static final String KEY_UUID = "uuid_user";
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
   @Bind (R.id.listView)
   ListView listView;
   @Bind (R.id.spinner)
   ProgressBar spinner;
   @Inject
   Webservice service;

   @Inject
   SharedPreferences sharedPreferences;

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
      Injector.getAppComponent().inject(this);
      ImageUtils.loadImage(this, R.drawable.placeholder, profilePic);
      initToolbar();
      requestSessions();
   }

   private void requestSessions() {
      service.getSessions(new Webservice.Callback<ArrayList<Session>>() {
                             @Override
                             public void onResponse(Response<ArrayList<Session>> response, Retrofit retrofit) {
                                spinner.setVisibility(View.GONE);
                                if (response.body() == null) {
                                   // something went wrong
                                   return;
                                }
                                initList(response.body());
                             }
                          }

      );
   }

   private void initList(final ArrayList<Session> sessions) {
      // TDOO use a recycler
      ArrayList<String> sessionsNames = new ArrayList<>();
      for (Session session : sessions) {
         sessionsNames.add(session.getName());
      }
      ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sessionsNames);
      listView.setAdapter(adapter);
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (!email.getText().toString().isEmpty()) {
               join(sessions.get(position).getSessionId());
            } else {
               Toast.makeText(LoginActivity.this, "Please fill out everything! dawg", Toast.LENGTH_SHORT).show();
            }
         }
      });
   }

   private void join(String sessionId) {
      final User user = buildUser();
      service.join(sessionId, user, new Webservice.Callback<User>() {
         @Override
         public void onResponse(Response<User> response, Retrofit retrofit) {
            Intent intent = new Intent(LoginActivity.this, SessionActivity.class);
            if (response != null) {
               User result = response.body();
               user.setColor(result.getColor());
               intent.putExtra(SessionActivity.EXTRA_USER, user);
            }
            startActivity(intent);
         }
      });
   }

   @NonNull
   private User buildUser() {
      String uuid = UUID.randomUUID().toString();
      User user = new User(getSessionId(), email.getText().toString(), "", getPlattform(), uuid);
      sharedPreferences.edit().putString(KEY_UUID, uuid).apply();
      return user;
   }

   private void initToolbar() {
      setSupportActionBar(toolbar);
   }
}

