package com.cashier.system.constant;

import com.cashier.system.CashierApplication;
import com.cashier.system.utils.PrefUtils;

public class Constant {
    public static String BASE_URL = "http://retail.ztydt.com/";
    public static final int flag = 1; //0是测试，1是正式
    public static final String URL = flag == 0 ? "http://ls.pehw.vip/" : "http://" + PrefUtils.getString(CashierApplication.mApplicationContext,"url", "");
    public static final String CONSTANT = URL;
}
