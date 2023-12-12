package com.cashier.system.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by lgj on 2017/1/15.
 */

public class ToastUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    public static void showToast(final Context ctx, final String content){
        if (Looper.getMainLooper() == Looper.myLooper()){
            Toast.makeText(ctx,content,Toast.LENGTH_SHORT).show();
        }else {
            sHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ctx,content,Toast.LENGTH_SHORT).show();
                }
            });
//            sHandler.p
        }
    }

}
