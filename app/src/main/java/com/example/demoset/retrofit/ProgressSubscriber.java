package com.example.demoset.retrofit;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by 张凌云 on 2017/6/7.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener{

    private SubscriberOnNextListener subscriberOnNextListener;

    private Context context;

    private ProgressDialogHandler progressDialogHandler;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context) {
        this.subscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        progressDialogHandler = new ProgressDialogHandler(this,false,context);
    }

    private void showProgressDialog(){
        if (progressDialogHandler != null){
            progressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog(){
        if (progressDialogHandler != null){
            progressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            progressDialogHandler = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //启动一个ProgressDialog
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        //停止ProgressDialog
        dismissProgressDialog();
        Toast.makeText(context, "获取成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        //我们集中处理错误，同时也停止ProgressDialog
        dismissProgressDialog();
        Toast.makeText(context, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {
        //处理数据相关的逻辑
        subscriberOnNextListener.onNext(t);

    }

    @Override
    public void onCancelProgress() {
        //在这里面取消订阅。
        if (!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }
}
