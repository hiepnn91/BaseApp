package com.baseapp.hiepnn.mybaseproject.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.adapter.ListUserAdapter;
import com.baseapp.hiepnn.mybaseproject.api.request.ListUserHelper;
import com.baseapp.hiepnn.mybaseproject.model.User;
import com.baseapp.hiepnn.mybaseproject.presenter.ListUserPresenter;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.baseapp.hiepnn.mybaseproject.view.ListUserView;

import java.util.ArrayList;
import java.util.List;

public class ListUserFragment extends BaseFragment implements ListUserView, View.OnClickListener {
    private final String EXTRA_USER_LIST = "extra_user_list";
    //    private final String url = "https://api.myjson.com/bins/53x82"; // PJ null
    private final String url = "https://api.myjson.com/bins/3w62s"; // lot of data
//    private final String url = "https://api.myjson.com/bins/3t3fg"; // no data

    private ArrayList<User> listUser;
    TextView tvMessage;
    ProgressBar loading;
    RecyclerView recyclerView;
    Button btReload;
    private ListUserAdapter adapter;


    // MVP
    private ListUserPresenter presenter;
    private ListUserHelper listUserHelper;


    public ListUserFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_user_fragment;
    }

    @Override
    protected void getArgument(Bundle bundle) {

    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
        getEventBaseFragment().doFillBackground("ListFragment");
        loading = (ProgressBar) root.findViewById(R.id.loading);
        tvMessage = (TextView) root.findViewById(R.id.message);
        btReload = (Button) root.findViewById(R.id.reload);
        btReload.setOnClickListener(this);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setHasOptionsMenu(true);
        if (listUser == null) {
            listUser = new ArrayList<>();
        }
        if (presenter == null) {
            if (listUserHelper == null)
                listUserHelper = new ListUserHelper(url);
            listUserHelper.setList(listUser);
            presenter = new ListUserPresenter(this, listUserHelper);
            presenter.getData(false);
        }
        else presenter.getData(true); // Use cache
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
    protected void processOnBackPress() {

    }

    @Override
    protected Drawable getIconLeft() {
        return getResources().getDrawable(R.drawable.ic_menu);
    }

    @Override
    protected void processCustomToolbar() {

    }

    @Override
    public void reload() {
        loading.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
        btReload.setVisibility(View.GONE);
    }

    @Override
    public void showNoData() {
        loading.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
        btReload.setVisibility(View.VISIBLE);
        tvMessage.setText("No Data");
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        loading.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Load Data Error");
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void displayListuser(List<User> listUser) {
        this.listUser = (ArrayList<User>) listUser;
        loading.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        adapter = new ListUserAdapter(listUser);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reload:
                presenter.reload();
                break;
        }
    }

    @Override
    public void onPause() {
        Log.d("PJ3", "On Pause");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.d("PJ3", "On Destroy");
        super.onDestroy();
        presenter = null;
        listUserHelper = null;
        adapter = null;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reload:
                presenter.getData(false); // Not use cache
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
