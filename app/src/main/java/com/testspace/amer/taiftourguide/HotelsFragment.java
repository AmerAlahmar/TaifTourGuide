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
                "Intercontinental",
                "Elegant hotel with views over mountains Taif.",
                "This Taif hotel is situated at an elevation of 5,577 feet in the Hejaz Mountains, the Kingdom’s most desirable resort area. Enjoy cooler temperatures, abundant sunshine, and picturesque surroundings while taking advantage of the hotel’s heated indoor pool, tennis courts, and Hawazen restaurant. Relax in one of the 179 elegantly appointed guest rooms or explore Al Hada Mountain, Shubra Palace, and King Fahd Park. If shopping is your aim, browse local souks for spices, perfumes, and handicrafts.",
                "+966127505050",
                Place.NO_WH,
                "21.371019,40.461999"));
        places.add(new Place(R.drawable.meridien,
                "Le Meridien Al Hada",
                "The celebrity treatment with world-class service.",
                "Situated on the highest peak of Taif’s mountain range, this hotel features a marble lobby and spacious guest accommodations. There is an indoor and outdoor swimming pool, as well as a gym and sauna.\nA buffet breakfast is served daily in the dining room with its sparkling chandeliers, paintings, and thick curtains. It takes a 15-minute drive to reach a variety of restaurants in the center.\nThe 24-hour reception staff can arrange car rentals. Taif Regional Airport is a 30-minute drive away, while Mekkah can be reached within 45 minutes.",
                "+966127541400",
                Place.NO_WH,
                "21.286632,40.392220"));
        places.add(new Place(R.drawable.boudl,
                "Boudl Taif",
                "Located in the City of Ta’if, well known for its agriculture.",
                "Boudl Taif hotel offers air-conditioned rooms with free Wi-Fi. It has a 24-hour front desk and an elevator. Free public parking is available on site. The rooms feature a modern décor and are fitted with carpeted floors. Each includes a seating area with sofa, a flat-screen TV, and a minibar. Some rooms include a kitchenette and a dining area.\n\nTaif Regional Airport is just a 30-minute drive from Boudl Taif. Shubra Palace is 15 minutes drive away. Guests can also visit the famous Rudaf Park which is within a walking distance from the hotel.",
                "+966920000666",
                Place.NO_WH,
                "21.233985,40.411211"));
        places.add(new Place(R.drawable.awaliv,
                "Awaliv Suites",
                "A good place to stay in Taif, close to city center with parking availability.",
                "Guests can enjoy free Wi-Fi access in the entire hotel. Ironing and luggage storage can be arranged by the 24-hour front desk. The air-conditioned rooms and suites at Awaliv have a satellite TV, a desk and a wardrobe. Each suite includes a living room with sofa, while the kitchenette offers kitchenware, a fridge, and an electric kettle.\n\nNearby restaurants and coffee shops are within walking distance from Awaliv Suites. Taif Heart Mall is 4 minutes by car. Taif Regional Airport is a 25-minute drive away. Free private parking is possible on site. ",
                "+966127319999",
                Place.NO_WH,
                "21.295604,40.429166"));
        places.add(new Place(R.drawable.tulip,
                "Tulip Inn Taif",
                "luxury amenities including massage treatments and a fully equipped fitness center.",
                "Situated in the Taif business district, this hotel features luxury amenities including massage treatments and a fully equipped fitness center. Each guestroom is equipped with satellite TV and free Wi-Fi.\nAir-conditioned rooms at the Tulip Inn Altaif are spacious and have modern furnishings. They include a tea and coffee making facilities and have a private bathroom with a hairdryer.\n\nAl Dana restaurant serves Middle Eastern and international cuisine as well as a buffet breakfast. Drinks from the bar can be enjoyed on the terrace.\n\nTulip Inn is situated on the slopes of the Sarawat Mountains and is a 25-minute drive from Taif Airport. It offers 24-hour front desk service and free on-site private parking.",
                "+966127335533",
                Place.NO_WH,
                "21.276267,40.413683"));
        places.add(new Place(R.drawable.ramada,
                "Ramada AL Hada Hotel and Suites",
                "Al Hada Hotel offers modern accommodation close to business establishments and theme parks.",
                "Located next to the cable car, Al Hada Hotel offers modern accommodation close to business establishments and theme parks. It features room services and a 24-hour reception desk. Rooms of the Ramada Al Hada Hotel And Suites are equipped with air conditioning and flat-screen satellite TVs. They all include bathrooms with bathtub and slippers.\n\nGuests can enjoy a selection of Middle Eastern and international cuisine, served at the restaurant of the hotel. The dishes are prepared according to the season and the freshness of the ingredients.\n\nNearby attractions include Al Rudaf Natural Park and Prophet Mohammed’s Wadi Mitna Sanctuary. Taif Regional Airport is a 30-minute drive away. ",
                "+966127545558",
                Place.NO_WH,
                "21.364348,40.267815"));
        places.add(new Place(R.drawable.al_ward,
                "Al Ward Heritage Village",
                "provides guests with a water park. The accommodation offers a business center and room service for guests.",
                "Al Ward Heritage Village features air-conditioned accommodation in Taif. Featuring a 24-hour front desk, this property also provides guests with a water park. The accommodation offers a business center and room service for guests.\nSome rooms include a kitchenette with a microwave.\n\nThe resort offers a barbecue. Hiking is among the activities that guests can enjoy near Al Ward Heritage Village. Jouri Mall is 19 km from the accommodation. Ta'if Regional Airport is 44 km from the property. ",
                "+966555080489",
                Place.NO_WH,
                "21.120926,40.371633"));
        places.add(new Place(R.drawable.ofoq,
                "Ofoq Al Raha Hotel Apartment",
                "Offers an indoor pool, a restaurant, and self-catering accommodations.",
                "Offering an indoor pool and a restaurant, Ofoq Al Raha Hotel Apartment offers self-catering accommodations. Free WiFi access is available in all areas. The property is a 10-minute drive away from Green Mountain Park.\nApartments at Ofoq Al Raha Hotel Apartment feature a flat-screen TV, air conditioning, and a hot tub. There is a full kitchen with a microwave and an oven.",
                Place.NO_PHONE,
                Place.NO_WH,
                "21.326061,40.434639"));
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