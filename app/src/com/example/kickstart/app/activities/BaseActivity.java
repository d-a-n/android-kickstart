package com.example.kickstart.app.activities;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.example.kickstart.AppHelper;
import com.example.kickstart.R;
import com.example.kickstart.app.slidemenu.SlideoutMenuFragment;
import com.example.kickstart.app.slidemenu.SlidingSherlockFragmentActivity;
import com.slidingmenu.lib.SlidingMenu;


public abstract class BaseActivity extends SlidingSherlockFragmentActivity implements ActionBar.OnNavigationListener {

	private static final String TAG = "BaseActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlideMenu();
        actionBarSetup();
    }

    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	protected void addSlideMenu() {
        setBehindContentView(R.layout.fragment_slideoutmenu);

        FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
        Fragment fragment = new SlideoutMenuFragment();
        t.replace(R.id.fragment_slideoutmenu, fragment);
        t.commit();
        
        Point screenSize = AppHelper.screenSize(getApplicationContext());
        SlidingMenu mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);
        mSlidingMenu.setBehindWidth((int) (screenSize.x*0.85));
        setSlidingActionBarEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    protected void actionBarSetup()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.ab_title); 
        actionBar.setSubtitle(R.string.ab_subtitle);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
        	actionBar.setHomeButtonEnabled(true);
        }
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	Log.d(TAG, "onOptionsItemSelected: " + item.getItemId());
        switch(item.getItemId()) {
        case android.R.id.home:
        	getSlidingMenu().toggle();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		return true;
	}

    public int getDpAsPxFromResource(int res) {
        return (int)getResources().getDimension(res);
    }
}
