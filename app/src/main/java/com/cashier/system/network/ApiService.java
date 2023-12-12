package com.cashier.system.network;

import retrofit2.http.POST;

public interface ApiService {
    @POST("index.php/CashierApi/Login/doLogin_v1")
    void login();
}
