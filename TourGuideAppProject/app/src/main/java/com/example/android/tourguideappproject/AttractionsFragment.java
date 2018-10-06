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
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<TourGuideData> places = new ArrayList<>();
        places.add(new TourGuideData(getString(R.string.Attract_Streetcar),
                getString(R.string.Streetcar_description),
                "",
                R.drawable.attrac_tram));
        places.add(new TourGuideData(getString(R.string.Attract_chickens),
                getString(R.string.Chickens_description),
                "",
                R.drawable.attrac_chicken));
        places.add(new TourGuideData(getString(R.string.Attract_cigar_factory),
                getString(R.string.cigar_factory_description),
                "",
                R.drawable.attract_cigar_factory));

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