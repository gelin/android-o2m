package ru.gelin.android.example.ponylist;

import android.annotation.TargetApi;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PonyListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    public static PonyListFragment newInstance() {
        return new PonyListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new PonyListAdapter(getActivity()));
        ListView list = getListView();
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new PonyMultiChoiceModeListener());
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
            showPonyFragment(position);
        } else {
            startPonyIntent(position);
        }
//        this.selectedItem = position;
    }

    void showPonyFragment(int index) {
        //TODO
//        getFragmentManager().beginTransaction()
//                .replace(R.id.details, fragment)
//                .commit();
    }

    void startPonyIntent(int index) {
        Intent intent = new Intent(getActivity(), PonyActivity.class);
        //TODO pass index
        startActivity(intent);
    }

    private class PonyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

        String name;

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if (checked) {
                name = getResources().getStringArray(R.array.pony_names)[position];
            }
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.contextmenu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(getActivity(), name + " is " + item.getTitle(), Toast.LENGTH_LONG).show();
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }

    }

}
