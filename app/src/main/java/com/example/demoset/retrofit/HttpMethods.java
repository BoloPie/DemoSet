package com.example.demoset.retrofit;

import com.example.demoset.bean.BookSearchBean;
import com.example.demoset.bean.UserBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Rxjava + retrofit
 * 在HttpMethods封装对应的请求
 */

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private ApiService service;

    private HttpMethods() {
//        手动创建一个OkHttpClient 并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        添加请求头
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                Request build = builder.addHeader("name", "value").build();
                return chain.proceed(build);
            }
        }).retryOnConnectionFailure(true)
                .build();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiService.BaseUrl)
                .build();
        service = retrofit.create(ApiService.class);
    }

    //    在访问httpMethods 时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //    获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //添加线程管理并订阅(写更改线程的代码觉得也很烦的话，可以把订阅这部分也封装起来：)
    private void toSubscribe(Observable o, Subscriber s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getResultCode() != 0) {
                throw new ApiException(httpResult.getResultCode());
            }
            return httpResult.getData();
        }
    }

    /**
     * 获取用户列表
     *
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getUsersList(Subscriber<UserBean> subscriber) {
        service.getUsersListRxjava()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取用户列表, 在resultCode != 0的时候，抛出个自定义的ApiException。这样就会进入到subscriber的onError中
     *
     * @param subscriber
     */
    public void getUsersListYU(Subscriber<UserBean> subscriber) {
        service.getUsersListRxjavaYU()
                .map(new HttpResultFunc<UserBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 订阅封装以后
     *
     * @param subscriber
     */
    public void getUsersListDY(Subscriber<UserBean> subscriber) {
        Observable observable = service.getUsersListRxjavaYU()
                .map(new HttpResultFunc<UserBean>());
        toSubscribe(observable, subscriber);
    }

    public void getBookSearch(Subscriber<BookSearchBean> subscriber) {
        Map<String, String> options = new HashMap<>();
        options.put("q", "小王子");
        options.put("tag", "");
        options.put("start", "0");
        options.put("count", "3");
        Observable observable = service.getSearchBooks(options);
        toSubscribe(observable, subscriber);
    }

}
