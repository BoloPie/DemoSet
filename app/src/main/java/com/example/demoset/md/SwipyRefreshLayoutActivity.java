package com.example.demoset.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.example.demoset.R;
import com.example.demoset.view.NoScrollListView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipyRefreshLayoutActivity extends AppCompatActivity {

    @Bind(R.id.activity_swipy_refresh_layout_swipyrefreshlayout)
    SwipyRefreshLayout swipyRefreshLayout;
    @Bind(R.id.activity_swipy_refresh_layout_listview)
    NoScrollListView listView;

    ArrayList<String> list;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipy_refresh_layout);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    swipyRefreshLayout.setRefreshing(false);
                } else {
                    swipyRefreshLayout.setRefreshing(false);
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            String text = "折颜" + i;
            list.add(text);
        }
        adapter.notifyDataSetChanged();
    }

}
