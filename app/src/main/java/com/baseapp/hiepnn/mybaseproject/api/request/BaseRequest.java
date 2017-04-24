package com.baseapp.hiepnn.mybaseproject.api.request;

import com.baseapp.hiepnn.mybaseproject.api.volley.callback.ApiObjectCallBack;
import com.baseapp.hiepnn.mybaseproject.constant.ApiConstant;
import com.baseapp.hiepnn.mybaseproject.utils.DebugLog;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.json.JSONObject;

/**
 * Created by hiepn on 22/04/2017.
 */

public abstract class BaseRequest<T> {
    private AsyncHttpClient client = new AsyncHttpClient();
    private JsonHttpResponseHandler mJsonHttpResponseHandler;
    private ApiObjectCallBack<T> mApiObjectCallBack;

    public void callRequest(ApiObjectCallBack<T> tApiObjectCallBack) {
        mApiObjectCallBack = tApiObjectCallBack;
        mJsonHttpResponseHandler = new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                DebugLog.jsonFormat("response", response);
                mApiObjectCallBack.onSuccess(new Gson().fromJson(response.toString(), getResponseClass()));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                DebugLog.showLogCat(responseString);
                mApiObjectCallBack.onFail(statusCode, responseString);
            }
        };
        DebugLog.showLogCat(getAbsoluteUrl() + "\n" + putParams());
        if (getMethod() == ApiConstant.POST) {
            client.post(getAbsoluteUrl(), putParams(), mJsonHttpResponseHandler);
        } else {
            client.get(getAbsoluteUrl(), putParams(), mJsonHttpResponseHandler);
        }
        RequestConfig config = RequestConfig.custom().
                setConnectTimeout(5 * 1000).
                setConnectionRequestTimeout(5 * 1000).
                setSocketTimeout(5 * 1000).build();
    }

    public void cancelRequest() {
        client.cancelAllRequests(true);
    }

    abstract public Class<T> getResponseClass();

    protected abstract RequestParams putParams();

    abstract public int getMethod();

    protected abstract String getAbsoluteUrl();
}
