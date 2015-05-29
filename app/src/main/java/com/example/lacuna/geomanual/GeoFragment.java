package com.example.lacuna.geomanual;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.widget.AdapterView;


/**
 * Created by Lacuna on 29.05.2015.
 */
public class GeoFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static final String LOG_TAG = GeoFragment.class.getSimpleName();

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static GeoFragment newInstance(int sectionNumber) {
        GeoFragment fragment = new GeoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public GeoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }




    @Override
    public void onResume() {
        super.onResume();
    }

}
