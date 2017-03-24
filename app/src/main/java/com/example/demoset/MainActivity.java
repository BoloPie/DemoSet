package com.example.demoset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        list.add("TabLayout");
        list.add("FloatingActionButton");
        list.add("TextInputLayout");
        list.add("NavigationDrawer");
        list.add("AppBarLayout");
        list.add("SampleListPopupWindow");
        list.add("ListPopupWindow");
        list.add("AlertDialog");
        list.add("RecyclerViewLinear");
        list.add("ToolBar");
        list.add("ToolbarSearch");
        list.add("CollapsingToolbarLayout");
        list.add("TabLayout");
        list.add("TabLayout");
        list.add("TabLayout");
        list.add("TabLayout");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(MainActivity.this, TabLayoutActivity.class);
                      
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, FloatingActionButtonActivity.class);
                      
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, TextInputLayoutActivity.class);
                      
                        break;
                    case 3:
                        intent.setClass(MainActivity.this, NavigationDrawerActivity.class);
                      
                        break;
                    case 4:
                        intent.setClass(MainActivity.this, AppBarLayoutActivity.class);
                      
                        break;
                    case 5:
                        intent.setClass(MainActivity.this, SampleListPopupWindowActivity.class);
                      
                        break;
                    case 6:
                        intent.setClass(MainActivity.this, ListPopupWindowActivity.class);
                      
                        break;
                    case 7:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("让我们一起飞，我带着你，你带着钱，来一场说走就走的旅行")
                                .setNegativeButton("取消", null)
                                .setPositiveButton("确定", null)
                                .setTitle("Material Design Dialog")
                                .show();
                        break;
                    case 8:
                        intent.setClass(MainActivity.this, RecyclerViewLinearActivity.class);
                      
                        break;
                    case 9:
                        intent.setClass(MainActivity.this, ToolBarActivity.class);
                      
                        break;
                    case 10:
                        intent.setClass(MainActivity.this, ToolbarSearchActivity.class);
                      
                        break;
                    case 11:
                        intent.setClass(MainActivity.this, CollapsingToolbarLayoutActivity.class);
                        break;
                    case 12:

                        break;
                    case 13:

                        break;
                    case 14:

                        break;
                    case 15:

                        break;
                    case 16:

                        break;
                    case 17:

                        break;



                }
                startActivity(intent);
            }

        });
    }



}
