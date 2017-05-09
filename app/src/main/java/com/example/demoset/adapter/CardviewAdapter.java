package com.example.demoset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoset.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CardviewAdapter extends BaseAdapter {

    private ArrayList<Bean> objects = new ArrayList<Bean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public CardviewAdapter(Context context,ArrayList<Bean> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
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
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_cardview, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Bean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Bean object, ViewHolder holder) {
        //TODO implement
        holder.listItemCardviewTv.setText(object.getName());
    }

    static class ViewHolder {
        @Bind(R.id.list_item_cardview_tv) TextView listItemCardviewTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

   public static class Bean{
       private String name = "";

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }
   }
}
