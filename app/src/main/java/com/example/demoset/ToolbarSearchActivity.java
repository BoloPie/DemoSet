package com.example.demoset;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ToolbarSearchActivity extends AppCompatActivity {

    @Bind(R.id.activity_toolbar_search_toolbar)
    Toolbar mToolbar;


    @Bind(R.id.activity_toolbar_search_et)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_search);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationIcon(R.mipmap.back);//设置导航栏图标
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        mToolbar.setTitle("主标题");//设置主标题
//        mToolbar.setSubtitle("子标题");//设置子标题

        mToolbar.inflateMenu(R.menu.menu_toolbar_search);//设置右上角的填充菜单
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://返回按钮
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //menu监听
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_search:
                    Toast.makeText(ToolbarSearchActivity.this, "search--"+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;

            }
            return true;
        }
    };
}
