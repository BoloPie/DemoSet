package com.example.demoset.helper;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demoset.R;


/**
 * Created by 张凌云 on 2017/5/9.
 */

public class EmptyViewHelper {
    private ListView mListView;
    private View emptyView;
    private Context mContext;
    private String mEmptyText;
    private TextView mTextView;
    private FrameLayout parent;

    public EmptyViewHelper(ListView listView, String text) {
        mListView = listView;
        mContext = listView.getContext();
        mEmptyText = text;
        initEmptyView();
    }

    public EmptyViewHelper(ListView listView, String text, FrameLayout parent) {
        mListView = listView;
        mContext = listView.getContext();
        mEmptyText = text;
        this.parent = parent;
        initEmptyView();
    }

    private void initEmptyView() {
        emptyView = View.inflate(mContext, R.layout.empty_view, null);

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);

        parent.addView(emptyView, lp);

        mListView.setEmptyView(emptyView);

        if (!TextUtils.isEmpty(mEmptyText)) {
            ((TextView) emptyView.findViewById(R.id.textview))
                    .setText(mEmptyText);
        }
    }
}
