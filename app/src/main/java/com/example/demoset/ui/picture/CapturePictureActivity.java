package com.example.demoset.ui.picture;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demoset.R;

import java.io.File;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CapturePictureActivity extends AppCompatActivity {


    private static final int REQUEST_CODE_CAPTURE_CAMEIA = 1;
    private static final int REQUEST_CAPTURE = 2;
    private static final int REQUEST_PICTURE = 5;
    private static final int REVERSAL_LEFT = 3;
    private static final int REVERSAL_UP = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_picture);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_capture_picture_take_photo_btn)
    void takePhoto(){


    }
    @OnClick(R.id.activity_capture_picture_select_photo_btn)
    void selectPhoto(){


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA ) {
            Uri uri = data.getData();
            if(uri == null){
                //uri为空，通过bundle获取图片数据
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    Bitmap photo = (Bitmap) bundle.get("data"); //get bitmap
                    //将bitmap保存到本地，spath :生成图片取个名字和路径包含类型
//                    saveImage(Bitmap photo, String spath);
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    return;
                }
            }else{
                //通过uri来获取图片并处理
//                Uri selectedImage = data.getData();
//                String[] filePathColumns = {MediaStore.Images.Media.DATA};
//                Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
//                c.moveToFirst();
//                int columnIndex = c.getColumnIndex(filePathColumns[0]);
//                String imagePath = c.getString(columnIndex);
//                showImage(imagePath);
//                c.close();
            }


        }
    }

    protected void getImageFromCamera() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE_CAMEIA);
        }
        else {
            Toast.makeText(getApplicationContext(), "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }
}
