package com.baseapp.hiepnn.api.volley.core;

import com.baseapp.hiepnn.BaseApplication;
import com.baseapp.hiepnn.utils.NetworkUtils;


import java.io.File;
import java.util.Map;

/**
 * Created by Envy 15T on 7/15/2015.
 */
public abstract class UploadBinaryApiRequest<T> extends BaseApiRequest<T> {

    private Map<String, File> requestFiles;

    @Override
    protected void excecuteRequest() {
        super.excecuteRequest();
//        baseTypeRequest = new MultiPartRequest<>(Request.Method.POST, createRequestUrl(), getErrorListener(), getResponseClass(), getRequestHeaders(), getListener(), handleRequestParams(), requestFiles);
        baseTypeRequest.setGsonRequestHeaderOnResult(this);
        baseTypeRequest.setRetryPolicy(getDefaultRetryPolicy());
        NetworkUtils.getInstance(BaseApplication.getInstance()).addToRequestQueue(baseTypeRequest);
    }

    public void setRequestFiles(Map<String, File> requestFiles) {
        this.requestFiles = requestFiles;
    }
}
