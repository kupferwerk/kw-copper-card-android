package com.kupferwerk.coppercard.session;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.coppercard.R;
import com.kupferwerk.coppercard.model.CardDeck;
import com.kupferwerk.coppercard.model.Session;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SessionActivity extends AppCompatActivity {

    @Bind(R.id.item_selected_card)
    FrameLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCardList();
    }

    private void initCardList() {
        RecyclerView list = (RecyclerView) findViewById(R.id.card_list);
        DeckAdapter adapter = new DeckAdapter(this, CardDeck.FIBONACCI);
        adapter.setOnItemSelectedListener(new DeckAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(View itemView, String value) {
                parent.removeAllViews();
                ViewGroup selectedCard = (ViewGroup) LayoutInflater.from(SessionActivity.this).inflate(R.layout.item_card, parent, false);

                ImageView imgHeader = (ImageView) selectedCard.findViewById(R.id.img_value_header);
                ImageView imgValue = (ImageView) selectedCard.findViewById(R.id.img_value);
                TextView txtHeader = (TextView) selectedCard.findViewById(R.id.txt_value_header);
                TextView txtValue = (TextView) selectedCard.findViewById(R.id.txt_value);

                CardFiller.fillCardWithValues(imgValue, imgHeader, txtValue, txtHeader, value);


                Transition transition = new AutoTransition();
                Scene scene = new Scene(parent, selectedCard);
                TransitionManager.go(scene, transition);
            }
        });
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list.setAdapter(adapter);
    }


}
