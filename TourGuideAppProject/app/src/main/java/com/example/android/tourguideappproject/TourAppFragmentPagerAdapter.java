package com.example.android.tourguideappproject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class TourAppFragmentPagerAdapter extends FragmentPagerAdapter {

    /**Variable (nMoOfTabs) that will store the numbers of tabs*/
    static final int mNoOfTabs = 4;

    private Context mContext;

    public TourAppFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AboutYborCityFragment();
            case 1:
                return new AttractionsFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new ToursFragment();
            default:
                return new AttractionsFragment();
        }
    }

    @Override
    public int getCount() { return mNoOfTabs; }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.name_tab_1);
            case 1:
                return mContext.getString(R.string.name_tab_2);
            case 2:
                return mContext.getString(R.string.name_tab_3);
            case 3:
                return mContext.getString(R.string.name_tab_4);
            default:
                return mContext.getString(R.string.name_tab_5);
        }
    }
}
