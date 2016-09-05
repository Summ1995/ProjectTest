package com.example.tianjun.projecttest.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求框架
 * Created by xx on 2016/9/5.
 */
public class HttpRequest {
    public static HttpService mService;
    public static final String BASE_URL = "http://atp.fulishe.com/ClientApi";

    public static HttpService getHttpService(){
        if (mService == null){
            Retrofit build = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mService = build.create(HttpService.class);
        }
        return mService;
    }
}
