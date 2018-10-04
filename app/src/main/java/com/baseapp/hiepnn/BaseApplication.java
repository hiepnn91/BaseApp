package com.baseapp.hiepnn;

import android.app.Application;

import com.baseapp.hiepnn.utils.SharedPrefUtils;


/**
 * Created by Envy 15T on 9/11/2015.
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;
    private static SharedPrefUtils sharedPreferences;

    public BaseApplication() {
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = new SharedPrefUtils(getApplicationContext());
    }

    public static SharedPrefUtils getSharedPreferences() {
        return sharedPreferences;
    }

}
