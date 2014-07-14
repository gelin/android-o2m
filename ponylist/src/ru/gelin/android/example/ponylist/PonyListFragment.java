package ru.gelin.android.example.ponylist;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class PonyListFragment extends ListFragment {

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
