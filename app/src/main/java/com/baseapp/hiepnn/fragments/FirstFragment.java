package com.baseapp.hiepnn.fragments;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.baseapp.hiepnn.R;
import com.baseapp.hiepnn.api.request.BaseRequest;
import com.baseapp.hiepnn.api.request.GetNewListByPlace;
import com.baseapp.hiepnn.api.request.LoginRequest;
import com.baseapp.hiepnn.api.response.getnewlistbyplace.NewListByPlace;
import com.baseapp.hiepnn.api.response.loginresponse.LoginResponse;
import com.baseapp.hiepnn.api.volley.callback.ApiObjectCallBack;
import com.baseapp.hiepnn.constant.AppConstant;
import com.baseapp.hiepnn.utils.DebugLog;
import com.baseapp.hiepnn.utils.DialogUtil;
import com.baseapp.hiepnn.utils.FragmentUtil;
import com.baseapp.hiepnn.utils.SharedPrefsUtils;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;


public class FirstFragment extends BaseFragment {
    @BindView(R.id.btnFrgSec)
    Button btnFrgSec;
    String mNameFragment;
    LoginRequest loginRequest;
    GetNewListByPlace getNewListByPlace;

    public static FirstFragment newInstance(String nameFragment) {
        FirstFragment fm = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nameFragment", nameFragment);
        fm.setArguments(bundle);
        return fm;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
        DebugLog.showLogCat(mNameFragment);
        setCustomToolbar(true);
        btnFrgSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugLog.showLogCat("SecondFragment");
                Toast.makeText(baseActivity, "First", Toast.LENGTH_SHORT).show();
                FragmentUtil.pushFragment(baseActivity, new SecondFragment().newInstance("SecondFragment"), null);
            }
        });
        setHasOptionsMenu(true);
    }

    @Override
    protected void getArgument(Bundle bundle) {
        mNameFragment = bundle.getString("nameFragment");
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onRestore() {
        getEventBaseFragment().doFillBackground(mNameFragment);
        DebugLog.showLogCat(mNameFragment);
    }

    @Override
    protected void initialize() {
        getEventBaseFragment().doFillBackground(mNameFragment);
        DebugLog.showLogCat(mNameFragment);
    }

    @Override
    protected void onSaveState(Bundle bundle) {
        bundle.putString("nameFragment", "Test");
//        mNameFragment = bundle.getString("nameFragment");
    }

    @Override
    protected void onRestoreState(Bundle bundle) {
        mNameFragment = bundle.getString("nameFragment");
        DebugLog.showLogCat(mNameFragment);
    }

    public void callLogin() throws JSONException {
        showCoverNetworkLoading();
        loginRequest = new LoginRequest("test@test.com", "123123");
        loginRequest.callRequest(new ApiObjectCallBack<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse data) {
                if (data.getStatusCode() == 200) {
                    if (SharedPrefsUtils.getStringPreference(getActivity(), AppConstant.ACCESS_TOKEN) == null) {
                        DebugLog.showLogCat("null Pre");
                        SharedPrefsUtils.setStringPreference(getActivity(), AppConstant.ACCESS_TOKEN, data.getApiToken());
                    }
                    getNewListByPlace = new GetNewListByPlace(data.getApiToken());
                    getNewListByPlace.callRequest(new ApiObjectCallBack<NewListByPlace>() {
                        @Override
                        public void onSuccess(NewListByPlace data) {
                            hideCoverNetworkLoading();
                            FragmentUtil.pushFragment(getActivity(), new SecondFragment().newInstance(data.getNewsByCity().get(0).getSubTitle()), null);
                        }

                        @Override
                        public void onFail(int failCode, String message) {
                            hideCoverNetworkLoading();
                            DialogUtil.showDialog(getActivity(), "Thông báo", message);
                            DebugLog.showLogCat("hey");
                        }
                    });
                }
            }

            @Override
            public void onFail(int failCode, String message) {
                hideCoverNetworkLoading();
                DialogUtil.showDialog(getActivity(), "Thông báo", message);
            }
        });
    }

    @Override
    public ArrayList<BaseRequest> getArrayRequest() {
        ArrayList<BaseRequest> baseRequests = new ArrayList<>();
        baseRequests.add(loginRequest);
        baseRequests.add(getNewListByPlace);
        return baseRequests;
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("01682253221", null, "Test", null, null);
                    Toast.makeText(getActivity(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast.makeText(getActivity(), "Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
