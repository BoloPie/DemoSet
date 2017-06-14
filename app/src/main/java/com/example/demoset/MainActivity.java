package com.example.demoset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.ui.FragmentMainActivity;
import com.example.demoset.ui.HoverMainActivity;
import com.example.demoset.ui.MDMainActivity;
import com.example.demoset.ui.other.ActionBarActivity;
import com.example.demoset.ui.other.ExpandableListViewActivity;
import com.example.demoset.ui.other.MultiXmlListviewActivity;
import com.example.demoset.ui.PictureMainActivity;
import com.example.demoset.ui.dialog.LoadingDialogActivity;
import com.example.demoset.ui.support.PaletteActivity;
import com.example.demoset.ui.other.ProvinceActivity;
import com.example.demoset.ui.qr.QRActivity;
import com.example.demoset.ui.other.RatingBarActivity;
import com.example.demoset.ui.action.ActionMainActivity;
import com.example.demoset.ui.http.RetrofitActivity;
import com.example.demoset.ui.other.SpannableStringActivity;
import com.example.demoset.ui.other.SwipeDelMenuLayoutActivity;
import com.example.demoset.ui.http.RetrofitRxjavaActivity;
import com.example.demoset.ui.login.LoginActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);
    }

    private void initData() {
        list.add("MD相关页面");
        list.add("FragmentMainActivity");
        list.add("悬浮实现");
        list.add("照片相关");
        list.add("SpannableString");
        list.add("ActionBarActivity");
        list.add("二级列表");
        list.add("省市选择");
        list.add("listview左滑删除");
        list.add("二维码");
        list.add("登陆");
        list.add("五星评价");
        list.add("多布局listview");
        list.add("LoadingDialogActivity");
        list.add("Retrofit网络加载");
        list.add("RetrofitRxjava网络加载");
        list.add("ActionMain动态效果");
        list.add("获取图片颜色并使用");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(MainActivity.this, MDMainActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, FragmentMainActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, HoverMainActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this, PictureMainActivity.class);
                        break;

                    case  4:
                        intent.setClass(MainActivity.this, SpannableStringActivity.class);
                        break;
                    case  5:
                        intent.setClass(MainActivity.this, ActionBarActivity.class);
                        break;

                    case 6:
                        intent.setClass(MainActivity.this, ExpandableListViewActivity.class);
                        break;
                    case 7:
                        intent.setClass(MainActivity.this, ProvinceActivity.class);
                        break;
                    case 8:
                        intent.setClass(MainActivity.this, SwipeDelMenuLayoutActivity.class);
                        break;

                    case 9:
                        intent.setClass(MainActivity.this, QRActivity.class);
                        break;
                    case 10:
                        intent.setClass(MainActivity.this, LoginActivity.class);
                        break;

                    case 11:
                        intent.setClass(MainActivity.this, RatingBarActivity.class);
                        break;
                    case 12:
                        intent.setClass(MainActivity.this, MultiXmlListviewActivity.class);
                        break;

                    case 13:
                        intent.setClass(MainActivity.this, LoadingDialogActivity.class);
                        break;
                    case 14:
                        intent.setClass(MainActivity.this, RetrofitActivity.class);
                        break;
                    case 15:
                        intent.setClass(MainActivity.this, RetrofitRxjavaActivity.class);
                        break;

                    case 16:
                        intent.setClass(MainActivity.this, ActionMainActivity.class);
                        break;
                    case 17:
                        intent.setClass(MainActivity.this, PaletteActivity.class);
                        break;


                }
                startActivity(intent);
            }

        });
    }



}
