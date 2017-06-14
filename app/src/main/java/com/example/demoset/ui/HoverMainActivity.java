package com.example.demoset.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.ui.hover.FloatingActivity;
import com.example.demoset.ui.hover.HoverActivity;
import com.example.demoset.ui.hover.StickyScrollActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HoverMainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(HoverMainActivity.this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(HoverMainActivity.this, android.R.layout.simple_list_item_1, list);
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
        list.add("FloatingActivity");
        list.add("HoverActivity");
        list.add("StickyScrollActivity");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(HoverMainActivity.this, HoverActivity.class);
                        break;
                    case 1:
                        intent.setClass(HoverMainActivity.this, StickyScrollActivity.class);
                        break;
                    case 2:
                        intent.setClass(HoverMainActivity.this, FloatingActivity.class);
                        break;

                }
                startActivity(intent);
            }

        });
    }

}
