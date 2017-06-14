package com.example.demoset.ui.md;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.demoset.R;
import com.example.demoset.adapter.NormalAdapter;
import com.example.demoset.helper.SimpleItemTouchHelper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 上下左右拖拽
 */
public class ItemTouchHelperActivity extends AppCompatActivity {
    @Bind(R.id.activity_item_touch_helper_recycler)
    RecyclerView recyclerView;
    NormalAdapter adapter;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_helper);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new NormalAdapter(list);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        //设置左滑删除
        SimpleItemTouchHelper simpleItemTouchHelper = new SimpleItemTouchHelper(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new NormalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {

            }
        });


        //假数据
        for (int i = 0; i < 10 ; i++) {
            list.add(String.valueOf(i));
        }
        adapter.notifyDataSetChanged();

    }
}
