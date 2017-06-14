package com.example.demoset.ui.other;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.demoset.R;
import com.example.demoset.adapter.ListItemMultiAdapter;
import com.example.demoset.bean.Bean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MultiXmlListviewActivity extends AppCompatActivity {
    @Bind(R.id.activity_multi_xml_listview_lv)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_xml_listview);
        ButterKnife.bind(this);

        ArrayList<Bean> objects = new ArrayList<Bean>();
        ListItemMultiAdapter adapter = new ListItemMultiAdapter(this,objects);
        listView.setAdapter(adapter);
        for (int i = 0; i < 10; i++) {
            Bean b = new Bean();
            if (i>5){
                b.setType(1);
            }
            objects.add(b);
        }
        adapter.notifyDataSetChanged();


    }
}
