package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.demoset.R;

public class AppBarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_app_bar_layout_toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("This is Title");
        toolbar.setNavigationIcon(R.mipmap.back);


    }
}
