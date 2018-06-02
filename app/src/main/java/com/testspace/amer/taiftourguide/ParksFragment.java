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

public class ParksFragment extends Fragment implements PlaceAdapter.OnItemPressedListener {
    View rootView;
    RecyclerView recyclerView;
    ArrayList<Place> places;
    PlaceAdapter placeAdapter;

    public ParksFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        places = new ArrayList<>();
        placeAdapter = new PlaceAdapter();
        places.add(new Place(R.drawable.wahbah,
                getString(R.string.wahbahName),
                getString(R.string.wahbahShortDesc),
                getString(R.string.wahbahLongDesc),
                Place.NO_PHONE,
                getString(R.string.wahbahWh),
                getString(R.string.wahbahLocation)));
        places.add(new Place(R.drawable.daka,
                getString(R.string.dakaName),
                getString(R.string.dakaShortDesc),
                getString(R.string.dakaLongDesc),
                Place.NO_PHONE,
                getString(R.string.dakaWh),
                getString(R.string.dakaLocation)));
        places.add(new Place(R.drawable.rudaf,
                getString(R.string.rudafName),
                getString(R.string.rudafShortDesc),
                getString(R.string.rudafLongDesc),
                Place.NO_PHONE,
                getString(R.string.rudafWh),
                getString(R.string.rudafLocation)));
        places.add(new Place(R.drawable.saiysad,
                getString(R.string.saiysadName),
                getString(R.string.saiysadShortDesc),
                getString(R.string.saiysadLongDesc),
                Place.NO_PHONE,
                getString(R.string.saiysadWh),
                getString(R.string.saiysadLocation)));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Attractions And Parks");
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