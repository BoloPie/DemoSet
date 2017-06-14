package com.example.demoset.ui.other;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.demoset.R;

public class ActionBarActivity extends AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        // setContentView(R.layout.activity_main);// 使用Tab导航可以不用设置根视图(root view),文章后面会做解释
        ActionBar actionBar = getSupportActionBar();// 如果不使用Android Support Library, 则调用getActionBar()方法
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);// NAVIGATION_MODE_TABS常量表示Tab导航模式
        actionBar.setDisplayShowTitleEnabled(true);// 这里的Title显示的是Activity的android:label属性指定的文字，也就是图1中”Google Play”

        ActionBar.Tab tab = actionBar.newTab().setText("第一项").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("第二项").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("第三项").setTabListener(this);
        actionBar.addTab(tab);


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
// Tab选中时要执行的代码
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Tab离开选中状态时执行的代码
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
// Tab被选中后用户再次选中该Tab所执行的代码，通常不做任何事情
    }


}
