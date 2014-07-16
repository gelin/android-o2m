package ru.gelin.android.example.ponylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.*;
import android.widget.*;

public class MainListFragment extends ListFragment implements AdapterView.OnItemClickListener {

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
        ListView list = getListView();
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        onListItemClick((ListView)adapterView, position);
    }

    void onListItemClick(ListView listView, int position) {
        if (getResources().getBoolean(R.bool.dual_pane)) {
//            if (this.selectedItem == position) {
//                return;
//            }
            listView.setItemChecked(position, true);
            showFragment(position);
        } else {
            startActivity(position);
        }
//        this.selectedItem = position;
    }

    void showFragment(int index) {
        //TODO
//        getFragmentManager().beginTransaction()
//                .replace(R.id.details, fragment)
//                .commit();
    }

    void startActivity(int index) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        //TODO pass index
        startActivity(intent);
    }

}
