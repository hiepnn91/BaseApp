package com.baseapp.hiepnn.mybaseproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class NetworkUtils {

    public static final String DONT_CANCEL = "DONT_CANCEL";

    public static final String LOAD_MORE = "LOAD_MORE";

    private static NetworkUtils sInstance;

    private static RequestQueue sRequestQueue;

    private static Context sContext;

    public static synchronized NetworkUtils getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NetworkUtils(context);
        }
        return sInstance;
    }

    public NetworkUtils(Context context) {
        initNetworkConfig(context);
    }

    /**
     * Check internet connection
     *
     * @return true if Network is connected.
     */
    public boolean isNetworkConnected() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (mConnectivityManager.getActiveNetworkInfo() != null && mConnectivityManager.getActiveNetworkInfo().isAvailable() && mConnectivityManager
                .getActiveNetworkInfo().isConnected());
    }

    public RequestQueue getRequestQueue() {
        if (sRequestQueue == null) {
            sRequestQueue = Volley.newRequestQueue(sContext.getApplicationContext());
        }
        return sRequestQueue;
    }

    public void cancelAllRequest() {
        if (sRequestQueue != null) {
            sRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
                @Override
                public boolean apply(Request<?> request) {
                    return true;
                }
            });
        }
    }

    public void cancelDontCancelRequest() {
        if (sRequestQueue != null) {
            sRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
                @Override
                public boolean apply(Request<?> request) {
                    if (request.getTag() != null && request.getTag().equals(DONT_CANCEL)) {
                        DebugLog.i(request.getUrl());
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    public void cancelLoadMoreRequest() {
        if (sRequestQueue != null) {
            sRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
                @Override
                public boolean apply(Request<?> request) {
                    if (request.getTag() != null && request.getTag().equals(LOAD_MORE)) {
                        DebugLog.i(request.getUrl());
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    public void cancelNormalRequest() {
        if (sRequestQueue != null) {
            sRequestQueue.cancelAll(new RequestQueue.RequestFilter() {
                @Override
                public boolean apply(Request<?> request) {
                    if (request.getTag() != null) {
                        if (request.getTag().equals(DONT_CANCEL) || request.getTag().equals(LOAD_MORE)) {
                            DebugLog.i(request.getUrl());
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            });
        }
    }

    public <T> void addToRequestQueue(Request<T> req) {
        if (DebugLog.isDebuggable()) {
            DebugLog.i("Request: " + req.getUrl());
        }
        getRequestQueue().add(req);
    }

    public void initNetworkConfig(Context mContext) {
        sContext = mContext;
        sRequestQueue = getRequestQueue();
    }

    @NonNull
    public static String getErrorMessage(VolleyError error) {
        return error.networkResponse != null && error.networkResponse.data != null ?
                new String(error.networkResponse.data) : "";
    }
}
