package com.testspace.amer.taiftourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceActivity extends AppCompatActivity {
    Place place;
    @BindView(R.id.placeImgImageView)
    ImageView placeImgImageView;
    @BindView(R.id.placeNameTextView)
    TextView placeNameTextView;
    @BindView(R.id.placeDescLongTextView)
    TextView placeDescLongTextView;
    @BindView(R.id.phoneTitle)
    TextView phoneTitle;
    @BindView(R.id.whTitle)
    TextView whTitle;
    @BindView(R.id.placePhoneTextView)
    TextView placePhoneTextView;
    @BindView(R.id.placeWhTextView)
    TextView placeWhTextView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        ButterKnife.bind(this);
        place = (Place) getIntent().getSerializableExtra("PLACE");
        placeImgImageView.setImageResource(place.getImgId());
        placeNameTextView.setText(place.getName());
        placeDescLongTextView.setText(place.getLongDesc());
        if (place.getPhone().equals(Place.NO_PHONE)) {
            phoneTitle.setVisibility(View.GONE);
            placePhoneTextView.setVisibility(View.GONE);
        } else {
            placePhoneTextView.setText(place.getPhone());
        }
        if (place.getWh().equals(Place.NO_WH)) {
            whTitle.setVisibility(View.GONE);
            placeWhTextView.setVisibility(View.GONE);
        } else {
            placeWhTextView.setText(place.getWh());
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + place.getLocation() + "&mode=d"))
                        .setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
    }
}