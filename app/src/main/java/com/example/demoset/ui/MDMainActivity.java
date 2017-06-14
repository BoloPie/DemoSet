package com.example.demoset.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.ui.md.AppBarLayoutActivity;
import com.example.demoset.ui.md.CardViewActivity;
import com.example.demoset.ui.md.CollapsingToolbarLayoutActivity;
import com.example.demoset.ui.md.DeleteItemActivity;
import com.example.demoset.ui.md.FloatingActionButtonActivity;
import com.example.demoset.ui.md.ItemTouchHelperActivity;
import com.example.demoset.ui.md.LinearLayoutCompatActivity;
import com.example.demoset.ui.md.ListPopupWindowActivity;
import com.example.demoset.ui.md.NavigationDrawerActivity;
import com.example.demoset.ui.md.RecyclerViewLinearActivity;
import com.example.demoset.ui.md.SampleListPopupWindowActivity;
import com.example.demoset.ui.md.SwipeEmpityViewActivity;
import com.example.demoset.ui.md.SwipyRefreshLayoutActivity;
import com.example.demoset.ui.md.TabLayoutActivity;
import com.example.demoset.ui.md.TextInputLayoutActivity;
import com.example.demoset.ui.md.ToolBarActivity;
import com.example.demoset.ui.md.ToolbarSearchActivity;
import com.example.demoset.ui.other.ExpandableListViewActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MDMainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_listview)
    ListView listView;

    Intent intent;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MDMainActivity.this);
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
//        refWatcher.watch(this);

        intent = new Intent();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(MDMainActivity.this, android.R.layout.simple_list_item_1, list);
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
        list.add("TabLayoutActivity");
        list.add("FloatingActionButton");
        list.add("TextInputLayout");
        list.add("NavigationDrawer");
        list.add("AppBarLayout");
        list.add("SampleListPopupWindow");
        list.add("ListPopupWindow");
        list.add("AlertDialog");
        list.add("RecyclerViewLinear");
        list.add("ToolBarActivity");
        list.add("ToolbarSearchActivity");
        list.add("CollapsingToolbarLayout");
        list.add("SwipyRefreshLayout");
        list.add("CardView");
        list.add("LinearLayoutCompatActivity");
        list.add("ItemTouchHelperActivity");
        list.add("DeleteItemActivity");
        list.add("SwipeEmpityViewActivity");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.setClass(MDMainActivity.this, TabLayoutActivity.class);
                        break;
                    case 1:
                        intent.setClass(MDMainActivity.this, FloatingActionButtonActivity.class);
                        break;
                    case 2:
                        intent.setClass(MDMainActivity.this, TextInputLayoutActivity.class);
                        break;
                    case 3:
                        intent.setClass(MDMainActivity.this, NavigationDrawerActivity.class);
                        break;
                    case 4:
                        intent.setClass(MDMainActivity.this, AppBarLayoutActivity.class);
                        break;
                    case 5:
                        intent.setClass(MDMainActivity.this, SampleListPopupWindowActivity.class);
                        break;
                    case 6:
                        intent.setClass(MDMainActivity.this, ListPopupWindowActivity.class);
                        break;
                    case 7:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MDMainActivity.this);
                        builder.setMessage("让我们一起飞，我带着你，你带着钱，来一场说走就走的旅行")
                                .setNegativeButton("取消", null)
                                .setPositiveButton("确定", null)
                                .setTitle("Material Design Dialog")
                                .show();
                        break;
                    case 8:
                        intent.setClass(MDMainActivity.this, RecyclerViewLinearActivity.class);
                        break;
                    case 9:
                        intent.setClass(MDMainActivity.this, ToolBarActivity.class);
                        break;
                    case 10:
                        intent.setClass(MDMainActivity.this, ToolbarSearchActivity.class);
                        break;
                    case 11:
                        intent.setClass(MDMainActivity.this, CollapsingToolbarLayoutActivity.class);
                        break;
                    case 12:
                        intent.setClass(MDMainActivity.this, SwipyRefreshLayoutActivity.class);
                        break;
                    case 13:
                        intent.setClass(MDMainActivity.this, CardViewActivity.class);
                        break;

                    case 14:
                        intent.setClass(MDMainActivity.this, LinearLayoutCompatActivity.class);
                        break;
                    case 15:
                        intent.setClass(MDMainActivity.this, ExpandableListViewActivity.class);
                        break;

                    case 16:
                        intent.setClass(MDMainActivity.this, ItemTouchHelperActivity.class);
                        break;
                    case 17:
                        intent.setClass(MDMainActivity.this, DeleteItemActivity.class);
                        break;
                    case 18:
                        intent.setClass(MDMainActivity.this, SwipeEmpityViewActivity.class);
                        break;


                }
                startActivity(intent);
            }

        });
    }

}
