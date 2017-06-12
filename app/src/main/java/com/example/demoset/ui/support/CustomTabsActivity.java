package com.example.demoset.ui.support;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoset.R;

/**
 * 让用户感觉浏览第三方网页就像您应用本身的功能一样
 */
public class CustomTabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tabs);


    }
}
