package com.example.demoset.ui.action;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.ui.action.api21.ActivityTransitionAActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActionMainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(ActionMainActivity.this);


        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(ActionMainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);

    }

    private void initData() {
        list.add("第三方动画适用Android 2.2+");
        list.add("DownLoadingViewActivity");
        list.add("ScenesTransitionsActivity");
        list.add("Activity转场动画 api21以上");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(ActionMainActivity.this, ScenesTransitionsActivity.class);
                        break;
                    case 1:
                        intent.setClass(ActionMainActivity.this, ActionMenuActivity.class);
                        break;
                    case 2:
                        intent.setClass(ActionMainActivity.this, DownLoadingViewActivity.class);
                        break;
                    case 3:
                        intent.setClass(ActionMainActivity.this, ActivityTransitionAActivity.class);
                        break;

                }
                startActivity(intent);
            }

        });
    }

}
