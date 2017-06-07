package com.example.demoset.retrofit;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * 用了一个Handler来封装了ProgressDialog。
 * Handler接收两个消息来控制显示Dialog还是关闭Dialog。
 */

public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener progressCancelListener;

    public ProgressDialogHandler(ProgressCancelListener progressCancelListener, boolean cancelable, Context context) {
        this.progressCancelListener = progressCancelListener;
        this.cancelable = cancelable;
        this.context = context;
    }

    private void initProgressDialog(){
        if (pd == null){
            pd = new ProgressDialog(context);
            pd.setCancelable(cancelable);

            if (cancelable){
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        progressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!pd.isShowing()){
                pd.show();
            }
        }
    }

    private void dismissProgressDialog(){
        if (pd != null){
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
