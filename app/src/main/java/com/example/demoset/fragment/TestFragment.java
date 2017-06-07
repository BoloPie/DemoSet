package com.example.demoset.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.demoset.base.BaseFragment;

/**
 * Created by 张凌云 on 2017/5/24.
 */

public class TestFragment extends BaseFragment {
    @Override
    protected String getLogTagName() {
        return null;
    }

    @Override
    public int getCreateViewLayoutId() {
        return 0;
    }

    @Override
    public void findView(View inflateView, Bundle savedInstanceState) {
        super.findView(inflateView, savedInstanceState);
    }

    @Override
    public void initView(View inflateView, Bundle savedInstanceState) {
        super.initView(inflateView, savedInstanceState);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void initDialog() {
        super.initDialog();
    }
}
