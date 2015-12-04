package com.kupferwerk.coppercard.model;

import android.content.Context;

import com.kupferwerk.coppercard.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {

    public static final int FIBONACCI = 0;
    public static final int SEQUENCE = 1;
    public static final int TSHIRT = 2;

    private List<String> cards = new ArrayList<>();

    public CardDeck build(Context context, int presetId) {
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
                resId = R.array.t_shirt;
                break;
        }

        deck.cards = Arrays.asList(context.getResources().getStringArray(resId));
        return deck;
    }
}
