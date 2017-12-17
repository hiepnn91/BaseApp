package com.baseapp.hiepnn.mybaseproject.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.constant.AppConstant;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.baseapp.hiepnn.mybaseproject.utils.FragmentUtil;
import com.baseapp.hiepnn.mybaseproject.utils.SharedPrefsUtils;

import butterknife.InjectView;
import butterknife.OnClick;

public class SecondFragment extends BaseFragment {
    @InjectView(R.id.btnFrgThird)
    Button btnFrgThird;
    @InjectView(R.id.tv_hello)
    TextView tv_hello;
    String nameFragment;

    public static SecondFragment newInstance(String nameFragment) {
        SecondFragment fm = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nameFragment", nameFragment);
        fm.setArguments(bundle);
        return fm;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
        setCustomToolbar(true);
        setHasOptionsMenu(true);
        tv_hello.setText(nameFragment);
    }

    @Override
    protected void getArgument(Bundle bundle) {
        nameFragment = bundle.getString("nameFragment");
    }

    @Override
    protected void initData() {
        getEventBaseFragment().doFillBackground("SecondFragment");
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


    @OnClick(R.id.btnFrgThird)
    void onClickFrgThird() {
        FragmentUtil.popEntireFragmentBackStack(SecondFragment.this);
        FragmentUtil.pushFragment(getActivity(), new ThirdFragment(), null);
    }

    @Override
    protected void processOnBackPress() {
        FragmentUtil.popBackStack(this);
    }

    @Override
    protected Drawable getIconLeft() {
        return getResources().getDrawable(R.drawable.ic_back);
    }

    @Override
    protected void processCustomToolbar() {
        FragmentUtil.popBackStack(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_second, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            Toast.makeText(getActivity(), "Add", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
