package com.example.demoset.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.demoset.R;
import com.example.demoset.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewLinearActivity extends AppCompatActivity {

    ArrayList<RecyclerViewAdapter.DataModel> list;
    RecyclerViewAdapter adapter;

    @Bind(R.id.activity_recycler_view_linear_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_linear);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(list);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setLayoutManager(gridLayoutManager);
        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置分隔线
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));//设置分割线，默认是android自带的listDivider
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置ITEM增加删除的动画

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerViewAdapter.DataModel data) {
                Toast.makeText(RecyclerViewLinearActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });


        for (int i = 0; i < 20; i++) {
            RecyclerViewAdapter.DataModel model = new RecyclerViewAdapter.DataModel();
            model.setName("十里桃花" + String.valueOf(i));
            list.add(model);
        }
        adapter.notifyDataSetChanged();

    }

    @OnClick(R.id.activity_recycler_view_linear_add_btn)
    void add() {
        RecyclerViewAdapter.DataModel model = new RecyclerViewAdapter.DataModel();
        model.setName("折颜");
        adapter.addItem(model, 0);
    }

    @OnClick(R.id.activity_recycler_view_linear_del_btn)
    void del() {
        RecyclerViewAdapter.DataModel model = list.get(0);
        adapter.removeItem(model);
    }
}
