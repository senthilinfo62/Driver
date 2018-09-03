package com.example.senthil.dirver1.Utilits;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceUtil {

    private static final String DEALMOON_PREFERENCE = "DEALMOON_PREFERENCE";
    private static final String DEALMOON_USER_ID = "user_id";
    private static final String DEALMOON_PASSWORD = "password";
    private static final String DEALMOON_EMAIL_ID = "email_id";
    private static final String IS_LOGIN_FLAG = "login_flag";
    private static final String IS_FIRST_LOGIN_FLAG = "first_login_flag";
    private static final String DEALMOON_USER_NAME = "user_name";
    private static final String DEALMOON_FACEBOOK_ACCESS_TOKEN = "fb_access_token";
    private static  final String DealMoon_userImage="image";

    public static String getDealmoonUserId(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DEALMOON_USER_ID, "");
    }

    public static void saveDealmoonUserId(Context context, String id) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEALMOON_USER_ID, String.valueOf(id));
        editor.commit();
    }

    public static String getDEALMOON_FACEBOOK_ACCESStOKEN(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DEALMOON_FACEBOOK_ACCESS_TOKEN, null);
    }

    public static void saveDEALMOON_FACEBOOK_ACCESStOKEN(Context context, String id) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEALMOON_FACEBOOK_ACCESS_TOKEN, String.valueOf(id));
        editor.commit();
    }

    public static String getDealmoonPassword(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DEALMOON_PASSWORD, "");
    }

    public static void saveDealmoonPassword(Context context, String id) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEALMOON_PASSWORD, id);
        editor.commit();
    }

    public static String getDealmoonUserName(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DEALMOON_USER_NAME, "");
    }

    public static void saveDealmoonUserName(Context context, String id) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEALMOON_USER_NAME, id);
        editor.commit();
    }

    public static String getDealmoonEmailId(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DEALMOON_EMAIL_ID, "");
    }

    public static void saveDealmoonEmailId(Context context, String emailId) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DEALMOON_EMAIL_ID, emailId);
        editor.commit();
    }

    public static boolean getIsLoginFlag(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getBoolean(IS_LOGIN_FLAG, false);
    }

    public static void setLoginFlag(Context context, boolean isLogin) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGIN_FLAG, isLogin);
        editor.commit();
    }

    public static boolean getIsFirstLoginFlag(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getBoolean(IS_FIRST_LOGIN_FLAG, false);
    }

    public static void setFirstLoginFlag(Context context, boolean isLogin) {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_LOGIN_FLAG, isLogin);
        editor.commit();
    }

    public static void setImagepath(Context context, String imagepath)
    {
        SharedPreferences preferences = context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DealMoon_userImage, imagepath);
        editor.commit();
    }

    public static String getDealMoon_userImage(Context context) {
        return context.getSharedPreferences(DEALMOON_PREFERENCE, Context.MODE_PRIVATE).getString(DealMoon_userImage, "");
    }
}
