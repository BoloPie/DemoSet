package com.example.demoset.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.demoset.R;
import com.example.demoset.view.ObservableScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StickyScrollActivity extends AppCompatActivity implements ObservableScrollView.Callbacks {
    @Bind(R.id.activity_sticky_scroll)
    ObservableScrollView observableScrollView;
    @Bind(R.id.placeholder)
    View placeholderView;
    @Bind(R.id.top)
    View topView;
    @Bind(R.id.sticky)
    TextView stickyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_scroll);
        ButterKnife.bind(this);

        observableScrollView.setCallbacks(this);
        observableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        onScrollChanged(observableScrollView.getScrollY());
                    }
                });

        stickyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topView.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void onScrollChanged(int scrollY) {
        stickyView.setTranslationY(Math.max(placeholderView.getTop(), scrollY));
    }

    @Override
    public void onDownMotionEvent() {
        topView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUpOrCancelMotionEvent() {
        topView.setVisibility(View.VISIBLE);
    }
}
