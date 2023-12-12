package com.cashier.system.network;

import android.util.ArrayMap;

import com.cashier.system.BuildConfig;
import com.cashier.system.constant.Constant;
import com.cashier.system.utils.LgjLog;
import com.cashier.system.utils.PrefUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static volatile RetrofitUtil instance;
    private Retrofit retrofit;

    private ArrayMap<String, Object> map = new ArrayMap<>();

    public RetrofitUtil() {
        initRetrofit();
    }

    private void initRetrofit() {
        //配置超时时间等信息
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (LgjLog.IS_OPEN) {
            httpClient.addInterceptor(logging);
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }

    private static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    RetrofitUtil temp = new RetrofitUtil();
                    instance = temp;
                }
            }
        }
        return instance;
    }

    public <T> T getService(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("clazz cannot be empty");
        }
        String canonicalName = clazz.getCanonicalName();
        Object obj = map.get(canonicalName);
        if (obj != null) {
            map.put(canonicalName, obj);
            return (T) obj;
        }
        T t = retrofit.create(clazz);
        return t;
    }
}
