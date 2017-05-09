package com.example.demoset.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Button;

import com.example.demoset.R;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeDelMenuAdapter extends BaseAdapter {

    private ArrayList<String> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeDelMenuAdapter(Context context,ArrayList<String> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public String getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_swipe_del_menu, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((String) getItem(position), (ViewHolder) convertView.getTag(),position);
        return convertView;
    }

    private void initializeViews(String object, final ViewHolder holder, final int position) {
        //TODO implement
        holder.content.setText(object);
        //这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑  禁用掉侧滑菜单
//        ((SwipeMenuLayout) holder.itemView).setIos(false).setLeftSwipe(position % 2 == 0 ? true : false).setSwipeEnable(false);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objects.remove(position);
                notifyDataSetChanged();
                holder.itemView.quickClose();
            }
        });
    }

    static class ViewHolder {
        @Bind(R.id.list_item_swipe_del_menu_itemview)
        SwipeMenuLayout itemView;
        @Bind(R.id.content)
        TextView content;
        @Bind(R.id.btnTop)
        Button btnTop;
        @Bind(R.id.btnUnRead)
        Button btnUnRead;
        @Bind(R.id.btnDelete)
        Button btnDelete;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
