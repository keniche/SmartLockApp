package com.android.ken.firetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TimestampAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<Timestamp> timestampList;

    public TimestampAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setTimestampList(ArrayList<Timestamp> timestampList) {
        this.timestampList = timestampList;
    }

    @Override
    public int getCount() {
        return timestampList.size();
    }

    @Override
    public Object getItem(int position) {
        return timestampList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return timestampList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.listview_timestamp,parent,false);

        ((TextView)convertView.findViewById(R.id.datetime)).setText(timestampList.get(position).getDatetime());
        ((TextView)convertView.findViewById(R.id.userName)).setText(timestampList.get(position).getUserName());
        ((TextView)convertView.findViewById(R.id.isLocked)).setText(timestampList.get(position).getLocked()+"");

        return convertView;
    }





}


