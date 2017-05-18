package com.example.demoset.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.demoset.R;
import com.example.demoset.util.BitmapUtils;
import com.example.demoset.view.photoview.PhotoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhotoViewerSaveActivity extends AppCompatActivity {

    @Bind(R.id.activity_photo_viewer_save_wv)
    PhotoView photoView;

    String url = "http://47.93.10.79:8080/images/20170511/149448624804959310/1494486316847.jpg";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer_save);
        ButterKnife.bind(this);


//        photoView.setImageResource(url);
//        photoView.

        Glide.with(PhotoViewerSaveActivity.this).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                photoView.setImageBitmap(resource);
            }
        });

        photoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(PhotoViewerSaveActivity.this)
                        .setMessage("保存图片")
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                BitmapDrawable drawable = (BitmapDrawable) photoView.getDrawable();
                                if (drawable != null) {
                                    BitmapUtils.saveImageToGallery(PhotoViewerSaveActivity.this,drawable.getBitmap());
                                }

                            }
                        })
                        .setNegativeButton("取消", null)
                        .create()
                        .show();
                return false;
            }
        });
    }
}
