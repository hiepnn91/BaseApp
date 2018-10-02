package com.baseapp.hiepnn.mybaseproject.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.api.volley.event.ApiEvent;
import com.baseapp.hiepnn.mybaseproject.model.Event;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.baseapp.hiepnn.mybaseproject.utils.DialogUtil;
import com.baseapp.hiepnn.mybaseproject.utils.EventBusHelper;
import com.baseapp.hiepnn.mybaseproject.utils.KeyboardUtil;


import butterknife.ButterKnife;

/**
 * Created by Envy 15T on 6/4/2015.
 */
public abstract class BaseActivity extends LocalizationActivity {

    AlertDialog dialogErrorAPI;
    AlertDialog dialogTimeOutAPI;
    AlertDialog dialogNoConnection;
    BaseActivity baseActivity;
    boolean isUnregistEventBus = false;
    private Event eventBaseActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        onPreSetContentView(savedInstanceState);
        super.onCreate(savedInstanceState);
        baseActivity = this;
        Intent intent = getIntent();
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {
            handleDeepLinkData(intent.getData());
        }
        setContentView(setContentViewId());
        ButterKnife.bind(this);
        EventBusHelper.register(this);
        isUnregistEventBus = false;
        eventBaseActivity = new Event();
        initView();
        initDialogApi();
        initData();
    }

    public Event getEventBaseActivity() {
        return eventBaseActivity;
    }

    private void initDialogApi() {
        dialogErrorAPI = DialogUtil.createApiErrorDialog(this, null, getString(R.string.dialog_error_api));
        dialogTimeOutAPI = DialogUtil.createApiErrorDialog(this, null, getString(R.string.dialog_error_timeout));
        dialogNoConnection = DialogUtil.createApiErrorDialog(this, null, getString(R.string.dialog_error_no_connection));
    }

    protected boolean checkApiDialogIsShow() {
        return dialogErrorAPI.isShowing() || dialogTimeOutAPI.isShowing() || dialogNoConnection.isShowing();
    }

    @Override
    protected void onDestroy() {
        if (!isUnregistEventBus) {
            EventBusHelper.unregister(this);
        }
        super.onDestroy();
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(ApiEvent event) {
        switch (event.apiEventType) {
            case SHOW_API_ERROR_DIALOG:
                showApiDialog(dialogErrorAPI);
                break;
            case SHOW_API_TIMEOUT_DIALOG:
                showApiDialog(dialogTimeOutAPI);
                break;
            case SHOW_API_NO_CONNECTION_DIALOG:
                showApiDialog(dialogNoConnection);
                break;
        }
    }

    private void showApiDialog(AlertDialog alertDialog) {
        if (alertDialog != null && !checkApiDialogIsShow()) {
            alertDialog.show();
        }
    }

    /**
     * Handle data before setContentView call
     *
     * @param savedInstanceState
     */
    protected void onPreSetContentView(Bundle savedInstanceState) {

    }

    /**
     * Handle deep link data
     *
     * @param uri
     */
    protected void handleDeepLinkData(Uri uri) {
        DebugLog.i("uri: " + uri.toString());
    }

    /**
     * @return layout of activity
     */
    public abstract int setContentViewId();

    /**
     * Define your view
     */
    public abstract void initView();

    /**
     * Setup your data
     */
    public abstract void initData();


    @Override
    public void startActivity(Intent intent) {
        EventBusHelper.unregister(this);
        isUnregistEventBus = true;
        super.startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isUnregistEventBus) {
            EventBusHelper.register(this);
            isUnregistEventBus = false;
        }
    }

    public void hideKeyBoardWhenTouchOutside(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    KeyboardUtil.hideSoftKeyboard(BaseActivity.this);
                    return false;
                }
            });
        }
    }
}
