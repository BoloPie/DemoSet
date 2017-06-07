package com.example.demoset.retrofit;

/**
 * 我们希望当cancel掉ProgressDialog的时候，能够取消订阅，也就取消了当前的Http请求。
 */

public interface ProgressCancelListener {
    void onCancelProgress();
}
