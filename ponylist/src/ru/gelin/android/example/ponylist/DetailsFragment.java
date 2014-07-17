package ru.gelin.android.example.ponylist;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsFragment extends Fragment {

    private static final String ARG_ITEM_INDEX = "itemIndex";
    private static final int DEFAULT_ITEM_INDEX = 0;
    private int itemIndex = DEFAULT_ITEM_INDEX;

    public static DetailsFragment newInstance(int ponyIndex) {
        DetailsFragment fragment;
        fragment = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_INDEX, ponyIndex);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.itemIndex = getArguments().getInt(ARG_ITEM_INDEX);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.details, container, false);
        bindView(layout);
        return layout;
    }

    void bindView(View view) {
        String[] names = getResources().getStringArray(R.array.pony_names);
        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(names[this.itemIndex]);
        TypedArray photos = getResources().obtainTypedArray(R.array.pony_photos_big);
        ImageView photo = (ImageView)view.findViewById(R.id.photo);
        photo.setImageDrawable(photos.getDrawable(this.itemIndex));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), getResources().getStringArray(R.array.pony_names)[this.itemIndex] +
                " is " + item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

}
