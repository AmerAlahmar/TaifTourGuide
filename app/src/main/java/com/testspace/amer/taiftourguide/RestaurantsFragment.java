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

public class RestaurantsFragment extends Fragment implements PlaceAdapter.OnItemPressedListener {
    View rootView;
    RecyclerView recyclerView;
    ArrayList<Place> places;
    PlaceAdapter placeAdapter;

    public RestaurantsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        places = new ArrayList<>();
        placeAdapter = new PlaceAdapter();
        places.add(new Place(R.drawable.albaik,
                getString(R.string.albaikName),
                getString(R.string.albaikName),
                getString(R.string.albaikName),
                getString(R.string.albaikName),
                getString(R.string.albaikName),
                getString(R.string.albaikName)));
        places.add(new Place(R.drawable.hirrman1,
                getString(R.string.hirrman1Name),
                getString(R.string.hirrman1ShortDesc),
                getString(R.string.hirrman1LongDesc),
                getString(R.string.hirrman1Phone),
                getString(R.string.hirrman1Wh),
                getString(R.string.hirrman1Location)));
        places.add(new Place(R.drawable.mabshoor,
                getString(R.string.mabshoorName),
                getString(R.string.mabshoorShortDesc),
                getString(R.string.mabshoorLongDesc),
                getString(R.string.mabshoorPhone),
                getString(R.string.mabshoorWh),
                getString(R.string.mabshoorLocation)));
        places.add(new Place(R.drawable.mirage,
                getString(R.string.mirageName),
                getString(R.string.mirageShortDesc),
                getString(R.string.mirageLongDesc),
                getString(R.string.miragePhone),
                getString(R.string.mirageWh),
                getString(R.string.mirageLocation)));
        places.add(new Place(R.drawable.vitamin,
                getString(R.string.vitaminName),
                getString(R.string.vitaminShortDesc),
                getString(R.string.vitaminLongDesc),
                getString(R.string.vitaminPhone),
                getString(R.string.vitaminWh),
                getString(R.string.vitaminLocation)));
        places.add(new Place(R.drawable.china,
                getString(R.string.chinaName),
                getString(R.string.chinaShortDesc),
                getString(R.string.chinaLongDesc),
                getString(R.string.chinaPhone),
                getString(R.string.chinaWh),
                getString(R.string.chinaLocation)));
        places.add(new Place(R.drawable.gusto,
                getString(R.string.gustoName),
                getString(R.string.gustoShortDesc),
                getString(R.string.gustoLongDesc),
                getString(R.string.gustoPhone),
                getString(R.string.gustoWh),
                getString(R.string.gustoLocation)));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Restaurants");
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