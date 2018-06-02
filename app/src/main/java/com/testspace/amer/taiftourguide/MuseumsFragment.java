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
                "Shubra Palace",
                "A great historical building used by several generations of Royal families and governors of AlHijaz and Saudi Royal family.",
                "Shubra Palace is a museum in Taif. The building was completed in 1325 AH and the construction took 3 years. King Abdul-Aziz lived in the palace and King Faisal used it as a headquarters for the council of the ministry of defense and aviation.\n\nGuided tours are available here. However, bear in mind that this place is not wheelchair-friendly and you will need to go up the stairs in order to have a complete tour of the museum.",
                Place.NO_PHONE,
                "Friday: Closed.\nOther days: 9 AM - 6 PM.",
                "21.286310,40.414985"));
        places.add(new Place(R.drawable.sharif,
                "Sharif Museum",
                "This is a collection of everything from Arabic home living crammed into a series of rooms decorated like local houses.",
                "Al-Sharif Museum is one of the museums of the Makkah Region in Taif Governorate. It was founded on the back of Meles Al-Sharif. It is a national museum inside a large building of 5000 square meters. It contains a large collection of heritage pieces of all kinds, functions, and materials. On a small market is a group of stalls or shops and make each shop for a specific craft and added to the tools and machines that belong to the craft, and the museum contains the halls of each group, such as weapons of swords, guns, daggers and spears in the hall alone, as well as coffee tools in a dedicated place and utensils Cooking in place and do Agriculture, clothing, and ornaments.",
                Place.NO_PHONE,
                "All week: 10 AM - 12 PM, 4 PM - 8 PM.",
                "21.242962,40.447022"));
        places.add(new Place(R.drawable.okaz,
                "Okaz Market",
                "Historical museum and market.",
                "The most popular Arab gatherings to perform Hajj before Islam, a forum for thought, literature, and poetry, where there are performances of folk art in the market center, and the visitor can arrive there by his own car or accompanied by a tourist group.",
                "+966550068777",
                "27 June - 13 July: 10 Am - 12 PM.",
                "21.467267,40.645324"));
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