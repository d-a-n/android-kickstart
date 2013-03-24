package com.example.kickstart.app.lists;

import com.example.kickstart.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainListAdapter extends BaseAdapter {
    private Context context;
    String[] values = {};

    public MainListAdapter(int inflated_array, Context context) {
        this.context = context;
        values = context.getResources().getStringArray(inflated_array);
    }

    public int getCount() {
        return values.length;
    }

    public Object getItem(int position) {
        return values[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout listView;
        listView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.listitem_main, parent, false);

        TextView itemText = (TextView)listView.findViewById(R.id.list_item_text);
        itemText.setText(values[position]);

        return listView;
    }
}
