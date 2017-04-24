package com.baseapp.hiepnn.mybaseproject.constant;


import com.baseapp.hiepnn.mybaseproject.BuildConfig;

/**
 * Created by Envy 15T on 6/4/2015.
 */
public class ApiConstant {


    public static final boolean IS_DEBUG_BUILD_TYPE = BuildConfig.BUILD_TYPE.equals("debug");

    public static final int REQUEST_TIMEOUT = 10;

    //Server KH
    public final static String REAL_URL = "http://113.190.233.226:8085/api/";
    public final static String DEV_URL = "http://113.190.233.226:8085/api/";

    public final static String BASE_URL = IS_DEBUG_BUILD_TYPE ? DEV_URL : REAL_URL;
    public final static String BASE_NAME_AUTHORIZE = "";
    public final static String UNKNOWN_ERROR = "Unknown error!";
    public final static int POST = 1;
    public final static int GET = 0;
    public final static int ITEM_LIMIT_DEFAULT = 30;

    public final static String LOGIN = BASE_URL + "login";
    public final static String GET_NEW_LIST_BY_PLACE = BASE_URL + "getNewListByPlace";
}
