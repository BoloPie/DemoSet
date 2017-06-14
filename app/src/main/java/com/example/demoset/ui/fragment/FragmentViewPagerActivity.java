package com.example.demoset.ui.fragment;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoset.R;
import com.example.demoset.adapter.ContentPagerAdapter;
import com.example.demoset.fragment.OneFragment;
import com.example.demoset.fragment.ViewPagerOneFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentViewPagerActivity extends AppCompatActivity  {

    @Bind(R.id.activity_fragment_view_pager_viewpager)
    ViewPager viewPager;
    @Bind(R.id.activity_fragment_view_pager_tab_layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view_pager);
        ButterKnife.bind(this);

        ArrayList<Fragment> fragmentList = new ArrayList<>();

        OneFragment oneFragment = OneFragment.newInstance("","");
        ViewPagerOneFragment viewPagerOneFragment = ViewPagerOneFragment.newInstance("","");
        fragmentList.add(oneFragment);
        fragmentList.add(viewPagerOneFragment);

        ArrayList<String> mTitles = new ArrayList<>();
        mTitles.add("发现");
        mTitles.add("推荐");

        viewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(),fragmentList,mTitles));

        //实现TabLayout 与 ViewPager 联动
        tabLayout.setupWithViewPager(viewPager);

        //默认选中某项 这里是选中推荐
        tabLayout.getTabAt(0).select();
    }


}
