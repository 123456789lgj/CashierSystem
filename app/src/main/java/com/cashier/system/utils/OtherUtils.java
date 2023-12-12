package com.cashier.system.utils;

import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;

import com.cashier.system.CashierApplication;


/**
 * Created by xon 2016/9/14.
 * desc:通用的,零散的方法
 */
public class OtherUtils {
    private static final String TAG = "OtherUtils";
    private static int[] mWindowArr = new int[2];

    /**
     * dip转px
     */
    public static int dip2px(int dip) {
        final float scale = CashierApplication.mApplicationContext.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * dip转px
     */
    public static int dip2px(Context context, int dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * dip转px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * dip转px
     */
    public static float dip2pxFloat(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }

    /**
     * px转dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        //pxValue=dpValue * scale + 0.5f
        return (int) (pxValue / scale);
    }


    public static String getDeviceId() {
//        return "b92301898d4d9f27";
//        return Settings.System.getString(YKTApplication.getInstance().getContentResolver(), Settings.System.ANDROID_ID);
        return Settings.System.getString(CashierApplication.mApplicationContext.getContentResolver(), Settings.System.ANDROID_ID);
    }

    private static int[] initWindow() {
        WindowManager wm = (WindowManager) CashierApplication.mApplicationContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        mWindowArr[0] = width;
        mWindowArr[1] = height;
        LgjLog.i(TAG, "width :" + width + "height :" + height);
        return mWindowArr;
    }

    public static int[] getWindowWidthAndHeight() {
        if (mWindowArr[0] == 0 || mWindowArr[1] == 0) {
            return initWindow();
        }
        return mWindowArr;
    }

    public static int getWindowHeight() {
        if (mWindowArr[0] == 0 || mWindowArr[1] == 0) {
            initWindow();
        }
        return mWindowArr[1];
    }

    public static int getWindowWidth() {
        if (mWindowArr[0] == 0 || mWindowArr[1] == 0) {
            initWindow();
        }
        return mWindowArr[0];
    }

    public static int getColor(int resId) {
        return CashierApplication.mApplicationContext.getResources().getColor(resId);
    }
}
