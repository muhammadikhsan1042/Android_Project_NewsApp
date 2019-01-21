package com.example.newsapp.Classes;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    public static final String SS_NEWS_APP = "ssNewsApp";

    public static final String SS_IDUSER= "spIdUser";
    public static final String SS_FULLNAME = "spFullname";
    public static final String SS_USERNAME = "spUsername";
    public static final String SS_ACCESS = "spAccess";

    public static final String SS_ALREADY_LOGINADMIN = "spAlreadyLoginAdmin";
    public static final String SS_ALREADY_LOGINREADER = "spAlreadyLoginReader";

    SharedPreferences ss;
    SharedPreferences.Editor ssEditor;

    public SharedPrefManager(Context context){
        ss = context.getSharedPreferences(SS_NEWS_APP, Context.MODE_PRIVATE);
        ssEditor = ss.edit();
    }

    public void saveSPString(String keySP, String value){
        ssEditor.putString(keySP, value);
        ssEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        ssEditor.putInt(keySP, value);
        ssEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        ssEditor.putBoolean(keySP, value);
        ssEditor.commit();
    }

    public String getSpBeritafirasApp() {
        return SS_NEWS_APP;
    }

    public String getSpIduser() {
        return ss.getString(SS_IDUSER, "");
    }

    public String getSpFullname() {
        return ss.getString(SS_FULLNAME, "");
    }

    public String getSpUsername() {
        return ss.getString(SS_USERNAME, "");
    }

    public Boolean getSpAlreadyLoginAdmin() {
        return ss.getBoolean(SS_ALREADY_LOGINADMIN, false);
    }

    public Boolean getSpAlreadyLoginReader() {
        return ss.getBoolean(SS_ALREADY_LOGINREADER, false);
    }

    public String getSpAccess() {
        return ss.getString(SS_ACCESS, "");
    }
}
