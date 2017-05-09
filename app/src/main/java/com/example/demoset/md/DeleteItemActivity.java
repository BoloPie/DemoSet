package com.example.demoset.md;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.demoset.R;
import com.example.demoset.adapter.AdanceItemTouchAdapter;
import com.example.demoset.adapter.NormalAdapter;
import com.example.demoset.helper.AdvancedItemTouchHelper;
import com.example.demoset.helper.SimpleItemTouchHelper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeleteItemActivity extends AppCompatActivity {



    @Bind(R.id.activity_delete_item_recycler)
    RecyclerView recyclerView;
    AdanceItemTouchAdapter adapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        adapter = new AdanceItemTouchAdapter(list);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        //设置左滑删除
        AdvancedItemTouchHelper advancedItemTouchHelper = new AdvancedItemTouchHelper(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(advancedItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new NormalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {

            }
        });


        //假数据
        for (int i = 0; i < 10 ; i++) {
            list.add(String.valueOf(i));
        }
        adapter.notifyDataSetChanged();

    }

}
