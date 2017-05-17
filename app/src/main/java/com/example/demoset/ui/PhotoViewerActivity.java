package com.example.demoset.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.demoset.R;
import com.example.demoset.util.BitmapUtils;
import com.example.demoset.view.ZoomImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoViewerActivity extends AppCompatActivity {

    @Bind(R.id.activity_photo_viewer_iv)
    ZoomImageView zoomImg;

    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        ButterKnife.bind(this);

        bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.mipmap.ic_tree);
        zoomImg.setImage(bitmap);

    }

    @OnClick(R.id.activity_photo_viewer_save_tv)
    void saveImage(){

        BitmapUtils.saveImageToGallery(this,bitmap);
    }

}
