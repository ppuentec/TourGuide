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
public class AboutYborCityFragment extends Fragment {

    public AboutYborCityFragment() {
            // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<TourGuideData> places = new ArrayList<>();
        places.add(new TourGuideData(getString(R.string.About_Ybor),
                getString(R.string.About_Ybor_description), "",
                R.drawable.yborcitytampafl));

        TourGuideDataAdapter adapter = new TourGuideDataAdapter(getActivity(), places);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Class myActivityToIntent = TourGuideDataViewer.class;

                Intent myIntent = new Intent(getActivity().getApplicationContext(), myActivityToIntent);

                myIntent.putExtra("myName", places.get(i).getName());
                myIntent.putExtra("myDescription", places.get(i).getDescription());
                myIntent.putExtra("myDetails", places.get(i).getDetails());
                myIntent.putExtra("myPicture", places.get(i).getImage());

                startActivity(myIntent);

            }
        });

        return rootView;
    }

}
