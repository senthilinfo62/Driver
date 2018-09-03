package com.example.senthil.dirver1.Utilits;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;


/**
 * Created by Gnanaprakash. S on 2/29/2016.
 */
public class UtilFile {
    //Camera&Mic permissions
    public static final int ACCESS_DENIED = 0;
    public static final int AUTHORIZED = 1;
    boolean result;

    public static void disconnectFromFacebook(Context context) {

//        if (SharedPreferenceUtil.getDEALMOON_FACEBOOK_ACCESStOKEN(context) == null) {
//            return; // already logged out
//        } else {
//            new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
//                    .Callback() {
//                @Override
//                public void onCompleted(GraphResponse graphResponse) {
//
//                    LoginManager.getInstance().logOut();
//
//                }
//            }).executeAsync();
//        }
    }

    public boolean isInternetAvailable(Context c) {
        ConnectivityManager connectivity = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    //check mobile Network
    public static boolean isConnectionFast(int type, int subType) {
        switch (subType) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return false; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return false; // ~ 14-64 kbps
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return false; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return true; // ~ 400-1000 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return true; // ~ 600-1400 kbps
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return false; // ~ 100 kbps
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return true; // ~ 2-14 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return true; // ~ 700-1700 kbps
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return true; // ~ 1-23 Mbps
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return true; // ~ 400-7000 kbps
            /*
             * Above API level 7, make sure to set android:targetSdkVersion
             * to appropriate level to use these
             */
            case TelephonyManager.NETWORK_TYPE_EHRPD: // API level 11
                return true; // ~ 1-2 Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_B: // API level 9
                return true; // ~ 5 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPAP: // API level 13
                return true; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_IDEN: // API level 8
                return false; // ~25 kbps
            case TelephonyManager.NETWORK_TYPE_LTE: // API level 11
                return true; // ~ 10+ Mbps
            // Unknown
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
            default:
                return false;
        }
    }

    public String internetConnectionType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null || !info.isConnected()) {
            Log.i("TAG", "Internet not connected");
            return "NotConnected"; //not connected
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            Log.i("TAG", "Connected with WiFi");
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo != null) {
                Integer linkSpeed = null; //measured using WifiInfo.LINK_SPEED_UNITS
                linkSpeed = wifiInfo.getLinkSpeed();
                Log.e("WiFi:", String.valueOf(linkSpeed));
            }
            return "Wifi";
        } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            if (info != null && info.isConnected()) {
                isConnectionFast(info.getType(), info.getSubtype());
            }
            Log.i("TAG", "Connected with MobileNetwork");
            return "MobileNetwork";
        }
        Log.i("TAG", "Internet connectivity type - undertermined");
        return "Undetermined";
    }

}
