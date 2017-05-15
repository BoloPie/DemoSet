package com.example.demoset.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by 张凌云 on 2017/5/10.
 */

public class KeyBoradUtils {

    // 隐藏键盘
    public static void hideKeyBoard(Context context) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        // 得到InputMethodManager的实例
        if (imm.isActive()) {
            // 如果开启
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                    InputMethodManager.HIDE_NOT_ALWAYS);
            // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
        }
    }
}
