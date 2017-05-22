package com.example.demoset.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoset.R;
import com.example.demoset.bean.Bean;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListItemMultiAdapter extends BaseAdapter {

    private ArrayList<Bean> objects = new ArrayList<Bean>();

    private Context context;
    private LayoutInflater layoutInflater;

    final int TYPE_NUM = 2;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;

    public ListItemMultiAdapter(Context context, ArrayList<Bean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Bean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolderOne holder1 = null;
        ViewHolderTwo holder2 = null;

        //甚是繁琐
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = layoutInflater.inflate(R.layout.list_item_multi_xml_one, null);
                    holder1 = new ViewHolderOne(convertView);
                    convertView.setTag(holder1);
                    break;
                case TYPE_2:
                    convertView = layoutInflater.inflate(R.layout.list_item_multi_xml_two, null);
                    holder2  = new ViewHolderTwo(convertView);
                    convertView.setTag(holder2);
                    break;
            }

        } else {
            switch (type) {
                case TYPE_1:
                    holder1 = (ViewHolderOne) convertView.getTag();
                    break;
                case TYPE_2:
                    holder2 = (ViewHolderTwo) convertView.getTag();
                    break;
            }
        }

        switch (type) {
            case TYPE_1:
//                holder1.iv
                break;
            case TYPE_2:
                holder2.tv.setText("吉马坡");
                break;
        }

        return convertView;
    }


    static class ViewHolderOne {
        @Bind(R.id.list_item_multi_xml_one_iv)
        ImageView iv;

        ViewHolderOne(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderTwo {
        @Bind(R.id.list_item_multi_xml_two_tv)
        TextView tv;

        ViewHolderTwo(View view) {
            ButterKnife.bind(this, view);
        }
    }

//    多布局

    @Override
    public int getViewTypeCount() {
        return TYPE_NUM;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (objects.get(position).getType()) {
            case 0:
                type = TYPE_1;
                break;
            case 1:
                type = TYPE_2;
                break;
        }
        return type;
    }



}
