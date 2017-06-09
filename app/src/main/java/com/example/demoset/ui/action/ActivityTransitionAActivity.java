package com.example.demoset.ui.action;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 转场动画A
 */
public class ActivityTransitionAActivity extends AppCompatActivity {

    @Bind(R.id.explode)
    Button explode;
    @Bind(R.id.slide)
    Button slide;
    @Bind(R.id.fade)
    Button fade;
    @Bind(R.id.share)
    Button share;
    @Bind(R.id.iv)
    ImageView iv;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ButterKnife.bind(this);

        intent = new Intent(this, BActivity.class);



    }

    @OnClick({R.id.explode, R.id.slide, R.id.fade})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.explode:
                intent.putExtra("transition", "explode");
                break;
            case R.id.slide:
                intent.putExtra("transition", "slide");
                break;
            case R.id.fade:
                intent.putExtra("transition", "fade");
                break;
        }
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.share)
    public void onViewClicked() {
        //共享元素

        intent.putExtra("transition", "share");

        //将原先的跳转改成如下方式，注意这里面的第三个参数决定了ActivityTwo 布局中的android:transitionName的值，它们要保持一致
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(ActivityTransitionAActivity.this, share, "shareTransition").toBundle());

    }
}
