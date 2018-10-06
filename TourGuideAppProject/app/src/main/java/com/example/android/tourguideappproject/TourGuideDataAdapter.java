package com.example.android.tourguideappproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourGuideDataAdapter extends ArrayAdapter<TourGuideData>{

    private int viewBGColor;

    public TourGuideDataAdapter(Activity context, ArrayList<TourGuideData> places) {
        super(context, 0 , places);
        viewBGColor = R.color.white_background;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TourGuideData currentTourGuideData = getItem(position);

        TextView firstTextView = listItemView.findViewById(R.id.listItemName);
        firstTextView.setText(currentTourGuideData.getName());

        TextView secondTextView = listItemView.findViewById(R.id.listItemDescription);
        secondTextView.setText(currentTourGuideData.getDescription());

        TextView thirdTextView = listItemView.findViewById(R.id.listItemDetails);
        thirdTextView.setText(currentTourGuideData.getDescription());

        ImageView myImageView = listItemView.findViewById(R.id.myImage);
        if (currentTourGuideData.hasImage()) {
           myImageView.setImageResource(currentTourGuideData.getImage());
        } else {
            myImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.card_view);
        int color = ContextCompat.getColor(getContext(), viewBGColor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
