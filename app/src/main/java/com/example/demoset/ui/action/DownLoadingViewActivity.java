package com.example.demoset.ui.action;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.demoset.R;
import com.gastudio.downloadloadding.library.GADownloadingView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownLoadingViewActivity extends AppCompatActivity {

    @Bind(R.id.ga_downloading)
    GADownloadingView downloadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_loading_view);
        ButterKnife.bind(this);

        downloadingView.performAnimation();
        downloadingView.updateProgress(100);
//        downloadingView.onFail();


        downloadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    downloadingView.performAnimation();
                    downloadingView.updateProgress(100);
            }
        });

    }
}
