package com.example.kickstart.app.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.kickstart.R;
import com.example.kickstart.app.lists.MainListAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainListFragment extends Fragment {
    OnFragmentUpdateListener mCallback;
    private Context context;

    public interface OnFragmentUpdateListener {
        public void onFragmentUpdate(int position, boolean forceupdate);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnFragmentUpdateListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
            + " must implement OnFragmentUpdateListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container != null) {
            container.removeAllViews();
        }

        context = getActivity().getApplicationContext();

        View view = inflater.inflate(R.layout.viewpager_main, container, false);
        createPagerView(view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void createPagerView(View view) {
        ViewPager awesomePager = (ViewPager) view.findViewById(R.id.pager);
        awesomePager.setAdapter(new ExamplePagerAdapter());

        TabPageIndicator titleIndicator = (TabPageIndicator)view.findViewById(R.id.titles);
        titleIndicator.setViewPager(awesomePager);
    }

    public static MainListFragment newInstance() {
        MainListFragment f = new MainListFragment();

        Bundle args = new Bundle();
        f.setArguments(args);

        return f;
    }

    private class ExamplePagerAdapter extends PagerAdapter {
        String[] pages = {"First page", "Second page", "Third page"};
        int[] pages_strings = { R.array.main_list, R.array.main_list, R.array.main_list };
        String pageContent;
        private ExamplePagerAdapter() {
        }

        @Override
        public int getCount() {
            return pages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == (ListView)o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object view) {
            ((ViewPager) container).removeView((View) view);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // create a new listview
            ListView listView = new ListView(context);
            ListAdapter adapter = new MainListAdapter(pages_strings[position], context);

            // bind the adapter to the lists view
            listView.setAdapter(adapter);

            ((ViewPager) container).addView(listView,0);

            return listView;
        }

        public String getPageTitle(int position) {
            return pages[position];
        }
    }
}
