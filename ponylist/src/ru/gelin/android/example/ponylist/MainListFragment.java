package ru.gelin.android.example.ponylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.*;
import android.widget.*;

public class MainListFragment extends ListFragment {

    static final String SELECTED_ITEM_KEY = "selectedItem";
    static final int SELECTED_ITEM_DEFAULT = 0;
    int selectedItem = -1;

    public static MainListFragment newInstance() {
        return new MainListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new MainListAdapter(getActivity()));
        ListView listView = getListView();
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        if (getResources().getBoolean(R.bool.dual_pane)) {
            if (savedInstanceState != null) {
                onListItemClick(getListView(), savedInstanceState.getInt(SELECTED_ITEM_KEY, SELECTED_ITEM_DEFAULT));
            } else {
                onListItemClick(getListView(), SELECTED_ITEM_DEFAULT);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_KEY, this.selectedItem);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        onListItemClick(listView, position);
    }

    void onListItemClick(ListView listView, int position) {
        if (getResources().getBoolean(R.bool.dual_pane)) {
            if (this.selectedItem == position) {
                return;
            }
            listView.setItemChecked(position, true);
            showFragment(position);
        } else {
            startActivity(position);
        }
        this.selectedItem = position;
    }

    void showFragment(int index) {
        Fragment fragment = DetailsFragment.newInstance(index);
        getFragmentManager().beginTransaction()
                .replace(R.id.details, fragment)
                .commit();
    }

    void startActivity(int index) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_ITEM_INDEX, index);
        startActivity(intent);
    }

}
