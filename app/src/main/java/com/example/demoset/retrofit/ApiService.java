package com.example.demoset.retrofit;

import com.example.demoset.bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 张凌云 on 2017/6/5.
 * 定义网络接口
 */

public interface ApiService {


    public static final String BaseUrl = "https://api.github.com/";


    @GET("users/list")//    https://api.github.com/users/list
    Call<UserBean> getUsersList();


    @GET("users/list")
    Observable<UserBean> getUsersListRxjava();

    //预处理，在resultCode != 0的时候，抛出个自定义的ApiException。这样就会进入到subscriber的onError中，我们可以在onError中处理错误信息。
    @GET("users/list")
    Observable<HttpResult<UserBean>> getUsersListRxjavaYU();

}
