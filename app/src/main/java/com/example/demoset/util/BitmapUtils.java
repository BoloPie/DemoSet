package com.example.demoset.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 张凌云 on 2017/4/19.
 */

public class BitmapUtils {

    /**
     * 将bitmap保存到本地，spath :生成图片取个名字和路径包含类型
     *
     * @param photo
     * @param spath
     * @return
     */
    public static boolean saveImage(Bitmap photo, String spath) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(spath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * @param context
     * @param selectedImage
     * @return
     */
    public static String uriToString(Context context, Uri selectedImage) {
        String[] filePathColumns = {MediaStore.Images.Media.DATA};
        Cursor c = context.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
        c.moveToFirst();
        int columnIndex = c.getColumnIndex(filePathColumns[0]);
        String imagePath = c.getString(columnIndex);
        c.close();
        return imagePath;
    }

    /**
     * 创建一条图片地址uri,用于保存拍照后的照片
     *
     * @param context
     * @return 图片的uri
     */
    public static Uri createImagePathUri(Context context) {
        Uri imageFilePath = null;
        String status = Environment.getExternalStorageState();
        SimpleDateFormat timeFormatter = new SimpleDateFormat(
                "yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));
        // ContentValues是我们希望这条记录被创建时包含的数据信息
        ContentValues values = new ContentValues(3);
        values.put(MediaStore.Images.Media.DISPLAY_NAME, imageName);
        values.put(MediaStore.Images.Media.DATE_TAKEN, time);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg");
        if (status.equals(Environment.MEDIA_MOUNTED)) {// 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
            imageFilePath = context.getContentResolver().insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        } else {
            imageFilePath = context.getContentResolver().insert(
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI, values);
        }
        Log.i("", "生成的照片输出路径：" + imageFilePath.toString());
        return imageFilePath;
    }


    /**
     * 制作图片的路径地址
     * @param context
     * @return
     */
    public static String createPath(Context context){
        String path = null;
        File file = null;
        long tag = System.currentTimeMillis();
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){//SDCard是否可用
            //最好把images替换成你的项目名称，避免有重复文件夹
            path = Environment.getExternalStorageDirectory() + File.separator +"images/";
            file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            path = Environment.getExternalStorageDirectory() + File.separator +"images/"+ tag + ".png";
        }else{
            path = context.getFilesDir() + File.separator +"images/";
            file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            path = context.getFilesDir() + File.separator +"images/"+ tag + ".png";
        }
        return path;
    }



}
