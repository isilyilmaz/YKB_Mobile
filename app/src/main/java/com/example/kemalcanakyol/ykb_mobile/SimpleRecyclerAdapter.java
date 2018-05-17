package com.example.kemalcanakyol.ykb_mobile;

/**
 * Created by kemalcanakyol on 16.05.2018.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cardName;
        public TextView cardNumber;
        public ImageView card_img;
        public CardView card_view;


        public ViewHolder(final View view) {
            super(view);

            cardName= (TextView) view.findViewById(R.id.card_name);
            cardNumber = (TextView)view.findViewById(R.id.card_number);
            card_img = (ImageView)view.findViewById(R.id.card_image);
            card_view = view.findViewById(R.id.card_view);

        }
    }

    List<CreditCard> credit_card_list;
    CustomItemClickListener listener;
    public SimpleRecyclerAdapter(List<CreditCard> credit_card_list, CustomItemClickListener listener) {

        this.credit_card_list = credit_card_list;
        this.listener = listener;
    }


    @Override
    public SimpleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        final ViewHolder view_holder = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, view_holder.getPosition());
            }
        });

        return view_holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CreditCard card = credit_card_list.get(position);
        holder.cardName.setText(card.getCardName());
        holder.cardNumber.setText(card.getCardNumber());
        holder.card_img.setImageResource(card.getPhotoId());

    }

    @Override
    public int getItemCount() {
        return credit_card_list.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
