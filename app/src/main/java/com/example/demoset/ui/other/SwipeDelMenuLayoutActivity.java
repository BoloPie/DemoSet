package com.example.demoset.ui.other;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.example.demoset.R;
import com.example.demoset.adapter.SwipeDelMenuAdapter;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeDelMenuLayoutActivity extends AppCompatActivity {


    @Bind(R.id.activity_swipe_del_menu_layout_listview)
    ListView listView;

    ArrayList<String> list;
    SwipeDelMenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_del_menu_layout);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new SwipeDelMenuAdapter(this, list);
        listView.setAdapter(adapter);


        for (int i = 0; i < 10; i++) {
            String text = "折颜" + i;
            list.add(text);
        }
        adapter.notifyDataSetChanged();
    }
}
