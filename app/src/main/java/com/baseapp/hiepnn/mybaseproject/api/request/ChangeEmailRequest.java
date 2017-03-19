package com.baseapp.hiepnn.mybaseproject.api.request;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.baseapp.hiepnn.mybaseproject.api.response.SimpleResponse;
import com.baseapp.hiepnn.mybaseproject.api.volley.callback.SimpleRequestCallBack;
import com.baseapp.hiepnn.mybaseproject.api.volley.core.ObjectApiRequest;
import com.baseapp.hiepnn.mybaseproject.constant.ApiConstant;
import com.baseapp.hiepnn.mybaseproject.constant.ApiParam;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tran Xuan Binh on 10/22/2015.
 */
public class ChangeEmailRequest extends ObjectApiRequest<SimpleResponse> {

    private SimpleRequestCallBack requestCallBack;
    private String mEmail;

    public ChangeEmailRequest(String email, SimpleRequestCallBack simpleRequestCallBack){
        this.requestCallBack = simpleRequestCallBack;
        this.mEmail = email;
    }

    @Override
    public String getRequestURL() {
        return ApiConstant.BASE_URL + ApiConstant.CHANGE_EMAIL;
    }

    @Override
    public boolean isRequiredAccessToken() {
        return false;
    }

    @Override
    public Map<String, String> getRequestParams() {
        Map<String, String> params = new HashMap<>();
        params.put(ApiParam.EMAIL, mEmail);
        return params;
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public int getMethod() {
        return Request.Method.POST;
    }

    @Override
    public void onRequestSuccess(SimpleResponse response) {
        if (response.isSuccess()) {
            requestCallBack.onResponse(true,response.message);
        } else {
            requestCallBack.onResponse(false, response.message);
        }
    }

    @Override
    public void onRequestError(VolleyError error) {
        final String message = (error == null || error.getMessage() == null) ? ApiConstant.UNKNOWN_ERROR : error.getMessage();
        requestCallBack.onResponse(false, message);
    }
}
