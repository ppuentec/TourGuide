package com.example.android.tourguideappproject;

/**
 * {@link TourGuideData} present tourist information to user about a city.
 * It contains names of the places, a description and images for a city.
 */

public class TourGuideData {

    /** Name of the place of interest in the city */
    private String placeName;

    /** Description of the place of interest in the city */
    private String placeDescription;

    /** Description of the place of interest in the city */
    private String placeDetails;

    /** Image that describe the place of interest in the city */
    private int imageResourceId = -1;

    //constructor with three elements
    public TourGuideData (String firstInput, String secondInput, String thirdInput) {
        placeName = firstInput;
        placeDescription = secondInput;
        placeDetails = thirdInput;
    }

    //constructor with four elements (including picture)
    public TourGuideData(String firstInput, String secondInput, String thirdInput, int picture) {
        placeName = firstInput;
        placeDescription = secondInput;
        placeDetails = thirdInput;
        imageResourceId = picture;
    }

    /**
     * Create a new tourist place of interest.
     *
     * @param name of the place of interest located in the city
     *
     * @param description of the place of interest
     *
     * @param details of the place of interest
     *
     * @param image of the place of interest that help with the description
     */

    //Sets place for the name of the place of interest
    public void setPlaceTitle(String firstInput) {placeName = firstInput;}

    //Sets place for the description of the place of interest
    public void setPlaceWord(String secondInput) {placeDescription = secondInput;}

    //Sets place for the details of the place of interest
    public void setDesc(String thirdInput) {placeDetails = thirdInput;}

    //Sets place for the image of the place of interest
    public void setItemImage(int picture) {imageResourceId = picture;}

     /** Get the name of the place of interest */
    public String getName() { return placeName;}

    /** Get the description of the place of interest */
    public String getDescription() { return placeDescription;}

    /** Get details about the place of interest */
    public String getDetails() { return placeDetails;}

    /** Get the image of the place of interest */
    public int getImage() { return imageResourceId;}

    /** Returns whether or not there is an image for this word */
    public boolean hasImage(){ return imageResourceId != -1; }

    }

