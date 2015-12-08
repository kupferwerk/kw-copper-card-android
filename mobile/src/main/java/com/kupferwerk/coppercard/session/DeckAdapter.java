package com.kupferwerk.coppercard.session;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kupferwerk.common.models.CardDeck;
import com.kupferwerk.common.ui.CardPresenter;
import com.kupferwerk.coppercard.R;

public class DeckAdapter extends RecyclerView.Adapter<CardPresenter.ViewHolder> {

   public interface OnItemSelectedListener {

      void onItemSelected(View view, String value);
   }

   private OnItemSelectedListener listener;

   private CardDeck deck;
   private Context context;
   private CardPresenter presenter;

   public DeckAdapter(Context context, int presetId, int color) {
      this.deck = CardDeck.build(context, presetId);
      this.context = context;
      this.presenter = new CardPresenter(context,
            context.getResources().getDimensionPixelSize(R.dimen.card_radius_small), color);
   }

   public void setOnItemSelectedListener(OnItemSelectedListener listener) {
      this.listener = listener;
   }

   @Override
   public CardPresenter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(context).inflate(R.layout.item_small_card, parent, false);
      itemView.setBackground(presenter.getCardBackground());
      return new CardPresenter.ViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(CardPresenter.ViewHolder holder, int position) {
      String value = deck.get(position);
      presenter.onBindViewHolder(holder, value);
      holder.itemView.setTag(value);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (listener != null) {
               listener.onItemSelected(v, (String) v.getTag());
            }
         }
      });
   }

   @Override
   public int getItemCount() {
      return deck.size();
   }
}


