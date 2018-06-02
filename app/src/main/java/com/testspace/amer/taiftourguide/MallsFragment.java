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

public class MallsFragment extends Fragment implements PlaceAdapter.OnItemPressedListener {
    View rootView;
    RecyclerView recyclerView;
    ArrayList<Place> places;
    PlaceAdapter placeAdapter;

    public MallsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        places = new ArrayList<>();
        placeAdapter = new PlaceAdapter();
        places.add(new Place(R.drawable.jouri,
                "Jouri Mall",
                "Jouri shopping mall is a 5-star mall that has brought Taif to a higher level.",
                "The Mall is clean, spacious and has a good temperature control. The toilets are well accommodated and very clean. The shops are selling products of high quality. Salesmen and women are courtesy and friendly to help the customer to find what they need.\n\nIt's worthy to visit the Turkish delight shop and taste the delicious goodies. All products are fresh. The food court is really great. International food, fresh and good. The seating area is well looking after. Always clean tables and floor.",
                "+966920000262",
                "Friday: 2 PM - 12 AM.\nOther days: 10 AM - 11 PM.",
                "21.276269,40.444967"));
        places.add(new Place(R.drawable.heart_mall,
                "Taif's Heart Mall",
                "Loads of shopping to do. There is a good variety of shops, catering for all.",
                "The variety of shops are very good. Enough choice and on the top floor an ice skate ring and a lovely fancy fair for the children. Around the children's entertainment area are food stalls from French crepes, fruit juices, hamburgers, Ice cream, Arabic coffee, Small Dutch Pancakes, Cinnamon buns and a lot more. On Gate 3 ground floor is a lovely coffee shop where you can sit on the terras or inside. ",
                "+966920003987",
                "Friday: 4 PM - 1 AM.\nOther days: 10 AM - 12 PM.",
                "21.286741,40.418700"));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Malls");
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