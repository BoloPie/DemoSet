package com.example.demoset.ui.action.api21;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.example.demoset.R;


public class BActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         // 允许使用transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        String transition = getIntent().getStringExtra("transition");
        switch (transition) {
            case "explode":
                // 设置进入时进入动画
                Explode explode = new Explode();
                explode.setDuration(1000);
                getWindow().setEnterTransition(explode);

                break;
            case "slide":
                Slide slide = new Slide();
                slide.setDuration(1000);
                getWindow().setEnterTransition(slide);

                break;

            case "fade":
                Fade fade = new Fade();
                fade.setDuration(1000);
                getWindow().setEnterTransition(fade);

                break;

            case "share":
                break;
        }

        setContentView(R.layout.activity_b);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(this);
    }

}
