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
                "Albaik",
                "Albaik's vision: Putting MMMMMs and WOOOWs on our customers’ lips, every time, everywhere, the world over.",
                "Al Baik is a major fast food restaurant chain in Saudi Arabia that primarily sells broasted chicken and shrimp with a variety of sauces. It is one of the major consumers of chicken in Saudi Arabia.\n\nCuisine:  Fast Food, Halal.\nMeals:  Lunch, Dinner.\nRestaurant features:  Takeout, Seating.\nGood for:  Kids, Families with children.",
                "+966122866777",
                "Friday: 1 PM - 12 AM.\nOther days: 10 AM - 12 AM.",
                "21.510695,40.487277"));
        places.add(new Place(R.drawable.hirrman1,
                "Hirrman Restaurant",
                "Best restaurant serves Saleeq Saudi traditional meal in Taif.",
                "Cuisine:  Traditional, Deserts.\nMeals:  Lunch, Dinner.\nRestaurant features:  Takeout, Seating.\nGood for:  Families with children.",
                "+966127377272",
                "All week: 10 AM - 2 AM.",
                "21.268522,40.400665"));
        places.add(new Place(R.drawable.mabshoor,
                "Mabshoor Al Taif",
                "Best restaurant in the Taif city if you are a meat lover.",
                "Cuisine:  Traditional, Grills, Deserts.\nMeals:  Lunch, Dinner.\nRestaurant features:  Takeout, Seating.\nGood for:  Large groups, Families with children.",
                "+966555722459",
                "All week: 1 PM - 3 PM, 6 PM - 12 AM.",
                "21.287296,40.423130"));
        places.add(new Place(R.drawable.mirage,
                "Mirage",
                "From food quality and cost perspective, it is the best Indian restaurant in Taif.",
                "Cuisine:  Indian, Asian, Vegetarian-Friendly, Vegan Options.\nMeals:  Dinner, Brunch, Lunch.\nRestaurant features:  Takeout, Seating, Waitstaff.\nGood for:  Large groups, Families with children.",
                "+966127484444",
                "Sunday: 1 PM - 12 AM.\nOther days: 1 PM - 1 AM.",
                "21.233262,40.410999"));
        places.add(new Place(R.drawable.vitamin,
                "Vitamin Palace",
                "Specialize in wide varieties of delicious fresh Juices and fast food.",
                "Cuisine:  Middle Eastern, Deserts, Fast Food.\nMeals:  Lunch, Dinner.\nRestaurant features:  Takeout, Seating, Waitstaff, Street Parking, Accepts Credit Cards.",
                "+966127323073",
                "All week: 1 PM - 2 AM.",
                "21.278449,40.413856"));
        places.add(new Place(R.drawable.china,
                "China Restaurant",
                "Serves authentic Chinese food from the famous Sichuan cuisine by Chinese chefs.",
                "Cuisine:  Chinese, Vegetarian-Friendly.\nMeals: Lunch, Dinner.\nRestaurant features: Takeout, Seating.\nGood for:  Large groups, Families with children.",
                "+966127490372",
                "Friday: 1 PM - 12 AM.\nOther days: 12 PM - 12 AM.",
                "21.264606,40.411007"));
        places.add(new Place(R.drawable.gusto,
                "Gusto",
                "Nice Italian food at affordable prices in a quiet ambiance.",
                "Cuisine:  Italian.\nMeals:  Lunch, Dinner.\nRestaurant features:  Takeout, Seating.\nGood for:  Large groups, Kids, Families with children.",
                "+966127444442",
                "All week: 1 PM - 1 AM.",
                "21.253650,40.410872"));
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