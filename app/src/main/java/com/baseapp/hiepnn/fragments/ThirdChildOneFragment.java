package com.baseapp.hiepnn.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseapp.hiepnn.R;
import com.baseapp.hiepnn.utils.FragmentUtil;

/**
 * Created by hiepn on 23/03/2017.
 */

public class ThirdChildOneFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third_child;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
//        setCustomToolbar(false);
    }

    @Override
    protected void getArgument(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onRestore() {

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void onSaveState(Bundle bundle) {

    }

    @Override
    protected void onRestoreState(Bundle bundle) {

    }

    @Override
    protected void processCustomToolbar() {
        FragmentUtil.popBackStack(ThirdChildOneFragment.this);
    }

    @Override
    protected void processOnBackPress() {
        FragmentUtil.popBackStack(ThirdChildOneFragment.this);
    }

    @Override
    protected Drawable getIconLeft() {
        return getResources().getDrawable(R.drawable.ic_dm01);
    }
}
