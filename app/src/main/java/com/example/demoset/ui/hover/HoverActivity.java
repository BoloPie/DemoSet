package com.example.demoset.ui.hover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.demoset.R;
import com.example.demoset.view.HoverScrollView;
import com.example.demoset.view.NoScrollListView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 悬停--悬停后滑动不下来
 */
public class HoverActivity extends AppCompatActivity implements HoverScrollView.OnScrollListener {

    @Bind(R.id.activity_hover_lv)
    NoScrollListView listView;
    @Bind(R.id.activity_hover_top_hide_tv)
    TextView hideTV;
    @Bind(R.id.activity_hover_stop_tv)
    TextView stopTv;

    @Bind(R.id.myScrollView)
    HoverScrollView mHsv;

    private int searchLayoutTop;

    @Bind(R.id.activity_hover_container)
    LinearLayout container;
    @Bind(R.id.activity_hover_top_lay)
    LinearLayout topLay;
    @Bind(R.id.activity_hover_top_hide_lay)
    LinearLayout hideLay;
    @Bind(R.id.activity_hover_stop_lay)
    LinearLayout stopLay;



    @Bind(R.id.activity_hover_refresh)
    SwipyRefreshLayout swipyRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hover);
        ButterKnife.bind(this);
        mHsv.setOnScrollListener(this);


        ArrayList<String> list  = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        adapter.notifyDataSetChanged();


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
//        searchLayoutTop = hideLay.getBottom();//获取searchLayout的顶部位置
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = hideLay.getBottom();//获取searchLayout的顶部位置
        }
    }



    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= searchLayoutTop) {
            if (stopTv.getParent() != topLay) {
                stopLay.removeView(stopTv);
                topLay.addView(stopTv);
            }
        } else {
            hideLay.setVisibility(View.VISIBLE);
            if (stopTv.getParent() != stopLay) {
                topLay.removeView(stopTv);
                stopLay.addView(stopTv);
            }
        }
    }

    @OnClick(R.id.activity_hover_stop_lay)
    void goHover(){
//        滚动到指定位置
//        mHsv.scrollTo(0,hideLay.getBottom());
        hideLay.setVisibility(View.GONE);
    }
}
