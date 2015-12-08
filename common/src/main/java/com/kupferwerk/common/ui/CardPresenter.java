package com.kupferwerk.common.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kupferwerk.common.R;

public class CardPresenter {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtValue;
        TextView txtHeader;
        ImageView imgHeader;
        ImageView imgValue;
        public View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.txtHeader = (TextView) itemView.findViewById(R.id.txt_header);
            this.txtValue = (TextView) itemView.findViewById(R.id.txt_value);
            this.imgHeader = (ImageView) itemView.findViewById(R.id.img_header);
            this.imgValue = (ImageView) itemView.findViewById(R.id.img_value);
        }
    }

    private Context context;
    private int radius;
    private int color;


    public CardPresenter(Context context, int radius, int color) {
        this.context = context;
        this.radius = radius;
        this.color = color;
    }


    public void onBindViewHolder(ViewHolder holder, String value) {
        if (getString(R.string.coffee_mug).equals(value)) {
            holder.imgValue.setVisibility(View.VISIBLE);
            holder.imgHeader.setVisibility(View.VISIBLE);
            holder.txtValue.setVisibility(View.GONE);
            holder.txtHeader.setVisibility(View.GONE);
            return;
        }
        if (getString(R.string.no_idea).equals(value)) {
            value = "?";
        }
        holder.txtValue.setVisibility(View.VISIBLE);
        holder.txtHeader.setVisibility(View.VISIBLE);
        holder.imgValue.setVisibility(View.GONE);
        holder.imgHeader.setVisibility(View.GONE);

        holder.txtHeader.setText(value);
        holder.txtValue.setText(value);
    }

    public Drawable getCardBackground() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setStroke(radius, Color.WHITE);
        drawable.setCornerRadius(radius);

        return drawable;
    }


    protected String getString(int resId) {
        if (context == null) {
            return "";
        }
        if (resId < 0) {
            return "";
        }
        return context.getString(resId);
    }


}
