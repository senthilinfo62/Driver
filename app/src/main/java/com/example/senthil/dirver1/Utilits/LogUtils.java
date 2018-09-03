package com.example.senthil.dirver1.Utilits;

import android.util.Log;

/**
 * Created by sunakshi.r on 4/15/2016.
 */
public class LogUtils {

    private static String LOG_TAG="DealMoon";

    private static boolean enabled;

    public static void i(String tag, String message){
        if(enabled) {
            Log.i(LOG_TAG, tag + " " + message);
        }
    }

    public static void i(String message){
        if(enabled) {
            Log.i(LOG_TAG, message);
        }
    }



    public static void setEnabled(boolean enabled) {
        LogUtils.enabled = enabled;
    }

}
