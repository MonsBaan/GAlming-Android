package com.example.galming_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Sesion {
    private SharedPreferences prefs;

    public Sesion(Context context) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public void setusename(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }
}
