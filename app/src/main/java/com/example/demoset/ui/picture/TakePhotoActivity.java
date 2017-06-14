package com.example.demoset.ui.picture;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demoset.R;
import com.example.demoset.util.BitmapUtils;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TakePhotoActivity extends AppCompatActivity implements TakePhoto.TakeResultListener,InvokeListener {

    private final String TAG = "TakePhotoActivity";

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
//    private Uri outPutUri;//图片保存路径
    private CompressConfig compressConfig;
    private CropOptions cropOptions;

    @Bind(R.id.activity_take_photo_iv)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ButterKnife.bind(this);


        // 初始化相关的代码

        takePhoto = getTakePhoto();
//        Uri  outPutUri = BitmapUtils.createImagePathUri(this);//图片存储路径
        compressConfig = new CompressConfig.Builder().setMaxSize(1800 * 1800).setMaxPixel(800).create();
        cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
        takePhoto.onCreate(savedInstanceState);


    }

    @OnClick(R.id.activity_take_photo_select_btn)
    void select(){
        //选择图片
        takePhoto.onEnableCompress(compressConfig, true);
        /**
         * 从文件中获取图片（不裁剪）
         */
//        takePhoto.onPickFromGallery();

        /**
         * 从相机获取图片并裁剪
         * @param outPutUri 图片裁剪之后保存的路径
         * @param options 裁剪配置
         */
//        Uri  outPutUri = BitmapUtils.createImagePathUri(this);//图片存储路径
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        takePhoto.onPickFromGalleryWithCrop(imageUri,cropOptions);
    }

    @OnClick(R.id.activity_take_photo_take_btn)
    void take(){
        //拍照片
        takePhoto.onEnableCompress(compressConfig, true);
        /**
         * 从相机获取图片(不裁剪)
         * @param outPutUri 图片保存的路径
         */
//        takePhoto.onPickFromCapture(outPutUri);

        /**
         * 从相册中获取图片并裁剪
         * @param outPutUri 图片裁剪之后保存的路径
         * @param options 裁剪配置
         */
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        takePhoto.onPickFromCaptureWithCrop(imageUri, cropOptions);

    }


/************************* 以下 takePhoto 相关*****************************/

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    takePhoto.onActivityResult(requestCode, resultCode, data);
    super.onActivityResult(requestCode, resultCode, data);
}
@Override
    protected void onSaveInstanceState(Bundle outState) {
        takePhoto.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }




    @Override
    public void takeSuccess(TResult result) {
        Log.i(TAG, "takeSuccess：" + result.getImage().getCompressPath());
        TImage image = result.getImage();
        image.getCompressPath();//压缩图片路径

        Glide.with(this).load(new File(image.getCompressPath())).into(imageView);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Log.i(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        Log.i(TAG, getResources().getString(com.jph.takephoto.R.string.msg_operation_canceled));
    }

    /**
     *  获取TakePhoto实例
     * @return
     */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        return takePhoto;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //以下代码为处理Android6.0、7.0动态权限所需
        PermissionManager.TPermissionType type=PermissionManager.onRequestPermissionsResult(requestCode,permissions,grantResults);
        PermissionManager.handlePermissionsResult(this,type,invokeParam,this);
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }
}
