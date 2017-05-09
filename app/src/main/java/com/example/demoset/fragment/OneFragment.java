package com.example.demoset.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoset.R;

public class OneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /* 5.getActivity() 引用问题
    *第一个， Activity 的实例销毁问题。比如，Fragment 中存在类似网络请求之类的异步耗时任务，当该任务执行完毕回调 Fragment 的方法并用到宿主 Activity 对象时，很有可能宿主 Activity 对象已经销毁，从而引发 NullPointException 等异常，甚至造成程序崩溃。所以，异步回调时需要注意添加空值等判断（譬如：fragment.isAdd()，getActivity()!＝null 等），或者在 Fragment 创建实例时就通过 getActivity().getApplicationContext() 方法保存整个应用的上下文对象，再来使用；

第二个，内存泄漏问题。如果 Fragment 持有宿主 Activity 的引用，会导致宿主 Activity 无法回收，造成内存泄漏。所以，如果可以的话，尽量不要在 Fragment 中持有宿主 Activity 的引用。

为了解决 Context 上下文引用的问题，Fragment 提供了一个 onAttach(context) 方法，在此方法中我们可以获取到 Context 对象，如：
    *
    * */
    private Context context;

    public OneFragment() {
        // Required empty public constructor
    }


    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
        // 发起网络请求, 刷新界面数据
//            requestData();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     4.通信方式
     通常，Fragment 与 Activity 通信存在三种情形：Activity 操作内嵌的 Fragment，Fragment 操作宿主 Activity，Fragment 操作同属 Activity中的其他 Fragment。
     虽然上述操作已经能够解决 Activity 与 Fragment 的通信问题，但会造成代码逻辑紊乱的结果，极度不符合这一编程思想：高内聚，低耦合。Fragment 做好自己的事情即可，所有涉及到 Fragment 之间的控制显示等操作，都应交由宿主 Activity 来统一管理。

     所以我们强烈推荐，使用对外开放接口的形式将 Fragment 的一些对外操作传递给宿主 Activity。
     具体实现方式：回调
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void setmListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }



 /*9.状态变迁监听
这种 UI 结构想必大家都很熟悉，经常作为 App 的首页主界面布局，这里我们假设没有使用 ViewPager，而是普通操作 Fragment，通过 add()、show()、hide() 方法实现切换不同 Tab 控制 Activity 里面各个 Fragment 的显示和隐藏。并且这四个 Fragment 都需要通过加载网络数据显示内容，同时要求不同 Fragment 之间切换显示时都要重新请求服务器刷新当前界面的数据，这该怎么做呢？

这里有好几种情况要考虑：

第一种，在四个 Fragment 都已经显示过的情况下，不同 Tab 切换时，当前 Fragment 的 onResume() 方法不会被调用，需要在 onHiddenChanged() 方法中请求服务器；

第二种，从其他 Activity 返回这个 Activity 时，当前 Fragment 不会调用 onHiddenChanged() 方法，需要在 onResume() 方法中请求服务器；

第三种，类似第二种场景，不同的是其他 Activity 返回时，还指定切换至处于隐藏状态的另一个 Fragment，对于这个 Fragment 来说，onResume() 和 onHiddenChanged() 方法都会被调用；

综上所述，为了实现切换刷新操作，必须在 onResume() 和 onHiddenChanged() 方法中请求服务器。但是还得避免重复多次请求服务器操作，必须在两个方法中添加状态判断，只有对用户可见时，才刷新界面。示例代码如下：

这种写法需要注意的是，第一个 Fragment，也就是图中的 OneFragment，必须在 create 时调用一次 requestData() 操作，如前面所说，此时 onResume() 方法中的 isVisible() 值为 false；其他 Fragment 则可以不用这么做，因为 isVisible() 值为 true。*/
    @Override
    public void onResume() {
        super.onResume();
        if (isVisible()){
            // 发起网络请求, 刷新界面数据
//            requestData();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        // 这里的 isResumed() 判断就是为了避免与 onResume() 方法重复发起网络请求
        if (isVisible() && isResumed()){
//            requestData();
        }
    }

/* 9.最后，还有一种特殊情况需要处理，就是系统由于内存不足时杀掉 App 的情况。
如果当前显示的不是第一个 Fragment，App 被杀掉再次重启时，显示这个 Fragment 时，isVisible() 的判断始终为 false，这种情况下刷新数据的操作，还要额外处理，比如引入这个判断：*/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState!=null){
            // 发起网络请求, 刷新界面数据
//            requestData();
        }
    }
}
