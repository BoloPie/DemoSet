package com.example.demoset.ui.support;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demoset.R;
import com.example.demoset.view.photoview.PhotoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PaletteActivity extends AppCompatActivity {

    @Bind(R.id.activity_palette_one_tv)
    TextView oneTv;
    @Bind(R.id.activity_palette_t_tv)
    TextView tTv;
    @Bind(R.id.activity_palette_th_tv)
    TextView thTv;
    @Bind(R.id.activity_palette_f_tv)
    TextView fTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_tree_home);
//        Palette palette = Palette.generate(bitmap);// 此方法可能会阻塞主线程，建议使用异步方法
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 有活力的颜色
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                // 有活力的暗色
                Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
                // 有活力的亮色
                Palette.Swatch lightVibrant = palette.getLightVibrantSwatch();
                // 柔和的颜色
                Palette.Swatch muted = palette.getMutedSwatch();
                // 柔和的暗色
                Palette.Swatch darkMuted = palette.getDarkMutedSwatch();
                // 柔和的亮色
                Palette.Swatch lightMuted = palette.getLightMutedSwatch();

                // 使用颜色
                // 修改Actionbar背景颜色
//                getActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));

//                oneTv.setBackground(ContextCompat.getDrawable(PaletteActivity.this,vibrant.getRgb()));
                oneTv.setBackground(new ColorDrawable(vibrant.getRgb()));
                tTv.setBackground(new ColorDrawable(darkVibrant.getRgb()));
                thTv.setBackground(new ColorDrawable(muted.getRgb()));
                fTv.setBackground(new ColorDrawable(darkMuted.getRgb()));
                // 修改文字的颜色
//                oneTv.setTextColor(vibrant.getTitleTextColor());
//                oneTv.setTextColor(darkVibrant.getTitleTextColor());
//                oneTv.setTextColor(muted.getTitleTextColor());
//                oneTv.setTextColor(darkMuted.getTitleTextColor());


//                getPopulation(): 样本中的像素数量
//                getRgb(): 颜色的RBG值
//                getHsl(): 颜色的HSL值
//                getBodyTextColor(): 主体文字的颜色值
//                getTitleTextColor(): 标题文字的颜色值
            }
        });

    }
}
