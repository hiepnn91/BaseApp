package com.baseapp.hiepnn.mybaseproject.api.request;

import com.baseapp.hiepnn.mybaseproject.api.response.loginresponse.LoginResponse;
import com.baseapp.hiepnn.mybaseproject.constant.ApiConstant;
import com.loopj.android.http.RequestParams;

/**
 * Created by hiepn on 22/04/2017.
 */

public class LoginRequest extends BaseRequest<LoginResponse> {
    private String mEmail;
    private String mPassword;

    public LoginRequest(String email, String password) {
        this.mEmail = email;
        this.mPassword = password;
    }

    @Override
    public Class<LoginResponse> getResponseClass() {
        return LoginResponse.class;
    }

    @Override
    protected RequestParams putParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", mEmail);
        requestParams.put("password", mPassword);
        return requestParams;
    }

    @Override
    public int getMethod() {
        return ApiConstant.POST;
    }

    @Override
    protected String getAbsoluteUrl() {
        return ApiConstant.LOGIN;
    }
}
