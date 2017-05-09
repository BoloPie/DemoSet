package com.example.demoset.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 张凌云 on 2017/5/8.
 */

/* ViewPager 提供了两种页面适配器来管理不同 Fragment 之间的滑动切换：FragmentPagerAdapter 和 FragmentStatePagerAdapter。
1.使用 FragmentPagerAdapter 时，ViewPager 中的所有 Fragment 实例常驻内存，
当 Fragment 变得不可见时仅仅是视图结构的销毁，即调用了 onDestroyView 方法。由于 FragmentPagerAdapter 内存消耗较大，所以适合少量静态页面的场景。

2.使用 FragmentStatePagerAdapter 时，当 Fragment 变得不可见，不仅视图层次销毁，实例也被销毁，
即调用了 onDestroyView 和 onDestroy 方法，仅仅保存 Fragment 状态。
相比而言， FragmentStatePagerAdapter 内存占用较小，所以适合大量动态页面，比如我们常见的新闻列表类应用。
Fragment 实例均保存在内存中，具有一定内存消耗，适合于页面较少的情况。至于大量页面，还是推荐通过 Fragment 自带的状态保存与恢复方式处理。
*/

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    private FragmentManager fragmentManager;
    private ArrayList<String> mTitles;

    public ContentPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragmentList,ArrayList<String> mTitles) {
        super(fm);
        this.fragmentManager = fm;
        this.fragmentList = fragmentList;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    /*Fragment 状态恢复问题*/
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.fragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = fragmentList.get(position);
        fragmentManager.beginTransaction().hide(fragment).commit();
    }


}
