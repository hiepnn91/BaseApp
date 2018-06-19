package com.baseapp.hiepnn.mybaseproject.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.callback.OnFillBackgroundListener;
import com.baseapp.hiepnn.mybaseproject.fragments.FirstFragment;
import com.baseapp.hiepnn.mybaseproject.fragments.ListUserFragment;
import com.baseapp.hiepnn.mybaseproject.utils.FragmentUtil;

import butterknife.InjectView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tvAppName)
    TextView tvAppName;
    @InjectView(R.id.nav_view)
    public NavigationView navigationView;
    @InjectView(R.id.drawer_layout)
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle(null);
        getEventBaseActivity().setOnFillBackgroundListener(new OnFillBackgroundListener() {
            @Override
            public void onFillBackground(String nameTable) {
                tvAppName.setText(nameTable);
            }
        });
//        FragmentUtil.replaceFragment(MainActivity.this, new FirstFragment().newInstance("FirstFragment"), null);
        FragmentUtil.replaceFragment(MainActivity.this, new ListUserFragment(), null);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            FragmentUtil.replaceFragment(this, new FirstFragment().newInstance("FirstFragment"), null);
        } else if (id == R.id.nav_gallery) {
//            FragmentUtil.replaceFragment(this, new ThirdFragment().newInstance("ThirdFragment"), null);
        } else if (id == R.id.nav_slideshow) {
//            DebugLog.showLogCat("nav_slideshow");
        } else if (id == R.id.nav_manage) {
//            DebugLog.showLogCat("nav_manage");
        } else if (id == R.id.nav_share) {
//            DebugLog.showLogCat("nav_share");
        } else if (id == R.id.nav_send) {
//            DebugLog.showLogCat("nav_send");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
