package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FloatingActionButtonActivity extends AppCompatActivity {


    @Bind(R.id.activity_floating_action_button)
    RelativeLayout activityFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.fab)
    public void goFloatingActionButton() {

//        Snackbar的使用
        Snackbar.make(activityFloatingActionButton, "Snackbar comes out", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                FloatingActionButtonActivity.this,
                                "Toast comes out",
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
