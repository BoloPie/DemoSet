package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demoset.R;
import com.example.demoset.adapter.PopListAdapter;
import com.example.demoset.bean.PopListBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListPopupWindowActivity extends AppCompatActivity {

    @Bind(R.id.list_pop_window)
    EditText editText;
    @Bind(R.id.list_pop_window_tv)
    TextView textView;


    private ListPopupWindow mListPop;
//    private List<String> lists = new ArrayList<String>();

    ArrayList<PopListBean> list;
    PopListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_popup_window);
        ButterKnife.bind(this);


        list = new ArrayList<>();
        adapter = new PopListAdapter(this, list);
//        lists.add("one");
//        lists.add("two");
//        lists.add("three");
        for (int i = 0; i < 5; i++) {
            PopListBean bean = new PopListBean();
            bean.setName("" + i);
            list.add(bean);
        }

        adapter.notifyDataSetChanged();


        mListPop = new ListPopupWindow(this);
        mListPop.setAdapter(adapter);


//        bindET();
        bindTV();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void bindTV() {

        mListPop.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
        mListPop.setHeight(200);//ActionBar.LayoutParams.WRAP_CONTENT
        mListPop.setAnchorView(textView);//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        mListPop.setModal(true);//设置是否是模式

        mListPop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(list.get(i).getName());
                mListPop.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPop.show();
            }
        });
    }

    private void bindET() {

        int width = editText.getLayoutParams().width;
        mListPop.setWidth(ActionBar.LayoutParams.WRAP_CONTENT);
        mListPop.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        mListPop.setAnchorView(editText);//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        mListPop.setModal(true);//设置是否是模式

        mListPop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(list.get(i).getName());
                mListPop.dismiss();
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPop.show();
            }
        });
    }

}
