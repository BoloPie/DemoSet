package com.example.demoset.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.demoset.R;
import com.github.ybq.android.spinkit.style.DoubleBounce;

/**
 * Created by 张凌云 on 2017/6/5.
 */
public class LoadingDialog {

    private Dialog dialog;
    private ProgressBar progressBar;

    public LoadingDialog(Context context) {
        dialog = new Dialog(context, R.style.AppTheme_Dialog_Progress);
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.dialog_loading, null);
        progressBar = (ProgressBar) layout.findViewById(R.id.dialog_loading_progress);
        DoubleBounce doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        dialog.setContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
//        dialog.setOnCancelListener(new OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                if (cancelListener != null) {
//                    cancelListener.onCancel(dialog);
//                }
//            }
//        });
    }

    public LoadingDialog(Context context, int themeResId) {

    }

    protected LoadingDialog(Context context, final OnCancelListener cancelListener) {
        dialog = new Dialog(context, R.style.AppTheme_Dialog_Progress);
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.dialog_loading, null);
        progressBar = (ProgressBar) layout.findViewById(R.id.dialog_loading_progress);
        DoubleBounce doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        dialog.setContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (cancelListener != null) {
                    cancelListener.onCancel(dialog);
                }
            }
        });
    }

    public void show(final OnCancelListener cancelListener) {
        if (!dialog.isShowing()) {
            try {
                dialog.setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (cancelListener != null) {
                            cancelListener.onCancel(dialog);
                        }
                    }
                });
                dialog.show();
            } catch (Exception e) {
            }
        }
    }

    public void show() {
        if (!dialog.isShowing()) {
            try {
                dialog.show();
            } catch (Exception e) {
            }
        }
    }

    public void dismiss() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
        }
    }

    public void cancel() {
        try {
            dialog.cancel();
        } catch (Exception e) {
        }
    }

    public boolean isShowing() {
        return dialog.isShowing();
    }


}
