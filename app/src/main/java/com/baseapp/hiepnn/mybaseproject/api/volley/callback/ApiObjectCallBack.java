package com.baseapp.hiepnn.mybaseproject.api.volley.callback;

/**
 * Created by User on 9/30/2015.
 */
public interface ApiObjectCallBack<T> {
    void onSuccess(T data);

    void onFail(int failCode, String message);
}
