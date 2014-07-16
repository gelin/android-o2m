package ru.gelin.android.example.ponylist;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private static final String PREFS_PONY_INDEX = "ponyIndex";
    private static final int DEFAULT_PONY_INDEX = 0;
    private int ponyIndex = DEFAULT_PONY_INDEX;

    public static DetailsFragment newInstance(int ponyIndex) {
        DetailsFragment fragment;
        fragment = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt(PREFS_PONY_INDEX, ponyIndex);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.ponyIndex = getArguments().getInt(PREFS_PONY_INDEX);
        }
//        setHasOptionsMenu(true);
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
        name.setText(names[this.ponyIndex]);
        TypedArray photos = getResources().obtainTypedArray(R.array.pony_photos_big);
        ImageView photo = (ImageView)view.findViewById(R.id.photo);
        photo.setImageDrawable(photos.getDrawable(this.ponyIndex));
    }

}
