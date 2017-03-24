package com.example.demoset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.demoset.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewLinearActivity extends AppCompatActivity {

    ArrayList<String> list ;
    RecyclerViewAdapter adapter;

    @Bind(R.id.activity_recycler_view_linear_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_linear);
        ButterKnife.bind(this);

        list =  new ArrayList<>();
        adapter = new RecyclerViewAdapter(list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置分隔线
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));//设置分割线，默认是android自带的listDivider
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置ITEM增加删除的动画


        for (int i = 0; i < 20; i++) {
            String text = "十里桃花"+ String.valueOf(i);
            list.add(text);
        }
        adapter.notifyDataSetChanged();

    }
}
