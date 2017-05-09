package com.example.demoset.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoset.R;
import com.example.demoset.fragment.OneFragment;

import butterknife.ButterKnife;


public class DynamicFragmentActivity extends AppCompatActivity implements OneFragment.OnFragmentInteractionListener{
    OneFragment oneFragment;
    DialogFragment mDialogFragment  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        ButterKnife.bind(this);

        oneFragment =  OneFragment.newInstance("最基础","的fragment");


        /* 1.getChildFragmentManager()
        从官方文档注释上也可以看出这两个方法获取到的 FragmentManager 对象的区别：

Activity：getFragmentManager()

Fragment：getChildFragmentManager()

 */
        FragmentManager fm = getSupportFragmentManager();
        /* 2.FragmentTransaction
        Fragment 的动态添加、删除等操作都需要借助于 FragmentTransaction 类来完成：
add() 系列：添加 Fragment 到 Activity 界面中；

remove()：移除 Activity 中的指定 Fragment；

replace() 系列：通过内部调用 remove() 和 add() 完成 Fragment 的修改；

hide() 和 show()：隐藏和显示 Activity 中的 Fragment；

addToBackStack()：添加当前事务到回退栈中，即当按下返回键时，界面回归到当前事物状态；

commit()：提交事务，所有通过上述方法对 Fragment 的改动都必须通过调用 commit() 方法完成提交；*/
        FragmentTransaction ft = fm.beginTransaction();
        /*动态切换显示 Activity 中的多个 Fragment 时，可以通过 replace() 实现，也可以 hide() 和 show() 方法实现。
        事实上，我们更倾向于使用后者，因为 replace() 方法不会保留 Fragment 的状态，
        也就是说诸如 EditText 内容输入等用户操作在 remove() 时会消失。*/
        ft.replace(R.id.activity_dynamic_fragment_flay, oneFragment);
        ft.commit();



        /* 3.BackStack（回退栈）*/
      /*  FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(firstStepFragment);
        if (secondStepFragment==null){
            ft.add(R.id.fl_content, secondStepFragment);
        }else {
            ft.show(secondStepFragment);
        }
        ft.addToBackStack(null);
        ft.commit();*/

        /* 4.通信方式
         通常，Fragment 与 Activity 通信存在三种情形：Activity 操作内嵌的 Fragment，Fragment 操作宿主 Activity，Fragment 操作同属 Activity中的其他 Fragment。
          虽然上述操作已经能够解决 Activity 与 Fragment 的通信问题，但会造成代码逻辑紊乱的结果，极度不符合这一编程思想：高内聚，低耦合。Fragment 做好自己的事情即可，所有涉及到 Fragment 之间的控制显示等操作，都应交由宿主 Activity 来统一管理。

所以我们强烈推荐，使用对外开放接口的形式将 Fragment 的一些对外操作传递给宿主 Activity。
具体实现方式：回调
*/
        oneFragment.setmListener(this);


        /*6.Fragment 重叠问题
前面我们介绍 Fragment 初始化时提到 Activity 销毁重建的问题，试想一下，当 Activity 重新执行 onCreate() 方法时，是不是会再次执行 Fragment 的创建和显示等操作呢？而之前已经存在的 Fragment 实例也会销毁再次创建，这不就与 Activity 中 onCreate() 方法里面第二次创建的 Fragment 同时显示从而发生 UI 重叠的问题了吗？

根据经验，通常我们会在 AndroidManifest 里将 Activity 设置为横屏模式，所以不会由于屏幕旋转导致这种问题的出现。一种比较多的出现方式是，应用长时间处于后台，但由于设备内存吃紧，导致 Activity 被销毁，而当用户再次打开应用时便会发生 Fragment 重叠的问题。但是这种问题在开发阶段由于应用的频繁使用导致我们很难遇见，但确确实实存在着。所以开发过程中，一定要注意这类问题。

知道问题的根源所在之后，对应的解决方案也就有啦。就是在 Activity 中创建 Fragment 实例时，添加一个判断即可，处理方式有三种：
      第一种方式，在 Activity 提供的 onAttachFragment() 方法中处理：
      第二种方式，在创建 Fragment 前添加判断，判断是否已经存在：
      第三种方式，更为简单，直接利用 savedInstanceState 判断即可：
        * */

//          第二种方式，在创建 Fragment 前添加判断，判断是否已经存在：
        Fragment tempFragment =getSupportFragmentManager().findFragmentByTag("OneFragment");
        if (tempFragment==null) {
            oneFragment = OneFragment.newInstance("","");
            ft.add(R.id.activity_dynamic_fragment_flay, oneFragment, "OneFragment");
        }else {
            oneFragment = (OneFragment) tempFragment;
        }


//       第三种方式，更为简单，直接利用 savedInstanceState 判断即可：
        if (savedInstanceState==null) {
            oneFragment = OneFragment.newInstance("","");
            ft.add(R.id.activity_dynamic_fragment_flay, oneFragment, "OneFragment");
        }else {
            oneFragment = (OneFragment) getSupportFragmentManager().findFragmentByTag("OneFragment");
        }

