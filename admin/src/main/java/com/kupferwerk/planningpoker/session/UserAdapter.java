package com.kupferwerk.planningpoker.session;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.planningpoker.R;
import com.kupferwerk.planningpoker.model.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

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


    private List<User> users;
    private Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_small_card, parent, false);
        itemView.setBackground(CardFiller.createCardBackground(Color.parseColor("#00ff00"), context.getResources().getDimensionPixelSize(R.dimen.card_radius_small)));
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        String value = deck.get(position);
//        CardFiller.fillCardWithValues(holder.imgValue, holder.imgHeader, holder.txtValue, holder.txtHeader, value);
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

}


