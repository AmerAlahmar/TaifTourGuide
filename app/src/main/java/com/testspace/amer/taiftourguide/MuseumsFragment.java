package com.testspace.amer.taiftourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment implements PlaceAdapter.OnItemPressedListener {
    View rootView;
    RecyclerView recyclerView;
    ArrayList<Place> places;
    PlaceAdapter placeAdapter;

    public MuseumsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        places = new ArrayList<>();
        placeAdapter = new PlaceAdapter();
        places.add(new Place(R.drawable.shubra,
                getString(R.string.shubraName),
                getString(R.string.shubraShortDesc),
                getString(R.string.shubraLongDesc),
                Place.NO_PHONE,
                getString(R.string.shubraWh),
                getString(R.string.shubraLocation)));
        places.add(new Place(R.drawable.sharif,
                getString(R.string.sharifName),
                getString(R.string.sharifShortDesc),
                getString(R.string.sharifLongDesc),
                Place.NO_PHONE,
                getString(R.string.sharifWh),
                getString(R.string.sharifLocation)));
        places.add(new Place(R.drawable.okaz,
                getString(R.string.okazName),
                getString(R.string.okazShortDesc),
                getString(R.string.okazLongDesc),
                getString(R.string.okazPhone),
                getString(R.string.okazWh),
                getString(R.string.okazLocation)));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Museums");
        placeAdapter.setPlaces(places);
        placeAdapter.setListener(this);
        recyclerView.setAdapter(placeAdapter);
    }

    @Override
    public void onItemClick(Place place) {
        Intent intent = new Intent(getActivity(), PlaceActivity.class);
        intent.putExtra("PLACE", place);
        startActivity(intent);
    }
}