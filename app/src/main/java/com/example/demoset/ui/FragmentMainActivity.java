package com.example.demoset.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.ui.fragment.DynamicFragmentActivity;
import com.example.demoset.ui.fragment.FragmentViewPagerActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentMainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(FragmentMainActivity.this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(FragmentMainActivity.this, android.R.layout.simple_list_item_1, list);
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
        list.add("DynamicFragmentActivity");
        list.add("FragmentViewPagerActivity");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(FragmentMainActivity.this, DynamicFragmentActivity.class);
                        break;
                    case 1:
                        intent.setClass(FragmentMainActivity.this, FragmentViewPagerActivity.class);
                        break;


                }
                startActivity(intent);
            }

        });
    }

}
