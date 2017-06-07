package com.example.demoset.retrofit;

import com.example.demoset.bean.BookSearchBean;
import com.example.demoset.bean.UserBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 张凌云 on 2017/6/5.
 * 定义网络接口
 */

public interface ApiService {


//    public static final String BaseUrl = "https://api.github.com/";
    public static final String BaseUrl = " https://api.douban.com/v2/";

    @GET("users/list")
//    https://api.github.com/users/list
    Call<UserBean> getUsersList();


    @GET("users/list")
    Observable<UserBean> getUsersListRxjava();

    //预处理，在resultCode != 0的时候，抛出个自定义的ApiException。这样就会进入到subscriber的onError中，我们可以在onError中处理错误信息。
    @GET("users/list")
    Observable<HttpResult<UserBean>> getUsersListRxjavaYU();


    //    https://api.douban.com/v2/book/search?q=小王子&tag=&start=0&count=3
    @GET("book/search")
    Observable<BookSearchBean> getSearchBooks(@Query("q") String name,
                                        @Query("tag") String tag, @Query("start") int start,
                                        @Query("count") int count);

    @GET("book/search")
    Observable<BookSearchBean> getSearchBooks(@QueryMap Map<String, String> options);
}
