package io.feuer.nudelocker.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import io.feuer.jlib.ui.JNavigationDrawerActivity;
import io.feuer.jlib.util.log.JLog;
import io.feuer.nudelocker.R;
import io.feuer.nudelocker.ui.fragments.BrowserFragment;

import static io.feuer.nudelocker.dal.AppConstants.TAG_FIRST_START;

/**
 * Haupt Activity
 * Created by jannik@feuer.io on 19.07.2017.
 */
public class MainActivity extends JNavigationDrawerActivity {


    @Override
    public void onJCreate(@Nullable Bundle savedInstanceState) {
        super.onJCreate(savedInstanceState);

        //Handle Ersten Start
        final SharedPreferences preferences = this.getPreferences(MODE_PRIVATE);
        if(preferences.getBoolean(TAG_FIRST_START, true)) {
            preferences.edit().putBoolean(TAG_FIRST_START, true).apply();

            //TODO: Handle Ersten Start
        }

        setFragment(new BrowserFragment());

    }

    @Override
    protected int getNavigationDrawerMenu() {
        return R.menu.menu_nav_drawer;
    }

    @Override
    protected int getNavigationDrawerHeaderView() {
        return R.layout.lay_nav_header;
    }

    @Override
    protected boolean onJNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (item.getItemId()) {
            default:
                fragmentClass = BrowserFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            JLog.e(this, e);
        }

        setFragment(fragment);
        return true;
    }

}
