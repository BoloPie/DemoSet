package com.example.demoset.ui.action;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoset.R;
import com.lilei.springactionmenu.ActionMenu;
import com.lilei.springactionmenu.OnActionItemClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActionMenuActivity extends AppCompatActivity {

    @Bind(R.id.activity_action_menu_actionMenu)
    ActionMenu actionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_menu);
        ButterKnife.bind(this);

        // add menu items
        actionMenu.addView(R.drawable.search, ContextCompat.getColor(this,R.color.color_red_A100), ContextCompat.getColor(this,R.color.color_indigo_500));
        actionMenu.addView(R.drawable.like, ContextCompat.getColor(this,R.color.color_teal_300), ContextCompat.getColor(this,R.color.color_red_300));
        actionMenu.addView(R.drawable.write);

        actionMenu.setItemClickListener(new OnActionItemClickListener() {
            @Override
            public void onItemClick(int index) {

            }

            @Override
            public void onAnimationEnd(boolean isOpen) {

            }
        });
    }
}
