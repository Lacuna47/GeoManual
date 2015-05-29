package com.example.lacuna.geomanual;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Lacuna on 29.05.2015.
 */
public class GeoFragmentAdapter extends FragmentPagerAdapter {

    public static final int VIEW_COUNT = 4;
    public static final String LOG_TAG = GeoFragmentAdapter.class.getSimpleName();

    private Context mContext;

    public GeoFragmentAdapter(FragmentManager fm, Context context){
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return GeoFragment.newInstance(i);
    }
}
