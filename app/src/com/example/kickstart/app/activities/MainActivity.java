package com.example.kickstart.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.example.kickstart.R;
import com.example.kickstart.app.fragments.MainListFragment;

public class MainActivity extends BaseActivity implements MainListFragment.OnFragmentUpdateListener {

    FragmentManager fm;
    private static final String TAG = "MainActivity";

    @Override
    public void onFragmentUpdate(int position, boolean forceupdate) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            Intent i = getIntent();
        }

        fm = getSupportFragmentManager();

        MainListFragment fragment = (MainListFragment)fm.findFragmentByTag("main_fragment");
        if (savedInstanceState == null || fragment == null) {
            fragment = MainListFragment.newInstance();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(android.R.id.content, fragment, "main_fragment");
            ft.commit();
        }
        actionBarSetup();
    }
}
