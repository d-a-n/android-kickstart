package com.example.kickstart.app.slidemenu;

import com.example.kickstart.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SlideoutMenuFragment extends Fragment {
    private static SlideoutMenuFragment instance;

    public static SlideoutMenuFragment getInstance() {
        if (instance == null) {
            return new SlideoutMenuFragment();
        }
        return instance;
    }

    public SlideoutMenuFragment() {
        instance = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.slidingmenu_layout, null);
    }
}
