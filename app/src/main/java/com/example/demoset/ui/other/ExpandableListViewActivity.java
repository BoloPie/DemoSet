package com.example.demoset.ui.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.demoset.R;
import com.example.demoset.adapter.ExpandableAdapter;
import com.example.demoset.bean.ExpandableBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ExpandableListViewActivity extends AppCompatActivity {

    @Bind(R.id.activity_expandable_list_view_elv)
    ExpandableListView expandableListView;

    private ArrayList<ExpandableBean> list;
    private ExpandableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new ExpandableAdapter(this,list);
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);

        adapter.setOnExpandableItemClickListener(new ExpandableAdapter.OnExpandableItemClickListener() {
            @Override
            public void onReBackClick(int parentPosition, int childPosition, ExpandableBean.Child bean) {
                Toast.makeText(ExpandableListViewActivity.this, "撤回", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAgreeClick(int parentPosition, int childPosition, ExpandableBean.Child bean) {
                Toast.makeText(ExpandableListViewActivity.this, "I am agree", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRejectClick(int parentPosition, int childPosition, ExpandableBean.Child bean) {
                Toast.makeText(ExpandableListViewActivity.this, "拒绝", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOutEngClick(int parentPosition, int childPosition, ExpandableBean.Child bean) {
                Toast.makeText(ExpandableListViewActivity.this, "移出运维", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOutCooClick(int parentPosition, int childPosition, ExpandableBean.Child bean) {
                Toast.makeText(ExpandableListViewActivity.this, "移出业务", Toast.LENGTH_SHORT).show();
            }
        });


//        制造数据
        for (int i = 0; i < 4; i++) {

            ExpandableBean bean = new ExpandableBean();
            bean.setParentId(i);
            bean.setParentName("夜华"+i);
            ArrayList<ExpandableBean.Child> childList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                ExpandableBean.Child child = new ExpandableBean.Child();
                child.setChildId(j);
                child.setChildName("糯米团子"+j);
                switch (i){
                    case 0:
                        child.setType(0);
                        break;
                    case 1:
                        child.setType(1);
                        break;
                    case 2:
                        child.setType(2);
                        break;
                }
                childList.add(child);
            }
            bean.setChildList(childList);
            list.add(bean);
        }

        adapter.notifyDataSetChanged();

    }
}
