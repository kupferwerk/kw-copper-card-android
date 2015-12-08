package com.kupferwerk.coppercard.session;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.common.models.CardDeck;
import com.kupferwerk.common.models.User;
import com.kupferwerk.coppercard.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SessionActivity extends AppCompatActivity {

   public static final String EXTRA_USER = "extra.user";
   @Bind (R.id.item_selected_card)
   View selectedCard;
   private User user;
   private String selectedValue;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_session);
      ButterKnife.bind(this);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      user = getIntent().getParcelableExtra(EXTRA_USER);
      selectedCard.setBackground(CardFiller.createCardBackground(Color.parseColor(user.getColor()),
            getResources().getDimensionPixelSize(R.dimen.card_radius)));

      initCardList();
   }

   private void initCardList() {
      RecyclerView list = (RecyclerView) findViewById(R.id.card_list);
      DeckAdapter adapter = new DeckAdapter(this, CardDeck.FIBONACCI, Color.parseColor(user.getColor()));
      adapter.setOnItemSelectedListener(new DeckAdapter.OnItemSelectedListener() {
         @Override
         public void onItemSelected(final View itemView, final String value) {
            if (value.equals(selectedValue)) {
               return;
            }
            selectedValue = value;
            selectedCard.setVisibility(View.VISIBLE);
            ImageView imgHeader = (ImageView) selectedCard.findViewById(R.id.img_value_header);
            ImageView imgValue = (ImageView) selectedCard.findViewById(R.id.img_value);
            TextView txtHeader = (TextView) selectedCard.findViewById(R.id.txt_value_header);
            TextView txtValue = (TextView) selectedCard.findViewById(R.id.txt_value);

            CardFiller.fillCardWithValues(imgValue, imgHeader, txtValue, txtHeader, value);
         }
      });
      list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
      list.setAdapter(adapter);
   }
}
