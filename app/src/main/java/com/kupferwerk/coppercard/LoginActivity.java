package com.kupferwerk.coppercard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kupferwerk.coppercard.core.Injector;
import com.kupferwerk.coppercard.core.webservice.CopperCardService;
import com.kupferwerk.coppercard.model.Session;
import com.kupferwerk.coppercard.model.User;
import com.kupferwerk.coppercard.session.SessionActivity;
import com.kupferwerk.coppercard.utils.ImageUtils;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
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
   Retrofit restAdapter;

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
      Injector.getAppComponent()
            .inject(this);
      ImageUtils.loadImage(this, R.drawable.placeholder, profilePic);
      initToolbar();
      final ViewGroup root = (ViewGroup) findViewById(R.id.root);
      final ArrayList<String> sessionsNames = new ArrayList<>();
      CopperCardService service = restAdapter.create(CopperCardService.class);
      Call<ArrayList<Session>> call = service.getSessions();
      call.enqueue(new Callback<ArrayList<Session>>() {
         @Override
         public void onResponse(Response<ArrayList<Session>> response, Retrofit retrofit) {
            if (response.body() != null) {
               for (Session session : response.body()) {
                  sessionsNames.add(session.getName());
               }
            } else {
               sessionsNames.add("DawgItem");
            }
            initList(sessionsNames);
            spinner.setVisibility(View.GONE);
         }

         @Override
         public void onFailure(Throwable t) {
            Toast.makeText(LoginActivity.this, "Smthin went wrong dawgiie", Toast.LENGTH_SHORT)
                    .show();
         }
      });
      initList(sessionsNames);
   }

   private void initList(ArrayList<String> sessionsNames) {
      ArrayAdapter<String> adapter =
            new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sessionsNames);
      listView.setAdapter(adapter);
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (!email.getText()
                    .toString()
                    .isEmpty()) {
               String uuid = UUID.randomUUID()
                       .toString();
               User user = new User(getSessionId(), email.getText()
                       .toString(), "", getPlattform(), uuid);
               sharedPreferences.edit()
                       .putString(KEY_UUID, uuid)
                       .apply();
               CopperCardService service = restAdapter.create(CopperCardService.class);
               Call<User> call =
                       service.createUser(user.getName(), user.getPlatform(), user.getUuid());
               call.enqueue(new Callback<User>() {
                  @Override
                  public void onResponse(Response<User> response, Retrofit retrofit) {
                  }

                  @Override
                  public void onFailure(Throwable t) {
                     Toast.makeText(LoginActivity.this, "Smthin went wrong dawgiie",
                             Toast.LENGTH_SHORT)
                             .show();
                     UUID.randomUUID();
                  }
               });
               Intent intent = new Intent(LoginActivity.this, SessionActivity.class);
               startActivity(intent);
            } else {
               Toast.makeText(LoginActivity.this, "Please fill out everything! dawg",
                       Toast.LENGTH_SHORT)
                       .show();
            }
         }
      });
   }

   private void initToolbar() {
      setSupportActionBar(toolbar);
   }
}

