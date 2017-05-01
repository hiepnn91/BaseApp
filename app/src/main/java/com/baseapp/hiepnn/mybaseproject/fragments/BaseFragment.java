package com.baseapp.hiepnn.mybaseproject.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.hiepnn.mybaseproject.BaseApplication;
import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.activities.BaseActivity;
import com.baseapp.hiepnn.mybaseproject.activities.MainActivity;
import com.baseapp.hiepnn.mybaseproject.api.request.BaseRequest;
import com.baseapp.hiepnn.mybaseproject.callback.OnHeaderIconClickListener;
import com.baseapp.hiepnn.mybaseproject.model.Event;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.baseapp.hiepnn.mybaseproject.utils.KeyboardUtil;
import com.baseapp.hiepnn.mybaseproject.utils.NetworkUtils;
import com.baseapp.hiepnn.mybaseproject.utils.UiUtil;


import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by Envy 15T on 6/4/2015.
 */
public abstract class BaseFragment extends Fragment {
    private static ProgressDialog progressDlg;
    protected View rootView;

    protected ViewGroup fragmentViewParent;
    BaseActivity baseActivity;

    @Optional
    @InjectView(R.id.initialProgressBar)
    View initialProgressBar;

    @Optional
    @InjectView(R.id.initialNetworkError)
    View initialNetworkError;

    @Optional
    @InjectView(R.id.initialEmptyList)
    View initialEmptyList;

    @Optional
    @InjectView(R.id.coverNetworkLoading)
    View coverNetworkLoading;

    @Optional
    @InjectView(R.id.common_layout)
    LinearLayout linearLayoutEmpty;

    @Optional
    @InjectView(R.id.common_txt_empty)
    TextView tvEmpty;
    LayoutInflater mInflater;
    ViewGroup mContainer;
    MainActivity act;
    private boolean isCustomToolbar = false;

    protected boolean isLoading = false;

    public View getInitialEmptyList() {
        return initialEmptyList;
    }

    public View getInitialNetworkError() {
        return initialNetworkError;
    }

    public View getInitialProgressBar() {
        return initialProgressBar;
    }

    public View getCoverNetworkLoading() {
        return coverNetworkLoading;
    }

    public TextView getTvEmpty() {
        return tvEmpty;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        DebugLog.i("Lifecycle " + this.getClass().getSimpleName());
//        handleHeaderCallback(getActivity(), this);
        return createRootView(inflater, container);
    }

//    private void handleHeaderCallback(FragmentActivity activity, @NonNull Fragment fragment) {
//        if (!isDisableOnHeaderIconClickListenerAttach()) {
//            if (activity instanceof MainActivity) {
//                if (fragment instanceof OnHeaderIconClickListener) {
//                    ((MainActivity) activity).setOnHeaderIconClickListener((OnHeaderIconClickListener) fragment);
//                } else {
//                    ((MainActivity) activity).setOnHeaderIconClickListener(null);
//                }
//            }
//        }
//    }

    protected boolean isDisableOnHeaderIconClickListenerAttach() {
        return false;
    }

