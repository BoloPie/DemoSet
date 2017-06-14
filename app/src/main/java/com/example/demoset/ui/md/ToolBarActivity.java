package com.example.demoset.ui.md;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ToolBarActivity extends AppCompatActivity {

    @Bind(R.id.activity_tool_bar_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationIcon(R.mipmap.back);//设置导航栏图标
//        mToolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        mToolbar.setTitle("主标题");//设置主标题
        mToolbar.setSubtitle("子标题");//设置子标题

        mToolbar.inflateMenu(R.menu.menu_toolbar);//设置右上角的填充菜单
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
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
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }

            if (!msg.equals("")) {
                Toast.makeText(ToolBarActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
}
