package com.example.demoset;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

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


    }


    @OnClick(R.id.activity_app_bar_layout_more_suspend_tv)
    void doSuspend(){
//        appBarLayout.setVisibility(View.GONE);
        appBarLayout.setExpanded(false);
    }
}
