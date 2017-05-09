package com.example.demoset.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
/*懒加载，顾名思义，是希望在展示相应 Fragment 页面时再动态加载页面数据，数据通常来自于网络或本地数据库。
这种做法的合理性在于用户可能不会滑到一下页面，同时还能帮助减轻当前页面数据请求的带宽压力，如果是用户使用流量的话，还能避免无用的流量消耗。

思路：ViewPager 本质上是通过 Fragment 调用 setUserVisibleHint 方法实现 Fragment 页面的展示与隐藏，这一点从FragmentPagerAdapter 和 FragmentStatePagerAdapter 的源码和上面的截图中都可以看出。
那么对应的解决方案就有了，自定义一个 LazyLoadFragment 基类，利用 setUserVisibleHint 和 生命周期方法，
通过对 Fragment 状态判断，进行数据加载，并将数据加载的接口提供开放出去，供子类使用。
然后在子类 Fragment 中实现 requestData 方法即可。这里添加了一个 isDataLoaded 变量，目的是避免重复加载数据。
*/


/**
 * 接口有请求的懒加载封装
 */
public abstract  class LazyLoadFragment extends Fragment {
    protected boolean isViewInitiated;
    protected boolean isDataLoaded;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        if (savedInstanceState!=null) {
            prepareRequestData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        prepareRequestData();
    }

    public abstract void requestData();

    public boolean prepareRequestData() {
        return prepareRequestData(false);
    }

    public boolean prepareRequestData(boolean forceUpdate) {
        if (getUserVisibleHint() && isViewInitiated && (!isDataLoaded || forceUpdate)) {
            requestData();
            isDataLoaded = true;
            return true;
        }
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isVisible()){
            // 发起网络请求, 刷新界面数据
//            requestData();
            prepareRequestData();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        // 这里的 isResumed() 判断就是为了避免与 onResume() 方法重复发起网络请求
        if (isVisible() && isResumed()){
//            requestData();
            prepareRequestData();
        }
    }


}
