package com.baseapp.hiepnn.mybaseproject.constant;


import com.baseapp.hiepnn.mybaseproject.BuildConfig;

/**
 * Created by Envy 15T on 6/4/2015.
 */
public class ApiConstant {


    public static final boolean IS_DEBUG_BUILD_TYPE = BuildConfig.BUILD_TYPE.equals("debug");

    public static final int REQUEST_TIMEOUT = 30000;

    public final static String BASE_NAME_AUTHORIZE = "wvniR2G0FgaC9mis2guDoUubW8HfLkwDEbBqBwrS";

//    public final static String REAL_URL = "http://183.91.3.79:8085/";
//    public final static String DEV_URL = "http://183.91.3.79:8085/";

    //Server Local
//    public final static String REAL_URL = "http://192.168.100.246:8085/";
//    public final static String DEV_URL = "http://192.168.100.246:8085/";

    //Server KH
    public final static String REAL_URL = "http://123.25.21.227:8089/";
    public final static String DEV_URL = "http://123.25.21.227:8089/";

    public final static String BASE_URL = IS_DEBUG_BUILD_TYPE ? DEV_URL : REAL_URL;

    public final static String UNKNOWN_ERROR = "Unknown error!";

    public final static int ITEM_LIMIT_DEFAULT = 30;

    public final static String LOGIN = "api/users/login.json";
    public final static String CHECK_USER_EXIST = "/api/users/check_user_exist.json";
    public final static String REGIST = "/api/users/regist.json";
    public final static String RESET_PASSWORD = "/api/users/reset_password.json";
    public final static String REMOVE_USER = "/api/users/remove.json";
    public final static String CHANGE_PASSWORD = "/api/users/modify.json";
    public final static String INQUIRY = "/api/informations/inquiry.json";
    public final static String GET_INFORMATION = "/api/informations/information_get.json";
    public final static String GET_USER_INFO = "/api/users/get_user_info.json";
    public final static String UPDATE_MY_PROFILE = "/api/users/update_profile.json";
    public final static String GET_ADVANCE_LIST = "/api/options/advance_list.json";
    public final static String UPDATE_ADVANCE_OPTION = "/api/users/update_advance_option.json";
    public final static String GET_USER_LIST = "/api/users/get_user_list.json";
    public final static String GET_RANKING_TAG = "/api/commons/get_ranking_tags.json";
    public final static String GET_RANKING_TAG_LIST = "/api/commons/get_ranking_tag_list.json";
    public final static String GET_POST_HISTORY = "/api/posts/get_post_history.json";
    public final static String UPDATE_TIMELINE_IMAGE = "/api/posts/update_timeline_image.json";
    public final static String GET_PUBLIC_TIMELINE_INFO = "/api/posts/get_public_timeline_info.json";
    public final static String LIKE = "/api/commons/like.json";
    public final static String GET_USER_COIN = "/api/billings/get_user_coin.json";
    public final static String GET_BILLING_INFO = "/api/billings/get_billing_info.json";
    public final static String UPDATE_COIN = "/api/users/update_coin.json";
    public final static String UPDATE_PUSH_SETTING = "/api/pushs/update_push_setting.json";
    public final static String UPDATE_PUSH_FOLLOW = "/api/pushs/update_push_follow.json";
    public final static String UPDATE_FAVORITE_STATUS = "/api/commons/update_favourite_status.json";
    public final static String GET_CHAT_LIST = "/api/chats/get_chat_list.json";
    public final static String INSERT_MY_CHAT = "/api/chats/insert_my_chat.json";
    public final static String CHANGE_EMAIL = "/api/users/change_email.json";
    public final static String REGIST_PUSH_TOKEN = "/api/pushs/regist_push_token.json";
    public final static String REGIST_INFO_LOGIN = "/api/users/regist_info_login.json";
    public final static String UPDATE_MY_COIN = "/api/users/update_my_coin.json";

    public final static String WV_GL004 = BASE_URL + "/webview/index.html#term_of_service";
    public final static String WV_GL005 = BASE_URL + "/webview/index.html#privacy_policy";
    public final static String WV_GL028 = BASE_URL + "/webview/index.html#help";
    public final static String WV_GL030 = BASE_URL + "/webview/index.html#law";
    public final static String WV_GL031 = BASE_URL + "/webview/index.html#settlement";
    public final static String WV_GL032 = BASE_URL + "/webview/index.html#company_profile";
    public final static String WV_GL037 = BASE_URL + "/webview/index.html#how_to";
}
