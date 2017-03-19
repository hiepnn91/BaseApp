package com.baseapp.hiepnn.mybaseproject.api.volley.core;

import com.android.volley.Request;
import com.baseapp.hiepnn.mybaseproject.BaseApplication;
import com.baseapp.hiepnn.mybaseproject.utils.NetworkUtils;


import java.util.HashMap;

/**
 * Created by Envy 15T on 7/15/2015.
 */
public abstract class ObjectApiRequest<T> extends BaseApiRequest<T> {

    String tag = null;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDontCancel() {
        this.tag = NetworkUtils.DONT_CANCEL;
    }

    public void setIsLoadMore(boolean isLoadMore) {
        if (isLoadMore) {
            this.tag = NetworkUtils.LOAD_MORE;
        }
    }

    @Override
    protected void excecuteRequest() {
        super.excecuteRequest();
            if ((getMethod() == Request.Method.GET || getMethod() == Request.Method.DELETE) && getRequestParams() != null) {
                baseTypeRequest = new GsonRequest<>(getMethod(), createRequestUrl(), getResponseClass(), getRequestHeaders(), new HashMap<String, String>(), getListener(), getErrorListener());
            } else {
                baseTypeRequest = new GsonRequest<>(getMethod(), createRequestUrl(), getResponseClass(), getRequestHeaders(), handleRequestParams(), getListener(), getErrorListener());
            }
            baseTypeRequest.setGsonRequestHeaderOnResult(this);
            baseTypeRequest.setRetryPolicy(getDefaultRetryPolicy());
            if (tag != null) {
                baseTypeRequest.setTag(this.tag);
            }
            NetworkUtils.getInstance(BaseApplication.getInstance()).addToRequestQueue(baseTypeRequest);
    }
}
