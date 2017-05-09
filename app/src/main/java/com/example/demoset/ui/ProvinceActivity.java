package com.example.demoset.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demoset.R;
import com.lljjcoder.citypickerview.widget.CityPicker;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProvinceActivity extends AppCompatActivity {
    CityPicker cityPicker;

    @Bind(R.id.activity_province_btn)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        ButterKnife.bind(this);

          cityPicker = new CityPicker.Builder(ProvinceActivity.this)
                .textSize(20)
                .title("地址选择")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#F0F0F0")
                .titleTextColor("#0053BB")
                .backgroundPop(0xa0000000)
                .confirTextColor("#0053BB")
                .cancelTextColor("#0053BB")
                .province("江苏省")
                .city("常州市")
                .district("天宁区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(true)
                .build();


        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                btn.setText(province +city);
            }

            @Override
            public void onCancel() {
                Toast.makeText(ProvinceActivity.this, "已取消", Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick(R.id.activity_province_btn)
    void go(){
        cityPicker.show();
    }
}
