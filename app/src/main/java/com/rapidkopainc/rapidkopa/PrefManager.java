package com.rapidkopainc.rapidkopa;

import android.content.Context;
import android.content.SharedPreferences;


public class PrefManager {
    SharedPreferences pref2;
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;

    Context _context;
    Context _context2;
    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "lends-welcome";
    String TILLNUMBER ;
    private static final String COMPANYNAME = "";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;

        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
    public void settill(Integer till) {
        editor.putInt(TILLNUMBER, till);
        editor.commit();
    }
    public void setcompanyname(String companyname) {

        editor.putString(COMPANYNAME, companyname);
        editor.commit();
    }

    public void setMaxAmount(int maxamount) {
        editor.putInt("maxamount", maxamount);
        editor.apply();

    }
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
//    public int gettill() {
//        return pref.getInt(TILLNUMBER, 0);
//    }
    public String getcompany() {
        return pref.getString(COMPANYNAME, "");
    }
}