    private View createRootView(LayoutInflater inflater, ViewGroup container) {
        mInflater = inflater;
        mContainer = container;
        if (isSkipGenerateBaseLayout()) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.inject(this, rootView);
        } else {
            rootView = inflater.inflate(R.layout.layout_base_fragment, container, false);
            fragmentViewParent = (ViewGroup) rootView.findViewById(R.id.fragmentViewParent);
            fragmentViewParent.addView(inflater.inflate(getLayoutId(), container, false));
            ButterKnife.inject(this, rootView);
            bypassCommonNetworkLoadingIfNecessary();
        }
        return rootView;
    }

    protected boolean isSkipGenerateBaseLayout() {
        return false;
    }

    private void bypassCommonNetworkLoadingIfNecessary() {
        if (!isStartWithLoading()) {
            initialResponseHandled();
        } else {
            initialLoadingProgress();
            isLoading = true;
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            getArgument(getArguments());
        }
        baseActivity = (BaseActivity) getActivity();
        initView(rootView, mInflater, mContainer);
        initData();
    }

    public void setCustomToolbar(boolean isCustom) {
        customToolbar(isCustom);
    }

    public Event getEventBaseFragment() {
        return baseActivity.getEventBaseActivity();
    }


    public void showProgressDialog(boolean cancleable) {
        if (progressDlg != null && progressDlg.isShowing()) {
            closeProgressDialog();
        }
        progressDlg = ProgressDialog.show(getActivity(), "", "Đang xử lý", true, cancleable);
        progressDlg.setCancelable(cancleable);
        progressDlg.setCanceledOnTouchOutside(cancleable);
        progressDlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                cancelAllRequest(getArrayRequest());
            }
        });
    }

    public void closeProgressDialog() {
        if (progressDlg != null) {
            try {
                progressDlg.dismiss();
                progressDlg = null;
            } catch (Exception e) {
            }
        }
    }

    public void cancelAllRequest(ArrayList<BaseRequest> callArrayList) {
        for (int i = 0; i < callArrayList.size(); i++) {
            DebugLog.showLogCat("Cancel");
            if (callArrayList.get(i) != null)
                callArrayList.get(i).cancelRequest();
        }
    }

    public ArrayList<BaseRequest> getArrayRequest() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        KeyboardUtil.hideSoftKeyboard(getActivity());
        if (isCancelRequestOnDestroyView()) {
            NetworkUtils.getInstance(BaseApplication.getInstance()).cancelNormalRequest();
            isLoading = isLoadingMore();
        }
    }

    abstract protected int getLayoutId();

    abstract protected void initView(View root, LayoutInflater inflater, ViewGroup container);

    abstract protected void getArgument(Bundle bundle);

    abstract protected void initData();

    protected void onBackPressFragment(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        processOnBackPress();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    protected void processOnBackPress() {
    }

    protected void customToolbar(boolean isCustom) {
        act = (MainActivity) getActivity();
        if (isCustom) {
            if (act.getSupportActionBar() != null) {
                Toolbar toolbar = (Toolbar) act.findViewById(R.id.toolbar);
                toolbar.setNavigationIcon(getIconLeft());
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (getFragmentManager().getBackStackEntryCount() > 0) {
                            processCustomToolbar();
                        } else {
//                        loadMenuLeft();
                        }
                    }
                });
            }
        } else {
            if (act.getSupportActionBar() != null) {
                Toolbar toolbar = (Toolbar) act.findViewById(R.id.toolbar);
                toolbar.setNavigationIcon(null);
            }
        }
    }

    protected void loadMenuLeft() {
        if (act.drawer.isDrawerOpen(GravityCompat.START)) {
            act.drawer.closeDrawer(GravityCompat.START);
        } else {
            act.drawer.openDrawer(GravityCompat.START);
        }
    }

    protected Drawable getIconLeft() {
        return null;
    }

    protected void processCustomToolbar() {

    }

    public boolean isInterceptBackButton() {
        return false;
    }

    protected boolean isStartWithLoading() {
        return false;
    }

    protected String setEmptyDataMessage() {
        return "";
    }

    protected boolean isCancelRequestOnDestroyView() {
        return true;
    }

    protected boolean isLoadingMore() {
        return false;
    }

    private void showAndHideOthers(View target) {
        showOrHide(initialProgressBar, target);
        showOrHide(initialNetworkError, target);
        showOrHide(initialEmptyList, target);
        showOrHide(fragmentViewParent, target);
    }

    private void showOrHide(View subject, View target) {
        subject.setVisibility(subject == target ? View.VISIBLE : View.GONE);
    }

    protected void showCoverNetworkLoading() {
        UiUtil.showView(coverNetworkLoading);
        isLoading = true;
    }

    protected void hideCoverNetworkLoading() {
        UiUtil.hideView(coverNetworkLoading, true);
        isLoading = false;
    }

    protected void initialLoadingProgress() {
        showAndHideOthers(initialProgressBar);
    }

    protected void initialNetworkError() {
        showAndHideOthers(initialNetworkError);
    }

    protected void initialEmptyList() {
        showAndHideOthers(initialEmptyList);
        linearLayoutEmpty.setGravity(Gravity.CENTER);
        tvEmpty.setText(setEmptyDataMessage());
    }

    protected void initialResponseHandled() {
        isLoading = false;
        showAndHideOthers(fragmentViewParent);
    }

    protected boolean checkFragmentVisible() {
        if (isVisible() && getActivity() != null) {
            return true;
        } else {
            return false;
        }
    }

//    protected void setHeaderCallback(OnHeaderIconClickListener onHeaderIconClickListener) {
//        if (getActivity() instanceof MainActivity) {
//            ((MainActivity) getActivity()).setOnHeaderIconClickListener(onHeaderIconClickListener);
//        } else {
//            throw new ClassCastException("Current activity is not MainActivity!");
//        }
//    }

    public void hideKeyBoardWhenTouchOutside(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (checkFragmentVisible()) {
                        KeyboardUtil.hideSoftKeyboard(getActivity());
                    }
                    return false;
                }
            });
        }
    }
}

