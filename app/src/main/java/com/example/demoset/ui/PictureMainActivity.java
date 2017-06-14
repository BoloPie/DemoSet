package com.example.demoset.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.MainActivity;
import com.example.demoset.R;
import com.example.demoset.ui.fragment.DynamicFragmentActivity;
import com.example.demoset.ui.fragment.FragmentViewPagerActivity;
import com.example.demoset.ui.picture.CapturePictureActivity;
import com.example.demoset.ui.picture.PhotoViewerActivity;
import com.example.demoset.ui.picture.PhotoViewerSaveActivity;
import com.example.demoset.ui.picture.TakePhotoActivity;
import com.example.demoset.ui.picture.TranslateImageActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PictureMainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(PictureMainActivity.this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(PictureMainActivity.this, android.R.layout.simple_list_item_1, list);
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
        list.add("TakePhotoActivity");
        list.add("PhotoViewerActivity");
        list.add("PhotoViewerSaveActivity");
        list.add("TranslateImageActivity");
        list.add("CapturePictureActivity");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(PictureMainActivity.this, TakePhotoActivity.class);
                        break;
                    case 1:
                        intent.setClass(PictureMainActivity.this, PhotoViewerActivity.class);
                        break;
                    case 2:
                        intent.setClass(PictureMainActivity.this, PhotoViewerSaveActivity.class);
                        break;
                    case 3:
                        intent.setClass(PictureMainActivity.this, TranslateImageActivity.class);
                        break;
                    case 4:
                        intent.setClass(PictureMainActivity.this, CapturePictureActivity.class);
                        break;


                }
                startActivity(intent);
            }

        });
    }

}
