package com.cashier.system.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.view.View;
import android.widget.Toast;

import com.cashier.system.CashierApplication;

/**
 * Created by zhengping on 2017/2/7,10:34.
 * 处理和ui操作相关的工具类
 */

public class UiUtils {
    private static Handler sSubThreadHandler;
    private static HandlerThread sWorkThread;

    //体现分层思想，分层思想的好处
    //获取全局的context
    public static Context getContext() {
        return CashierApplication.mApplicationContext;
    }

    public static Handler getMainThreadHandler() {
        return MyApplication.handler;
    }

    public static Handler getSubThreadHandler() {
        if (sSubThreadHandler == null) {
            synchronized (UiUtils.class) {
                if (sSubThreadHandler == null) {
                    sWorkThread = new HandlerThread("work-thread");
                    sWorkThread.start();
                    sSubThreadHandler = new Handler(sWorkThread.getLooper());
                }
            }
        }
        return sSubThreadHandler;
    }

    public static int getMainThreadId() {
        return MyApplication.mainThreadId;
    }


    //获取字符串
    public static String getString(int resId) {
        return getContext().getResources().getString(resId);
    }

    //获取字符串数组
    public static String[] getStringArray(int resId) {
        return getContext().getResources().getStringArray(resId);
    }
    //获取Drawable
    public static Drawable getDrawable(int resId) {
        return getContext().getResources().getDrawable(resId);
    }
    //获取颜色
    public static int getColor(int resId) {
        return getContext().getResources().getColor(resId);
    }

    //获取颜色的状态选择器
    public static ColorStateList getColorStateList(int resId) {
        return getContext().getResources().getColorStateList(resId);

    }
    //获取dimen
    public static int getDimen(int resId){
        return getContext().getResources().getDimensionPixelSize(resId);
    }

    //dip2px
    public static int dip2px(int dip) {
        float density = getContext().getResources().getDisplayMetrics().density;//设备密度  2  3
        return (int) (dip * density + 0.5f);
    }

    //px2dip
    public static int px2dip(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;//设备密度  2  3
        return (int) (px / density + 0.5f);
    }

    public static void toast(final String msg) {
        //Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //判断是否是主线程
    public static boolean isRunOnUiThread() {
        //方法1
        /*if(Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        } else {
            return false;
        }*/
        int mainThreadId = getMainThreadId();
        int currentThreadId = Process.myTid();
        return mainThreadId == currentThreadId;
    }
    //保证一段代码一定是在主线程中运行的
    //Runnable:任务
    //Thread：线程
    //Process：进程
    public static void runOnUiThread(Runnable r) {
        if(isRunOnUiThread()) {
            r.run();
        }else {
            //子线程
            getSubThreadHandler().post(r);//将r丢到主线程的消息队列
        }
    }

    public static void runOnSubThread(Runnable r) {
        getSubThreadHandler().post(r);//将r丢到主线程的消息队列
    }

    public static void stopSubThread() {
        if (sSubThreadHandler == null) {
            return;
        }
        sWorkThread.quit();
        sSubThreadHandler = null;
        sWorkThread = null;
    }

    public static View inflateView(int layoutResId) {
        return View.inflate(getContext(), layoutResId, null);
    }


}
