package com.wzw.gameapps.activity;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.wzw.gameapps.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerLayoutToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initActionBar();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);
        actionBar.setTitle("软萌妹");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        drawerLayoutToggle = new ActionBarDrawerToggle(this,drawerLayout, R.drawable.ic_drawer_am, 0, 0);
        drawerLayoutToggle.syncState();
        drawerLayout.setDrawerListener(drawerLayoutToggle);
    }

    //在选项菜单关闭时被调用
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerLayoutToggle.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            //响应每个菜单项(通过菜单项的ID)
            case 1:
            // do something here
            break;
            case 2:
            // do something here
            break;
            case 3:
            // do something here
            break;
            case 4:
            // do something here
            break;
            default:
                //对没有处理的事件，交给父类来处理
                return super.onOptionsItemSelected(item);
        }
        //返回true表示处理完菜单项的事件，不需要将该事件继续传播下去了
        return true;

    }
}
