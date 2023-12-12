package com.cashier.system.utils;

import android.util.Log;

import com.cashier.system.CashierApplication;

public class LgjLog {
    public static final String TAG = "lgj";
    public static boolean IS_OPEN = PrefUtils.getBoolean(CashierApplication.mApplicationContext, "log_is_open", false);

    public static void i(String tag, String msg) {
        if (IS_OPEN) {
            Log.i(TAG + " " + tag + " :", msg);
        }
    }

    public static void d(String tag, String msg) {
        if (IS_OPEN) {
            Log.d(TAG + " " + tag + " :", msg);
        }
    }

    public static void e(String tag, String msg) {
        if (IS_OPEN) {
            Log.e(TAG + " " + tag + " :", msg);
        }
    }
}
