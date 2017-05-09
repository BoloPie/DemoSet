package com.example.demoset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.md.AppBarLayoutActivity;
import com.example.demoset.md.CardViewActivity;
import com.example.demoset.md.CollapsingToolbarLayoutActivity;
import com.example.demoset.md.DeleteItemActivity;
import com.example.demoset.md.FloatingActionButtonActivity;
import com.example.demoset.md.ItemTouchHelperActivity;
import com.example.demoset.md.LinearLayoutCompatActivity;
import com.example.demoset.md.ListPopupWindowActivity;
import com.example.demoset.md.NavigationDrawerActivity;
import com.example.demoset.md.RecyclerViewLinearActivity;
import com.example.demoset.md.SampleListPopupWindowActivity;
import com.example.demoset.md.SwipeEmpityViewActivity;
import com.example.demoset.md.SwipyRefreshLayoutActivity;
import com.example.demoset.md.TabLayoutActivity;
import com.example.demoset.md.TextInputLayoutActivity;
import com.example.demoset.md.ToolBarActivity;
import com.example.demoset.md.ToolbarSearchActivity;
import com.example.demoset.ui.ActionBarActivity;
import com.example.demoset.ui.DynamicFragmentActivity;
import com.example.demoset.ui.ExpandableListViewActivity;
import com.example.demoset.ui.FragmentViewPagerActivity;
import com.example.demoset.ui.HoverActivity;
import com.example.demoset.ui.ProvinceActivity;
import com.example.demoset.ui.SpannableStringActivity;
import com.example.demoset.ui.StickyScrollActivity;
import com.example.demoset.ui.SwipeDelMenuLayoutActivity;
import com.squareup.leakcanary.RefWatcher;

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
        list.add("SwipyRefreshLayout");
        list.add("CardView");
        list.add("SpannableString");
        list.add("ActionBarActivity");
        list.add("LinearLayoutCompatActivity");
        list.add("ExpandableListViewActivity");
        list.add("ProvinceActivity");
        list.add("ItemTouchHelperActivity");
        list.add("DeleteItemActivity");
        list.add("SwipeDelMenuLayoutActivity");
        list.add("HoverActivity");
        list.add("DynamicFragmentActivity");
        list.add("FragmentViewPagerActivity");
        list.add("SwipeEmpityViewActivity");
        list.add("StickyScrollActivity");


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
                        intent.setClass(MainActivity.this, SwipyRefreshLayoutActivity.class);
                        break;
                    case 13:
                        intent.setClass(MainActivity.this, CardViewActivity.class);
                        break;
                    case 14:
                        intent.setClass(MainActivity.this, SpannableStringActivity.class);
                        break;
                    case 15:
                        intent.setClass(MainActivity.this, ActionBarActivity.class);
                        break;
                    case 16:
                        intent.setClass(MainActivity.this, LinearLayoutCompatActivity.class);
                        break;
                    case 17:
                        intent.setClass(MainActivity.this, ExpandableListViewActivity.class);
                        break;
                    case 18:
                        intent.setClass(MainActivity.this, ProvinceActivity.class);
                        break;
                    case 19:
                        intent.setClass(MainActivity.this, ItemTouchHelperActivity.class);
                        break;
                    case 20:
                        intent.setClass(MainActivity.this, DeleteItemActivity.class);
                        break;
                    case 21:
                        intent.setClass(MainActivity.this, SwipeDelMenuLayoutActivity.class);
                        break;
                    case 22:
                        intent.setClass(MainActivity.this, HoverActivity.class);
                        break;
                    case 23:
                        intent.setClass(MainActivity.this, DynamicFragmentActivity.class);
                        break;
                    case 24:
                        intent.setClass(MainActivity.this, FragmentViewPagerActivity.class);
                        break;
                    case 25:
                        intent.setClass(MainActivity.this, SwipeEmpityViewActivity.class);
                        break;
                    case 26:
                        intent.setClass(MainActivity.this, StickyScrollActivity.class);
                        break;



                }
                startActivity(intent);
            }

        });
    }



}
