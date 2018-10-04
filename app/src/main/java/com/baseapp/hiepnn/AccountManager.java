package com.baseapp.hiepnn;

import android.provider.Settings;
import android.text.TextUtils;

import com.baseapp.hiepnn.model.UserInfoBean;
import com.baseapp.hiepnn.utils.NetworkUtils;
import com.baseapp.hiepnn.utils.SharedPrefUtils;
import com.google.gson.Gson;


/**
 * Created by User on 9/29/2015.
 */
public class AccountManager {

    private static final String KEY_USER_INFO = "user_info";
    private static final String KEY_ACCESS_TOKEN = "key_access_token";


    private static UserInfoBean userInfoBean;
    private static String accessToken;

    private static String UDID;

    public static UserInfoBean getUserInfoBean() {
        if (userInfoBean == null && SharedPrefUtils.containKey(KEY_USER_INFO)) {
            final String json = SharedPrefUtils.getString(KEY_USER_INFO, null);
            userInfoBean = new Gson().fromJson(json, UserInfoBean.class);
        }
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        AccountManager.userInfoBean = userInfoBean;
        if (!TextUtils.isEmpty(userInfoBean.access_token)) {
            accessToken = userInfoBean.access_token;
            storeAccessToken();
        }
        storeUserInfo();
    }

    private static void storeUserInfo() {
        String json = new Gson().toJson(userInfoBean);
        SharedPrefUtils.putString(KEY_USER_INFO, json);
    }

    public static String getAccessToken() {
        if (getUserInfoBean() != null) {
            accessToken = userInfoBean.access_token;
        }
        if (accessToken == null || accessToken.isEmpty()) {
            accessToken = SharedPrefUtils.getString(KEY_ACCESS_TOKEN, "");
        }
        return accessToken;
    }

    public static void setAccessToken(String token) {
        accessToken = token;
        storeAccessToken();
    }

    private static void storeAccessToken() {
        if (accessToken == null) {
            SharedPrefUtils.removeKey(KEY_ACCESS_TOKEN);
        } else {
            SharedPrefUtils.putString(KEY_ACCESS_TOKEN, accessToken);
        }
    }

    public static void logout() {
        NetworkUtils.getInstance(BaseApplication.getInstance()).cancelAllRequest();
        accessToken = null;
        userInfoBean = null;
        SharedPrefUtils.removeKey(KEY_ACCESS_TOKEN);
        SharedPrefUtils.removeKey(KEY_USER_INFO);
    }

    public static String getUDID() {
        if (UDID == null) {
            UDID = Settings.Secure.getString(BaseApplication.getInstance().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        }
        return UDID;
    }
}
