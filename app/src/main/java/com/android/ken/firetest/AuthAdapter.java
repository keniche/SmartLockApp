package com.android.ken.firetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AuthAdapter extends ArrayAdapter<Auth> {

    List<Auth> authItems;

    public AuthAdapter(Context context, int layoutResourceId, List<Auth> objects) {
        super(context, layoutResourceId, objects);

        authItems = objects;
    }

    @Override
    public int getCount() {
        return authItems.size();
    }

    @Override
    public Auth getItem(int position) {
        return authItems.get(position);
    }

    public static class ViewHolder {
        TextView  userNameTextView;
        TextView expiredAtTextView;

        public ViewHolder(View view) {
            userNameTextView = (TextView) view.findViewById(R.id.userName);
            expiredAtTextView = (TextView) view.findViewById(R.id.expiredAt);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_auth, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Auth item = getItem(position);

        if (item != null) {

            //set data
            viewHolder.userNameTextView.setText(item.getUserName());
            viewHolder.expiredAtTextView.setText(item.getExpiredAt());
        }

        return convertView;
    }


}