        /*7.DialogFragment show 问题
        如果用户连续点击按钮，导致同一时刻多次触发 show 操作，你会发现，App 立马崩溃退出
        除了第一次触发，间隔触发时前面一定调用过 dismiss() 方法 (dialog 消失)，也就是 remove 过 fragment 对象。
        而连续多次触发时，导致对同一个 fragment 对象多次执行 add 操作，导致报错。
        */
//        if (mDialogFragment == null) {
//            mDialogFragment = SampleDialogFragment.newInstance();
//        }
//        Dialog mDialog = SampleDialogFragment.getDialog();
//        if (mDialog==null || !mDialog.isShowing()) {
//            mDialogFragment.show(getSupportFragmentManager(), FRAGMENT_TAG_SAMPLE);
//        }



    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
//         第一种方式，在 Activity 提供的 onAttachFragment() 方法中处理：
        if (fragment instanceof  OneFragment){
            oneFragment = (OneFragment) fragment;
        }
    }

    /*8.onActivityResult()
    举个例子，在 ActivityA 中的 FragmentA 里面调用 startActivityForResult() 跳转至 ActivityB 中，并在 ActivityB 中的 FragmentB 里面返回到 ActivityA，返回代码如下：
Intent intent = new Intent();
getActivity().setResult(Activity.RESULT_OK, intent);
getActivity().finish();

 再拓展一下，如果 FragmentA 中又嵌入一层 FragmentAA ，然后从 FragmentAA 中跳转至 ActivityB，那么在 FragmentAA 中的 onActivityResult() 方法中能收到回调吗？
 显然不能。从上述源码中可以看出 FragmentActivity 只进行到一级分发。所以，如果想实现多级分发，就得自己在各级 Fragment 中手动添加分发代码，至下一级 Fragment 中。*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        mFragments.noteStateNotSaved();
//        int requestIndex = requestCode>>16;
//        if (requestIndex != 0) {
//            requestIndex--;
//
//            String who = mPendingFragmentActivityResults.get(requestIndex);
//            mPendingFragmentActivityResults.remove(requestIndex);
//            if (who == null) {
//                Log.w(TAG, "Activity result delivered for unknown Fragment.");
//                return;
//            }
//            Fragment targetFragment = mFragments.findFragmentByWho(who);
//            if (targetFragment == null) {
//                Log.w(TAG, "Activity result no fragment exists for who: " + who);
//            } else {
//                targetFragment.onActivityResult(requestCode & 0xffff, resultCode, data);
//            }
//            return;
//        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*9.状态变迁监听
Fragment 的 hide 和 show 等状态变迁操作都会反应在相应的回调函数中，我们可以利用这些监听函数做一些界面刷新等功能。
较为常见的一个监听函数就是 onHiddenChanged() 方法，这个方法的变化直接影响着 isHidden() 方法的返回值。

除了 isHidden() 方法，还有一个 isVisible() 方法，也用于判断 Fragment 的状态，表明 Fragment 是否对用户可见，如果为 true，
必须满足三点条件：1，Fragment 已经被 add 至 Activity 中；2，视图内容已经被关联到 window 上；3. 没有被隐藏，即 isHidden() 为 false。
    * */




}
