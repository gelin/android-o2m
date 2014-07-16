package ru.gelin.android.example.ponylist;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
* Created by gelin on 7/14/14.
*/
class MainListAdapter extends BaseAdapter {

    private final Context context;

    MainListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.context.getResources().getStringArray(R.array.pony_names).length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createView(viewGroup);
        }
        bindView(view, i);
        return view;
    }

    View createView(ViewGroup viewGroup) {
        return LayoutInflater.from(this.context).inflate(R.layout.main_list_item, viewGroup, false);
    }

    void bindView(View view, int i) {
        String[] names = this.context.getResources().getStringArray(R.array.pony_names);
        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(names[i]);
        TypedArray photos = this.context.getResources().obtainTypedArray(R.array.pony_photos);
        ImageView photo = (ImageView)view.findViewById(R.id.photo);
        photo.setImageDrawable(photos.getDrawable(i));
    }

}
