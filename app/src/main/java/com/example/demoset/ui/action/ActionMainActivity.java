package com.example.demoset.ui.action;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demoset.MainActivity;
import com.example.demoset.R;
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
import com.example.demoset.ui.FloatingActivity;
import com.example.demoset.ui.FragmentViewPagerActivity;
import com.example.demoset.ui.HoverActivity;
import com.example.demoset.ui.LoadingDialogActivity;
import com.example.demoset.ui.MultiXmlListviewActivity;
import com.example.demoset.ui.PhotoViewerActivity;
import com.example.demoset.ui.PhotoViewerSaveActivity;
import com.example.demoset.ui.ProvinceActivity;
import com.example.demoset.ui.QRActivity;
import com.example.demoset.ui.RatingBarActivity;
import com.example.demoset.ui.SpannableStringActivity;
import com.example.demoset.ui.StickyScrollActivity;
import com.example.demoset.ui.SwipeDelMenuLayoutActivity;
import com.example.demoset.ui.TakePhotoActivity;
import com.example.demoset.ui.TranslateImageActivity;
import com.example.demoset.ui.http.RetrofitActivity;
import com.example.demoset.ui.http.RetrofitRxjavaActivity;
import com.example.demoset.ui.login.LoginActivity;

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
        list.add("ActionMenuActivity");
        list.add("DownLoadingViewActivity");
        list.add("ScenesTransitionsActivity");


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

                }
                startActivity(intent);
            }

        });
    }

}
