package com.example.galming_android.ui.retro.clases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Login
{
    private SharedPreferences prefs;


    public Login (Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUsuId(int usuId) {
        prefs.edit().putInt("usuId", usuId).commit();
    }

    public int getUsuId() {
        int usuId = prefs.getInt("usuId", -1);
        return usuId;
    }
}
