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
public class DetailsActivity extends Activity {

    public static final String EXTRA_ITEM_INDEX = "itemIndex";
    static final int DEFAULT_ITEM_INDEX = 0;

    DetailsFragment fragment;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        int index = getIntent().getIntExtra(EXTRA_ITEM_INDEX, DEFAULT_ITEM_INDEX);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, getFragment(index))
                .commit();
    }

    Fragment getFragment(int index) {
        if (this.fragment == null) {
            this.fragment = DetailsFragment.newInstance(index);    //TODO get param
        }
        return this.fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}