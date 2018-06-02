package com.testspace.amer.taiftourguide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    private ArrayList<Place> places = new ArrayList<>();
    private OnItemPressedListener listener;

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_place, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        holder.bind(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public void setListener(OnItemPressedListener listener) {
        this.listener = listener;
    }

    private OnItemPressedListener getListener() {
        return listener;
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.placeNameListTextView)
        TextView placeNameListTextView;
        @BindView(R.id.placeDescShortTextView)
        TextView placeDescShortTextView;
        @BindView(R.id.placeImgListImageView)
        ImageView placeImgListImageView;
        View itemView;

        PlaceViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

        void bind(final Place place) {
            placeImgListImageView.setImageResource(place.getImgId());
            placeNameListTextView.setText(place.getName());
            placeDescShortTextView.setText(place.getShortDesc());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getListener() != null) {
                        getListener().onItemClick(place);
                    }
                }
            });
        }
    }

    interface OnItemPressedListener {
        void onItemClick(Place place);
    }
}