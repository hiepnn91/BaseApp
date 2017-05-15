package com.baseapp.hiepnn.mybaseproject.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseapp.hiepnn.mybaseproject.R;

/**
 * Created by hiepn on 11/05/2017.
 */

public class TestFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
        customToolbar(true);
    }

    @Override
    protected void getArgument(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }
    @Override
    protected void processOnBackPress() {
    }

    @Override
    protected Drawable getIconLeft() {
        return getResources().getDrawable(R.drawable.ic_menu);
    }

    @Override
    protected void processCustomToolbar() {
        loadMenuLeft();
    }
}
