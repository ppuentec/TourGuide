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
public class ToursFragment extends Fragment {

    public ToursFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<TourGuideData> places = new ArrayList<>();
        places.add(new TourGuideData(getString(R.string.Tour_Cigar),
                getString(R.string.Cigar_description),
                "",
                R.drawable.tour_cigars));

        places.add(new TourGuideData(getString(R.string.Tour_Segway),
                getString(R.string.Segway_description),
                "",
                R.drawable.tour_electric_glide));

        places.add(new TourGuideData(getString(R.string.Tour_Ghost),
                getString(R.string.Ghost_description),
                "",
                R.drawable.ghost_tours));

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
