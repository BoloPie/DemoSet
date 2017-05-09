package com.example.demoset.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpannableStringActivity extends AppCompatActivity {
    @Bind(R.id.activity_spannable_string_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string);
        ButterKnife.bind(this);

        String text = "谁冷漠了春天";
        Spannable spannable = new SpannableString(text);

        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_black_87)), 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 3,text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(spannable);
    }
}
