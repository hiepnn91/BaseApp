package com.baseapp.hiepnn.mybaseproject.presenter;

import android.support.annotation.NonNull;


import com.baseapp.hiepnn.mybaseproject.api.request.ListUserHelper;
import com.baseapp.hiepnn.mybaseproject.callback.OnLoadUserResult;
import com.baseapp.hiepnn.mybaseproject.model.User;
import com.baseapp.hiepnn.mybaseproject.view.ListUserView;

import java.util.List;


/**
 * Created by Allen on 01-Apr-16.
 */
public class ListUserPresenter implements OnLoadUserResult {
    private ListUserView view;
    private ListUserHelper model;

    public ListUserPresenter(ListUserView view, ListUserHelper model) {
        this.view = view;
        this.model = model;
        this.model.setOnLoadUserResult(this);
    }

    public void getData(boolean useCache) {
        view.reload();
        model.getUserList(useCache);
    }

    public void reload() {
        getData(false);
    }

    @Override
    public void onLoadUserSuccess(@NonNull List<User> userList) {
        if (userList.size() > 0)
            view.displayListuser(userList);
        else view.showNoData();
    }

    @Override
    public void onLoadUserError() {
        view.showError();
    }
}
