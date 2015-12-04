package com.kupferwerk.coppercard.session;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.coppercard.R;
import com.kupferwerk.coppercard.model.CardDeck;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_value)
        TextView txtValue;
        @Bind(R.id.txt_value_header)
        TextView txtHeader;
        @Bind(R.id.img_value)
        ImageView imgHeader;
        @Bind(R.id.img_value_header)
        ImageView imgValue;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;

            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemSelectedListener {

        void onItemSelected(View view, String value);
    }

    private OnItemSelectedListener lisener;

    private CardDeck deck;
    private int color;
    private Context context;

    public DeckAdapter(Context context, int presetId, int color) {
        this.deck = CardDeck.build(context, presetId);
        this.context = context;
        this.color = color;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.lisener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_small_card, parent, false);
        itemView.setBackground(CardFiller.createCardBackground(color, context.getResources().getDimensionPixelSize(R.dimen.card_radius_small)));
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String value = deck.get(position);
        CardFiller.fillCardWithValues(holder.imgValue, holder.imgHeader, holder.txtValue, holder.txtHeader, value);
        holder.itemView.setTag(value);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lisener != null) {
                    lisener.onItemSelected(v, (String) v.getTag());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return deck.size();
    }

}


