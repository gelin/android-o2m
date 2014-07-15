package ru.gelin.android.example.ponylist;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

/**
 *  Activity to setup domains where to remove query.
 */
public class PonyActivity extends Activity {

    PonyFragment fragment;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, getFragment())
                .commit();
    }

    Fragment getFragment() {
        if (this.fragment == null) {
            this.fragment = PonyFragment.newInstance(0);    //TODO get param
        }
        return this.fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);    //TODO
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}