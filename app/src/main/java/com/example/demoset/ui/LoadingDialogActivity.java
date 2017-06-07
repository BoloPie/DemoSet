package com.example.demoset.ui;

import android.os.Bundle;

import com.example.demoset.R;
import com.example.demoset.base.BaseActivity;

public class LoadingDialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_dialog);

        loadingDialog.show();

    }
}
