package com.example.demoset.ui.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.demoset.R;
import com.example.demoset.bean.BookSearchBean;
import com.example.demoset.bean.UserBean;
import com.example.demoset.retrofit.ApiService;
import com.example.demoset.retrofit.HttpMethods;
import com.example.demoset.retrofit.ProgressSubscriber;
import com.example.demoset.retrofit.SubscriberOnNextListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitRxjavaActivity extends AppCompatActivity {
@Bind(R.id.activity_retrofit_rxjava_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_rxjava);
        ButterKnife.bind(this);

//        没有封装前
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        service.getUsersListRxjava()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                    }
                });



//        封装以后
        Subscriber<UserBean> subscriber = new Subscriber<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBean userBean) {

            }
        };
        HttpMethods.getInstance().getUsersList(subscriber);


//封装ProgressDialog以后
//        SubscriberOnNextListener nextListener = new SubscriberOnNextListener<UserBean>() {
//            @Override
//            public void onNext(UserBean o) {
//                textView.setText(o.getBlog());
//            }
//        };
//        HttpMethods.getInstance().getUsersListDY(new ProgressSubscriber<UserBean>(nextListener,this));

//封装ProgressDialog以后
        SubscriberOnNextListener nextListener = new SubscriberOnNextListener<BookSearchBean>() {
            @Override
            public void onNext(BookSearchBean o) {
                Log.e("---------",o.toString());
                textView.setText(o.getBooks().get(0).getAuthor_intro());
            }
        };
        HttpMethods.getInstance().getBookSearch(new ProgressSubscriber<BookSearchBean>(nextListener,this));

    }
}
