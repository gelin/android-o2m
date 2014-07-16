package ru.gelin.android.example.ponylist;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 *  Activity to setup domains where to remove query.
 */
public class DetailsActivity extends ActionBarActivity {

    DetailsFragment fragment;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, getFragment())
                .commit();
    }

    Fragment getFragment() {
        if (this.fragment == null) {
            this.fragment = DetailsFragment.newInstance(1);    //TODO get param
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