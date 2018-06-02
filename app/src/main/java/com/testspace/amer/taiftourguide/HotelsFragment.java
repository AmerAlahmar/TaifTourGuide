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

public class HotelsFragment extends Fragment implements PlaceAdapter.OnItemPressedListener {
    View rootView;
    RecyclerView recyclerView;
    ArrayList<Place> places;
    PlaceAdapter placeAdapter;

    public HotelsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        places = new ArrayList<>();
        placeAdapter = new PlaceAdapter();
        places.add(new Place(R.drawable.intercontinental,
                getString(R.string.intercontinentalName),
                getString(R.string.intercontinentalShortDesc),
                getString(R.string.intercontinentalLongDesc),
                getString(R.string.intercontinentalPhone),
                Place.NO_WH,
                getString(R.string.intercontinentalLocation)));
        places.add(new Place(R.drawable.intercontinental,
                getString(R.string.meridienName),
                getString(R.string.meridienShortDesc),
                getString(R.string.meridienLongDesc),
                getString(R.string.meridienPhone),
                Place.NO_WH,
                getString(R.string.meridienLocation)));
        places.add(new Place(R.drawable.boudl,
                getString(R.string.boudlName),
                getString(R.string.boudlShortDesc),
                getString(R.string.boudlLongDesc),
                getString(R.string.boudlPhone),
                Place.NO_WH,
                getString(R.string.boudlLocation)));
        places.add(new Place(R.drawable.awaliv,
                getString(R.string.awalivName),
                getString(R.string.awalivShortDesc),
                getString(R.string.awalivLongDesc),
                getString(R.string.awalivPhone),
                Place.NO_WH,
                getString(R.string.awalivLocation)));
        places.add(new Place(R.drawable.tulip,
                getString(R.string.tulipName),
                getString(R.string.tulipShortDesc),
                getString(R.string.tulipLongDesc),
                getString(R.string.tulipPhone),
                Place.NO_WH,
                getString(R.string.tulipLocation)));
        places.add(new Place(R.drawable.ramada,
                getString(R.string.ramadaName),
                getString(R.string.ramadaShortDesc),
                getString(R.string.ramadaLongDesc),
                getString(R.string.ramadaPhone),
                Place.NO_WH,
                getString(R.string.ramadaLocation)));
        places.add(new Place(R.drawable.al_ward,
                getString(R.string.al_wardName),
                getString(R.string.al_wardShortDesc),
                getString(R.string.al_wardLongDesc),
                getString(R.string.al_wardPhone),
                Place.NO_WH,
                getString(R.string.al_wardLocation)));
        places.add(new Place(R.drawable.ofoq,
                getString(R.string.ofoqName),
                getString(R.string.ofoqShortDesc),
                getString(R.string.ofoqLongDesc),
                Place.NO_PHONE,
                Place.NO_WH,
                getString(R.string.ofoqLocation)));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Hotels");
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