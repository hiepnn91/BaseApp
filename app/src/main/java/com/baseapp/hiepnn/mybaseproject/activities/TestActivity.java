package com.baseapp.hiepnn.mybaseproject.activities;

import android.widget.Toast;

import com.baseapp.hiepnn.mybaseproject.R;

/**
 * Created by hiepn on 11/05/2017.
 */

public class TestActivity extends BaseActivity {
    @Override
    public int setContentViewId() {
        return R.layout.fragment_third_child;
    }

    @Override
    public void initView() {
        Toast.makeText(baseActivity,"Test",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initData() {

    }
}
