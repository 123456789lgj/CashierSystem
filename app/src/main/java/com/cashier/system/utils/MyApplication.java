package com.cashier.system.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;

/**
 * Created by zhengping on 2017/2/7,10:15.
 * <p>
 * 1、生命周期长  （内存泄露）
 * 2、单例（一个进程有一个实例对象）
 * 3、onCreate方法可以认为是一个应用程序的入口
 * <p>
 * 注意：千万别忘了在清单文件中注册
 */

public class MyApplication extends Application {

    public static int mainThreadId;
    public static Handler handler;
    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //context   new View   Toast  Dialog的context不能是applicationContext
        //1、初始化全局Context
        applicationContext = getApplicationContext();
        //2、创建主线程的handler
        handler = new Handler();
        mainThreadId = Process.myTid();//myTid这个方法在哪个方法中被调用，它的返回值就是这个方法所在线程的线程id

    }
}
