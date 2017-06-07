package com.example.demoset.base;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.example.demoset.util.TextUtil;


/**
 * 基础的带有Log日志打印功能的Fragment
 *
 * @Author: Created by Shyky on 2016/4/6.
 * @Email: sj1510706@163.com
 */
public abstract class BaseLogFragment extends DialogFragment {
    /**
     * Log日志标签
     */
    private String tag;

    /**
     * 得到Log日志标签名称，用于打印调试信息
     *
     * @return Log日志标签名称
     */
    protected abstract String getLogTagName();

    /**
     * 构造方法
     */
    public BaseLogFragment() {
        final String tagName = getLogTagName();
        if (TextUtil.isEmptyAndNull(tagName))
            this.tag = "BaseLogFragment";
        else
            this.tag = tagName;
    }

    final protected void d(String msg) {
        Log.d(tag, msg);
    }



    final protected void e(String msg) {
        Log.e(tag, msg);
    }

    final protected void i(String msg) {
        Log.i(tag, msg);
    }

    final protected void v(String msg) {
        Log.v(tag, msg);
    }

    final protected void w(String msg) {
        Log.w(tag, msg);
    }
}