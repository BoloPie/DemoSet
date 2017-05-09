package com.example.demoset.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.adapter.CardviewAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CardViewActivity extends AppCompatActivity {

    @Bind(R.id.activity_card_view_listview)
    ListView listView;

    ArrayList<CardviewAdapter.Bean> list;
    CardviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new CardviewAdapter(this,list);
        listView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            CardviewAdapter.Bean bean = new CardviewAdapter.Bean();
            bean.setName("野花"+i);
            list.add(bean);
        }
        adapter.notifyDataSetChanged();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
