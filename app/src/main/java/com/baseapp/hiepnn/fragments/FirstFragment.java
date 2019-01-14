package com.baseapp.hiepnn.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baseapp.hiepnn.R;
import com.baseapp.hiepnn.api.request.BaseRequest;
import com.baseapp.hiepnn.api.request.GetNewListByPlace;
import com.baseapp.hiepnn.api.request.LoginRequest;
import com.baseapp.hiepnn.api.response.getnewlistbyplace.NewListByPlace;
import com.baseapp.hiepnn.api.response.loginresponse.LoginResponse;
import com.baseapp.hiepnn.api.volley.callback.ApiObjectCallBack;
import com.baseapp.hiepnn.constant.AppConstant;
import com.baseapp.hiepnn.model.RowItem;
import com.baseapp.hiepnn.utils.DebugLog;
import com.baseapp.hiepnn.utils.DialogUtil;
import com.baseapp.hiepnn.utils.FragmentUtil;
import com.baseapp.hiepnn.utils.SharedPrefsUtils;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FirstFragment extends BaseFragment {
    public boolean fragment = true;
    CustomBaseAdapter adapter;
    public List<RowItem> rowitems = new ArrayList<RowItem>();
    String mNameFragment;
    LoginRequest loginRequest;
    GetNewListByPlace getNewListByPlace;
    boolean isShow = false;
    ListView lv;

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
//        btnFrgSec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DebugLog.showLogCat("SecondFragment");
//                Toast.makeText(baseActivity, "First", Toast.LENGTH_SHORT).show();
//                FragmentUtil.pushFragment(baseActivity, new SecondFragment().newInstance("SecondFragment"), null);
//            }
//        });
        setHasOptionsMenu(true);
        lv = (ListView) root.findViewById(R.id.lv1);
        for (int i = 0; i < 20; i++) {
            RowItem r = new RowItem("ARiana " + i, false);
            rowitems.add(r);
        }
        adapter = new CustomBaseAdapter(getActivity(), rowitems);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.isCheckBoxVisible = true;
                lv.setAdapter(adapter);
                return false;
            }
        });

        Button bt = (Button) root.findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isShow) {
                    adapter.isCheckBoxVisible = false;
                    lv.setAdapter(adapter);
                    isShow = false;
                } else {
                    adapter.isCheckBoxVisible = true;
                    lv.setAdapter(adapter);
                    isShow = true;
                }
//                RowItem r;
//                for (int i = 0; i < lv.getCount(); i++) {
//                    r = (RowItem) lv.getAdapter().getItem(i);
//                    if (r.getCekbox()) {
//                        Toast.makeText(getActivity().getApplicationContext(), r.getContent(), Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
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
            if (isShow) {
                adapter.isCheckBoxVisible = false;
                lv.setAdapter(adapter);
                isShow = false;
            } else {
                adapter.isCheckBoxVisible = true;
                lv.setAdapter(adapter);
                isShow = true;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class CustomBaseAdapter extends BaseAdapter {
        Context tcon;
        List<RowItem> row;
        boolean isCheckBoxVisible = false;

        public CustomBaseAdapter(Context cont, List<RowItem> items) {
            this.tcon = cont;
            this.row = items;
        }

        @Override
        public int getCount() {
            return row.size();
        }

        @Override
        public Object getItem(int position) {
            return row.get(position);
        }

        @Override
        public long getItemId(int position) {
            return row.indexOf(getItem(position));
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder holder = null;

            LayoutInflater inf = (LayoutInflater) tcon.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inf.inflate(R.layout.item_list, null);
                holder.nContent = (TextView) convertView.findViewById(R.id.textView3);
                holder.nCheckBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            RowItem rowItem = (RowItem) getItem(position);
            holder.nContent.setText(rowItem.getContent());
            if (this.isCheckBoxVisible) {
                holder.nCheckBox.setVisibility(CheckBox.VISIBLE);
            } else {
                holder.nCheckBox.setVisibility(CheckBox.GONE);
            }
            holder.nCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    row.get(position).setCekbox(isChecked);
                }
            });
            return convertView;
        }

    }

    class ViewHolder {
        TextView nContent;
        CheckBox nCheckBox;
    }
}
