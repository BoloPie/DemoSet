package com.example.demoset.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoset.R;
import com.example.demoset.helper.ItemTouchHelperAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 张凌云 on 2017/4/27.
 */

public class AdanceItemTouchAdapter extends RecyclerView.Adapter<AdanceItemTouchAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<String> list;

    public AdanceItemTouchAdapter(ArrayList<String> list) {
        this.list = list;
    }
    NormalAdapter.OnItemClickListener onItemClickListener = null;

    @Override
    public AdanceItemTouchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_advance_item_touch, parent, false);
        AdanceItemTouchAdapter.ViewHolder viewHolder = new AdanceItemTouchAdapter.ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(view,(Object)view.getTag());
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleTV.setText(list.get(position));
        holder.delLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "删除"+position, Toast.LENGTH_SHORT).show();
                list.remove(position);
                notifyItemRemoved(position);
//                notifyDataSetChanged();
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

//        list.remove(position);
//        notifyItemRemoved(position);
    }
   public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTV;
        public LinearLayout delLay;

        public ViewHolder(View view) {
            super(view);
            titleTV = (TextView) view.findViewById(R.id.list_item_advance_item_touch_title_tv);
            delLay = (LinearLayout) view.findViewById(R.id.list_item_advance_item_touch_delete);
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, Object object);
    }

    public NormalAdapter.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(NormalAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
