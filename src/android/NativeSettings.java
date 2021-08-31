/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.nativesettings;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import android.provider.Settings;

import android.os.Build;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class NativeSettings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Context context=this.cordova.getActivity().getApplicationContext();
        PluginResult.Status status = PluginResult.Status.OK;
        Uri packageUri = Uri.parse("package:" + this.cordova.getActivity().getPackageName());
        String result = "";

        //Information on settings can be found here:
        //http://developer.android.com/reference/android/provider/Settings.html
		
		action = args.getString(0);
		Intent intent = null;

        if (action.equals("wifi")) {
        	intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
        }
        
        if(args.length() > 1 && args.getBoolean(1)) {
        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        this.cordova.getActivity().startActivity(intent);
        
        callbackContext.sendPluginResult(new PluginResult(status, result));
        return true;
    }
}

