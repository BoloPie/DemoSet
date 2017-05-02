package com.example.demoset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demoset.R;
import com.example.demoset.bean.ExpandableBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/4/10.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<ExpandableBean> list;
    private OnExpandableItemClickListener onExpandableItemClickListener = null;

    //    不同子布局
    private final int childTypeCount = 3;
    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;
    private final int TYPE_3 = 2;

    public ExpandableAdapter(Context context, ArrayList<ExpandableBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getChildList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildList().get(childPosition);
    }


    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getChildTypeCount() {
        return childTypeCount;
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
//        0 1 2
        int type = list.get(groupPosition).getChildList().get(childPosition).getType();
        return type;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_parent, null);
            view.setTag(new ParentHolder(view));
        }
        ParentHolder parentHolder = (ParentHolder) view.getTag();

        if (isExpanded) {
            parentHolder.imageView.setBackgroundResource(R.mipmap.ic_select_down);
        } else {
            parentHolder.imageView.setBackgroundResource(R.mipmap.ic_select_up);
        }
        parentHolder.pNameTV.setText(list.get(i).getParentName());

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        final ExpandableBean.Child child = list.get(i).getChildList().get(i1);
        int type = list.get(i).getChildList().get(i1).getType();
        switch (type) {
            case TYPE_1:
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_child, null);
                    view.setTag(new ChildHolder(view));
                }
                ChildHolder childHolder = (ChildHolder) view.getTag();

                childHolder.nameTV.setText(child.getChildName());
                childHolder.agreeTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onExpandableItemClickListener != null) {
                            onExpandableItemClickListener.onAgreeClick(i, i1, child);
                        }
                    }
                });
                childHolder.rejectTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onExpandableItemClickListener != null) {
                            onExpandableItemClickListener.onRejectClick(i, i1, child);
                        }
                    }
                });
                childHolder.rebackTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onExpandableItemClickListener != null) {
                            onExpandableItemClickListener.onReBackClick(i, i1, child);
                        }
                    }
                });
             String url = "http://192.168.0.98:8000/static/19/1490337217393.jpg";

                Glide.with(context).load(url).into(childHolder.headIV);
//                Glide
//                        .with(context)
//                        .load(url)
//                        .centerCrop()
////                        .placeholder(R.mipmap.ic_head_default)
//                        .crossFade()
//                        .into(childHolder.headIV);

                break;
            case TYPE_2:
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_child_two, null);
                    view.setTag(new ChildHolderTwo(view));
                }
                ChildHolderTwo childHolderTwo = (ChildHolderTwo) view.getTag();
                childHolderTwo.outEngTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onExpandableItemClickListener != null) {
                            onExpandableItemClickListener.onOutEngClick(i, i1, child);
                        }
                    }
                });


                break;
            case TYPE_3:
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_child_there, null);
                    view.setTag(new ChildHolderThere(view));
                }
                ChildHolderThere childHolderThere = (ChildHolderThere) view.getTag();
                childHolderThere.outCooTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onExpandableItemClickListener != null) {
                            onExpandableItemClickListener.onOutCooClick(i, i1, child);
                        }
                    }
                });

                break;

        }


        return view;
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param i
     * @param i1
     * @return
     */
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


    //    回调
    public OnExpandableItemClickListener getOnExpandableItemClickListener() {
        return onExpandableItemClickListener;
    }

    public void setOnExpandableItemClickListener(OnExpandableItemClickListener onExpandableItemClickListener) {
        this.onExpandableItemClickListener = onExpandableItemClickListener;
    }

    public static interface OnExpandableItemClickListener {
        void onReBackClick(int parentPosition, int childPosition, ExpandableBean.Child bean);

        void onAgreeClick(int parentPosition, int childPosition, ExpandableBean.Child bean);

        void onRejectClick(int parentPosition, int childPosition, ExpandableBean.Child bean);

        void onOutEngClick(int parentPosition, int childPosition, ExpandableBean.Child bean);

        void onOutCooClick(int parentPosition, int childPosition, ExpandableBean.Child bean);
    }


    class ParentHolder {
        @Bind(R.id.list_item_expandable_parent_name_tv)
        TextView pNameTV;
        @Bind(R.id.list_item_expandable_parent_num_tv)
        TextView pNumTV;
        @Bind(R.id.list_item_expandable_parent_iv)
        ImageView imageView;

        ParentHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    class ChildHolder {

        @Bind(R.id.list_item_expandable_child_head_iv)
        ImageView headIV;
        @Bind(R.id.list_item_expandable_child_name_tv)
        TextView nameTV;
        @Bind(R.id.list_item_expandable_child_tel_tv)
        TextView tellTV;
        @Bind(R.id.list_item_expandable_child_ok_tv)
        TextView agreeTV;
        @Bind(R.id.list_item_expandable_child_no_tv)
        TextView rejectTV;
        @Bind(R.id.list_item_expandable_child_reback_tv)
        TextView rebackTV;

        ChildHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class ChildHolderTwo {

        @Bind(R.id.list_item_expandable_child_two_head_iv)
        ImageView headIV;
        @Bind(R.id.list_item_expandable_child_two_name_tv)
        TextView nameTV;
        @Bind(R.id.list_item_expandable_child_two_tel_tv)
        TextView tellTV;
        @Bind(R.id.list_item_expandable_child_two_out_eng_tv)
        TextView outEngTV;


        ChildHolderTwo(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class ChildHolderThere {

        @Bind(R.id.list_item_expandable_child_there_head_iv)
        ImageView headIV;
        @Bind(R.id.list_item_expandable_child_there_name_tv)
        TextView nameTV;
        @Bind(R.id.list_item_expandable_child_there_tel_tv)
        TextView tellTV;
        @Bind(R.id.list_item_expandable_child_there_out_coo_tv)
        TextView outCooTV;


        ChildHolderThere(View view) {
            ButterKnife.bind(this, view);
        }
    }



}
