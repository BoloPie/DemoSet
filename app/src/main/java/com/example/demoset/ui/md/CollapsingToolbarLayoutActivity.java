package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import com.example.demoset.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {
    @Bind(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
//    @Bind(R.id.activity_app_bar_layout_more_refresh)
//    SwipyRefreshLayout swipyRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout_more);
        ButterKnife.bind(this);

//        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) nestedScrollView.getLayoutParams()).getBehavior();

//        Log.d("----",appBarLayout+"");
//        Log.d("----",coordinatorLayout+"");
//        Log.d("----",nestedScrollView+"");
//        Log.d("----",appBarLayout.getLayoutParams().height+"");
//        Log.d("----",appBarLayout.getLayoutParams().height+"");

//        behavior.onNestedPreScroll(coordinatorLayout, appBarLayout, nestedScrollView, 0, 500, new int[]{0, 0});

//        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh(SwipyRefreshLayoutDirection direction) {
//                swipyRefreshLayout.setRefreshing(false);
//            }
//        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.activity_app_bar_layout_more_suspend_tv)
    void doSuspend(){
//        appBarLayout.setVisibility(View.GONE);
        appBarLayout.setExpanded(false);
    }



//    @Override
//    public voidonOffsetChanged(AppBarLayout appBarLayout, intverticalOffset) {
//
//        if(verticalOffset ==0) {
//
//            Timber.e("可以下拉");
//
//            mNewsHouseFragmenr.onAppBarExpanded();
//
//        }else{
//
//            Timber.e("不能下拉");
//
//            mNewsHouseFragmenr.onAppBarCollapsed();
//
//        }
//
//    }
}
