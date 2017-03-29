package com.baseapp.hiepnn.mybaseproject.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.utils.FragmentUtil;

/**
 * Created by hiepn on 23/03/2017.
 */

public class ThirdChildTwoFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third_child;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
    }

    @Override
    protected void getArgument(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }

//    @Override
//    protected void processCustomToolbar() {
//        FragmentUtil.popBackStack(this);
//    }
//
//    @Override
//    protected void processOnBackPress() {
//        FragmentUtil.popBackStack(this);
//    }
//
//    @Override
//    protected Drawable getIconLeft() {
//        return getResources().getDrawable(R.drawable.ic_back);
//    }
}
