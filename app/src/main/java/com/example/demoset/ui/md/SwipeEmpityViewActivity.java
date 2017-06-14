package com.example.demoset.ui.md;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.helper.EmptyViewHelper;
import com.example.demoset.view.EmpityListView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeEmpityViewActivity extends AppCompatActivity {

    @Bind(R.id.listview)
    EmpityListView listView;


    @Bind(R.id.swipe_container)
    SwipyRefreshLayout swipyRefreshLayout;


    ArrayList<String> list;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_empity_view);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setVisibility(View.VISIBLE);
        listView.setEmptyView(findViewById(android.R.id.empty));
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

//        for (int i = 0; i < 10; i++) {
//            String text = "折颜" + i;
//            list.add(text);
//        }
//        adapter.notifyDataSetChanged();

    }


}
