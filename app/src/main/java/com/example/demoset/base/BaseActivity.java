package com.example.demoset.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.demoset.widget.LoadingDialog;

/**
 * Created by 张凌云 on 2017/6/5.
 */

public class BaseActivity extends AppCompatActivity {

    public LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(this);


    }
}
