package com.example.demoset.ui.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.demoset.R;
import com.example.demoset.bean.UserBean;
import com.example.demoset.retrofit.ApiService;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        query();
    }


    private void query(){
        //1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //2.创建访问API的请求
        ApiService service = retrofit.create(ApiService.class);
        Call<UserBean> call = service.getUsersList();
        //3.发送请求
        call.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                //4.处理结果

                if (null != response){
                    Log.e("--------toString-",response.toString());
                    Log.e("---------",response.body().toString());
                    System.out.println(response.body());


                }

            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });

    }
}
