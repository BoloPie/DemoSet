package com.example.demoset.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.demoset.R;
import com.example.demoset.util.QRCodeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QRActivity extends AppCompatActivity {

    @Bind(R.id.activity_qr_iv)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        ButterKnife.bind(this);

//        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("https://www.baidu.com?id=&name=", 480, 480);
//        mImageView.setImageBitmap(mBitmap);

        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Bitmap mBitmap = QRCodeUtils.createQRImageWithLogo("https://www.baidu.com?username=&phone=", 480, 480,logo);
        mImageView.setImageBitmap(mBitmap);

    }
}
