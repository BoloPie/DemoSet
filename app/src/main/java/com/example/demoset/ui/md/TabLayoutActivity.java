package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoset.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TabLayoutActivity extends AppCompatActivity {

    @Bind(R.id.sliding_tabs)
    TabLayout mTabLayout;

    ArrayList<String> titles;
    ArrayList<String> nums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0:
                         break;
                 }
                changeTabSelect(tab.getPosition());
                Toast.makeText(TabLayoutActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //设置分割线
        LinearLayout linearLayout = (LinearLayout) mTabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.shape_divider_gray_vertical));

        String text = "谁冷漠了春天";
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_black_87)), 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 3, text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

//        TextView tv = (TextView)mTabLayout.getChildAt(0);
//        tv.setText(spannable);

        titles = new ArrayList<>();
        titles.add("未处理");
        titles.add("待确认");
        titles.add("已完成");
        titles.add("池塘水");
        titles.add("猪脚丫");

        nums = new ArrayList<>();
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");


        setTabs();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    /**
     * 设置tab
     */
    private void setTabs(){
        mTabLayout.getTabAt(0).setCustomView(getTabView(0));
        mTabLayout.getTabAt(1).setCustomView(getTabView(1));
        mTabLayout.getTabAt(2).setCustomView(getTabView(2));
        mTabLayout.getTabAt(3).setCustomView(getTabView(3));
        mTabLayout.getTabAt(4).setCustomView(getTabView(4));
    }

    /** 单个tab的显示样式
     * @param position
     * @return
     */
    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tablayout_layout, null);
        TextView txt_title = (TextView) view.findViewById(R.id.item_tablayout_layout_tab_tv);
        TextView txt_num = (TextView) view.findViewById(R.id.item_tablayout_layout_num_tv);
        txt_title.setText(titles.get(position));
        txt_num.setText(nums.get(position));
//        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
//        img_title.setImageResource(tabIcons[position]);

        switch (position) {
            case 0:
                txt_num.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                txt_num.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 2:
                txt_num.setTextColor(getResources().getColor(R.color.colorSecondary_100));
                break;
            case 3:
                txt_num.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 4:
                txt_num.setTextColor(getResources().getColor(R.color.colorSecondary_100));
                break;
        }
//        if (position == 0) {
//            txt_title.setTextColor(Color.YELLOW);
//            img_title.setImageResource(tabIconsPressed[position]);
//        } else {
//            txt_title.setTextColor(Color.WHITE);
//            img_title.setImageResource(tabIcons[position]);
//        }
        return view;
    }

    private void changeTabSelect(int position) {
        View view = mTabLayout.getTabAt(position).getCustomView();
        TextView txt_num = (TextView) view.findViewById(R.id.item_tablayout_layout_num_tv);
        txt_num.setTextColor(getResources().getColor(R.color.colorAccent));
    }


}
