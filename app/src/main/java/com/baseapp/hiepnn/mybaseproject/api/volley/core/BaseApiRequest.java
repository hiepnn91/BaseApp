package com.baseapp.hiepnn.mybaseproject.api.volley.core;

import android.net.Uri;
import android.util.Base64;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.baseapp.hiepnn.mybaseproject.AccountManager;
import com.baseapp.hiepnn.mybaseproject.BaseApplication;
import com.baseapp.hiepnn.mybaseproject.api.volley.bean.ErrorMessage;
import com.baseapp.hiepnn.mybaseproject.api.volley.event.ApiEvent;
import com.baseapp.hiepnn.mybaseproject.api.volley.event.ApiEventType;
import com.baseapp.hiepnn.mybaseproject.constant.ApiConstant;
import com.baseapp.hiepnn.mybaseproject.constant.ApiParam;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.baseapp.hiepnn.mybaseproject.utils.NetworkUtils;
import com.baseapp.hiepnn.mybaseproject.utils.SharedPrefUtils;
import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * Created by Envy 15T on 7/14/2015.
 */
public abstract class BaseApiRequest<T> implements BaseTypeRequest.GsonRequestHeaderOnResult {

    protected BaseTypeRequest<T> baseTypeRequest;

    public void execute() {
        if (checkRequestCondition()) {
            excecuteRequest();
        }
    }

    protected boolean checkRequestCondition() {
        if (!checkNetwork()) {
            EventBus.getDefault().post(new ApiEvent(ApiEventType.SHOW_API_NO_CONNECTION_DIALOG));
            onRequestError(new NoConnectionError());
            return false;
        } else {
            return true;
        }
    }

    protected Response.Listener<T> getListener() {
        return new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                onRequestSuccess(response);
            }
        };
    }

    protected Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleErrorResponse(error);
            }
        };
    }

    protected void excecuteRequest() {
        //TODO handle create new request in here
    }

    protected String createRequestUrl() {
        if ((getMethod() == Request.Method.GET || getMethod() == Request.Method.DELETE) && getRequestParams() != null) {
            Uri.Builder builder = Uri.parse(getRequestURL()).buildUpon();
            if (isRequiredAccessToken()) {
                builder.appendQueryParameter(ApiParam.ACCESS_TOKEN, SharedPrefUtils.getAccessToken());
            }
            for (Map.Entry<String, String> entry : getRequestParams().entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return builder.build().toString();
        } else {
            return getRequestURL();
        }
    }

    protected RetryPolicy getDefaultRetryPolicy() {
        return new DefaultRetryPolicy(
                ApiConstant.REQUEST_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    protected Map<String, String> handleRequestParams() {
        Map<String, String> requestParams = getRequestParams();
        if (isRequiredAccessToken()) {
            if (requestParams == null) {
                requestParams = new HashMap<>();
            }
            requestParams.put(ApiParam.ACCESS_TOKEN, SharedPrefUtils.getAccessToken());
        }
        DebugLog.i(requestParams.toString());
        return requestParams;
    }

    public BaseTypeRequest<T> getBaseTypeRequest() {
        return baseTypeRequest;
    }

    public void handleResponseHeader(Map<String, String> headers) {
        //TODO Handle headers response
    }

    @Override
    public void onGsonRequestHeaderResult(Map<String, String> headers) {
        handleResponseHeader(headers);
    }

    abstract public String getRequestURL();

    abstract public boolean isRequiredAccessToken();

    abstract public Map<String, String> getRequestParams();

    public Map<String, String> getRequestHeaders() {
        Map<String, String> header = new HashMap<>();
        final String name;
        final String password;
        if (AccountManager.getAccessToken() == null) {
            name = ApiConstant.BASE_NAME_AUTHORIZE;
            password = "";
        } else {
            name = ApiConstant.BASE_NAME_AUTHORIZE;
            password = AccountManager.getAccessToken();
        }
        final String authorize = "Basic " + Base64.encodeToString((name + ":" + password).getBytes(), Base64.NO_WRAP);
        header.put("Authorization", authorize);
        DebugLog.i("" + header);
        return header;
    }

    abstract public Class<T> getResponseClass();

    abstract public int getMethod();

    abstract public void onRequestSuccess(T response);

    abstract public void onRequestError(VolleyError error);

    protected boolean checkNetwork() {
        return NetworkUtils.getInstance(BaseApplication.getInstance()).isNetworkConnected();
    }

    protected boolean isHideApiErrorDialog() {
        return false;
    }

    protected boolean isHideConnectionErrorDialog() {
        return false;
    }

    protected void handleErrorResponse(VolleyError volleyError) {
        getErrorResponseMessage(volleyError);
        DebugLog.e("handleErrorResponse" + volleyError.getMessage());
        if (volleyError.getMessage() != null && volleyError.getMessage().contains("java.io.EOFException")) {
            EventBus.getDefault().post(new ApiEvent(ApiEventType.SHOW_API_ERROR_DIALOG));
            onRequestError(volleyError);
        } else if (volleyError instanceof NetworkError || volleyError instanceof TimeoutError) {
            if (!isHideConnectionErrorDialog()) {
                EventBus.getDefault().post(new ApiEvent(ApiEventType.SHOW_API_TIMEOUT_DIALOG));
            }
            onRequestError(volleyError);
        } else {
            if (!isHideApiErrorDialog()) {
                EventBus.getDefault().post(new ApiEvent(ApiEventType.SHOW_API_ERROR_DIALOG));
            }
            onRequestError(volleyError);
        }
    }

    public static String getErrorResponseMessage(VolleyError volleyError) {
        String response = NetworkUtils.getErrorMessage(volleyError);
        try {
            ErrorMessage errorMessage = new Gson().fromJson(response, ErrorMessage.class);
            if (!errorMessage.message.isEmpty()) {
                response = errorMessage.message;
            }
        } catch (Exception e) {
            DebugLog.e("not a json error message: " + response);
        }

        String header = volleyError.networkResponse != null && volleyError.networkResponse.headers != null ?
                volleyError.networkResponse.headers.toString() : volleyError.getClass().getSimpleName();

        if (response.isEmpty()) {
            response = volleyError.getMessage();
        }

        DebugLog.e("error: " + response + "  " + header + " " + (volleyError.networkResponse != null ? volleyError.networkResponse.statusCode : 0));
        return response;
    }

}
