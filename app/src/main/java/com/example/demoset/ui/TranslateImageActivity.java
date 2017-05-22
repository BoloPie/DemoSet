package com.example.demoset.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TranslateImageActivity extends AppCompatActivity {


    @Bind(R.id.activity_translate_image_iv)
    ImageView imageIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_image);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_translate_image_iv)
    void translate(){
        Intent intent = new Intent(this,PhotoViewerSaveActivity.class);

        startActivity(intent);
//Thumbnail zoom
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);


//        View sharedView = imageIv;
//        String transitionName = getString(R.string.photo_view);
//
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                (Activity)this,new Pair<>(sharedView,transitionName));
//        ActivityCompat.startActivity( (Activity)this,intent,options.toBundle());

    }
}
