package com.example.demoset.ui.picture;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.demoset.R;
import com.example.demoset.util.BitmapUtils;
import com.example.demoset.view.ZoomImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 可缩放查看图片，无法长按保存图片
 */
public class PhotoViewerActivity extends AppCompatActivity {

    @Bind(R.id.activity_photo_viewer_iv)
    ZoomImageView zoomImg;

    @Bind(R.id.activity_photo_viewer)
    LinearLayout lay;


    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        ButterKnife.bind(this);

        bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.mipmap.ic_tree);
        zoomImg.setImage(bitmap);


        lay.setOnLongClickListener(new  View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                /*AlertDialog.Builder builder = new AlertDialog.Builder(PhotoViewerActivity.this);
                builder.setMessage("")
                        .setNegativeButton("", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                BitmapUtils.saveImageToGallery(PhotoViewerActivity.this,bitmap);
                            }
                        })
                        .setTitle("")
                        .show();*/
                Toast.makeText(PhotoViewerActivity.this, "我被长按了", Toast.LENGTH_SHORT).show();

                Log.e("---------","长按");

                return false;
            }
        });

//
//        zoomImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PhotoViewerActivity.this, "我被点击", Toast.LENGTH_SHORT).show();
//            }
//        });




    }

    @OnClick(R.id.activity_photo_viewer_save_tv)
    void saveImage(){

        BitmapUtils.saveImageToGallery(this,bitmap);
    }


//    @OnLongClick(R.id.activity_photo_viewer_iv)
//    boolean save(){
//        BitmapUtils.saveImageToGallery(this,bitmap);
//        return false;
//    }

}
