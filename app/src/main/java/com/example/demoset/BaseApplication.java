package com.example.demoset;

import android.app.Application;
import android.content.Context;

import com.example.demoset.service.LeakUploadService;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by 张凌云 on 2017/5/2.
 */

public class BaseApplication extends Application {

    private RefWatcher refWatcher;
    @Override public void onCreate() {
        super.onCreate();
        //检测对象：所有的activity
//        refWatcher = LeakCanary.install(this);//这样就可以检测所有Activity的内存泄露了。
        refWatcher = installLeakCanary();
    }
    //给它个监控对象让它让检查,
    public static RefWatcher getRefWatcher(Context context) {
        //检测对象：除了Activity会发生内存泄露以外，其他对象也有可能会出现内存泄露，例如fragment。
        //检测时间：一般我们是在对象销毁的时候对对象进行监控
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
//        LeakCanary.install(this,)
//        return LeakCanary.install(this, LeakUploadService.class);
    }

}
