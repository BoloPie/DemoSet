package com.example.demoset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoset.PopListBean;
import com.example.demoset.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/3/16.
 */

public class PopListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    ArrayList<PopListBean> list;
    Context context;

    public PopListAdapter( Context context,ArrayList<PopListBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.from(context).inflate(R.layout.list_item_pop, null);

            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.list_item_pop_title_tv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTV.setText(list.get(position).getName());

        return convertView;
    }

    static class ViewHolder {
        public TextView titleTV;
    }
}
