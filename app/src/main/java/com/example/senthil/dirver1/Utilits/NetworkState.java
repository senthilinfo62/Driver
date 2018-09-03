package com.example.senthil.dirver1.Utilits;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkState {
    // ---Initializing context---
    private Context myContext;

    // ---Declaring constructor---
    public NetworkState(Context aApplicationContext) {
        // ---Assigning context----
        this.myContext = aApplicationContext;
    }

    // ---Function to check network available or not---
    public final boolean isInternetOn() {
        // ---Initializing connection manager to get network status---
        ConnectivityManager aConnectManager = (ConnectivityManager) myContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // ---Checking network connection available or not---
        if ((aConnectManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED)
                || (aConnectManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING)
                || (aConnectManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING)
                || (aConnectManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)) {
            // ---Returning boolean true to indicating network available---
            return true;
        } else if ((aConnectManager.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED)
                || (aConnectManager.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED)) {
            // ---Returning boolean false to indicating network not available---
            return false;
        }
        return false;
    }

    // Get the Network information
    public String getConnectivityStatusString(Context context) {
        String aNetStatus = "NOT_CONNECTED";
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if ((null != activeNetwork)
                    && (activeNetwork.isConnectedOrConnecting())) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    aNetStatus = "WIFI";
                    return aNetStatus;
                }
                if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    aNetStatus = "MOBILE";
                    return aNetStatus;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return aNetStatus;
    }
}
