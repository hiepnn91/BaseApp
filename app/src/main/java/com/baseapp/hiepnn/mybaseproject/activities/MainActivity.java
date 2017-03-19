package com.baseapp.hiepnn.mybaseproject.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.fragments.FirstFragment;
import com.baseapp.hiepnn.mybaseproject.utils.FragmentUtil;

public class MainActivity extends BaseActivity {
    public FloatingActionButton fab;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        FragmentUtil.replaceFragment(MainActivity.this, new FirstFragment(), null);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
