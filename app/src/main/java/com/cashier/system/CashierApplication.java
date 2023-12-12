package com.cashier.system;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

public class CashierApplication extends Application {
    public static Context mApplicationContext;
    public static  int mainThreadId;
    public static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        //线程间通信
        //handler.sendMessage 将一个消息发送到消息队列
        //2、创建主线程的handler
        handler = new Handler();

        //如果在主线程中new出handler，这个handler维护的就是主线程的消息队列
        //如果在子线程中new出handler，这个handler维护的就是子线程的消息队列
        //如何保证handler维护的是主线程的消息队列呢？1、在主线程中直接new  2、任何地方在new的时候，传入参数mainLooper

        /*new Thread(new Runnable() {

            private Handler subThreadHandler;

            @Override
            public void run() {
                //任何一个消息队列都需要轮询器，而轮询器工作起来的前提是调用prepare和loop
                //Looper.prepare();
                subThreadHandler = new Handler();
                //Looper.loop();
            }
        }).start();*/
        //3、获取主线程的线程id
        //判断是否是主线程的方法
        /*if(Looper.myLooper() == Looper.getMainLooper()) {

        } else {
            //子线程
        }*/
        mainThreadId = Process.myTid();//myTid这个方法在哪个方法中被调用，它的返回值就是这个方法所在线程的线程id
    }
}
