package com.example.android.tourguideappproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<TourGuideData> places = new ArrayList<>();
        places.add(new TourGuideData(getString(R.string.Rest_Columbia),
                getString(R.string.Columbia_description),
                getString(R.string.Columbia_details),
                R.drawable.rest_columbia));

        places.add(new TourGuideData(getString(R.string.Rest_centro_espanol),
                getString(R.string.centrol_espanol_description),
                getString(R.string.centrol_espanol_details),
                R.drawable.rest_centroespanol));

        places.add(new TourGuideData(getString(R.string.rest_tequilas),
                getString(R.string.Tequilas_description),
                getString(R.string.Tequilas_details),
                R.drawable.rest_roosters_bar));

        TourGuideDataAdapter adapter = new TourGuideDataAdapter(getActivity(), places);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Class myActivityToIntent = TourGuideDataViewer.class;

                Intent myIntent = new Intent(getActivity().getApplicationContext(), myActivityToIntent);

                myIntent.putExtra("myTitle", places.get(i).getName());
                myIntent.putExtra("myDescription", places.get(i).getDescription());
                myIntent.putExtra("myDetails", places.get(i).getDetails());
                myIntent.putExtra("myPicture", places.get(i).getImage());

                startActivity(myIntent);

            }
        });

        return rootView;
    }

}