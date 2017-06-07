package com.example.demoset.retrofit;

/**
 * 我们希望这里能够让Activity或者Fragment自己处理onNext之后的逻辑
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
