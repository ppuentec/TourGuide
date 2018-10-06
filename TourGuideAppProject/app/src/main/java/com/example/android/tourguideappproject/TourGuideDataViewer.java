package com.example.android.tourguideappproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class TourGuideDataViewer extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_place_info);

        String newString;
        String newStringForDescription;
        String newStringForDetails;
        int newImage = 0;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
                newStringForDescription = null;
                newStringForDetails = null;
            } else {
                newString = extras.getString("myName");
                newStringForDescription = extras.getString("myDescription");
                newStringForDetails = extras.getString("myDetails");
                newImage = extras.getInt("myPicture");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("STRING_I_NEED");
            newStringForDescription = (String) savedInstanceState.getSerializable("STRING_I_NEED");
            newStringForDetails = (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        ArrayList<TourGuideData> places = new ArrayList<>();
        places.add(new TourGuideData(newString, newStringForDescription,
                newStringForDetails, newImage));
        TourGuideDataViewerAdapter itemsAdapter = new TourGuideDataViewerAdapter(this, places);
        ListView myListView = findViewById(R.id.place_info);
        myListView.setAdapter(itemsAdapter);
    }
}
