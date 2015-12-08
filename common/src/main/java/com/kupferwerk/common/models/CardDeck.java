package com.kupferwerk.common.models;

import android.content.Context;

import com.kupferwerk.common.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {

   public static final int FIBONACCI = 0;
   public static final int SEQUENCE = 1;
   public static final int TSHIRT = 2;

   private List<String> cards = new ArrayList<>();

   public static CardDeck build(Context context, int presetId) {
      CardDeck deck = new CardDeck();
      int resId = -1;
      switch (presetId) {
         case FIBONACCI:
            resId = R.array.fibonacci;
            break;
         case SEQUENCE:
            resId = R.array.sequence;
            break;
         case TSHIRT:
            resId = R.array.tshirt;
            break;
      }

      deck.cards = Arrays.asList(context.getResources().getStringArray(resId));
      return deck;
   }

   public int size() {
      if (cards == null) {
         return 0;
      }
      return cards.size();
   }

   public String get(int position) {
      if (cards == null || cards.isEmpty()) {
         return "";
      }
      return cards.get(position);
   }
}