package com.wangl.mylibrary.util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by XANINFO02 on 2016/9/4.
 * 自定义okhttp网络请求
 */
public class OkhttpUtil {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    //post请求,返回json数据
    public static void post(String url, RequestBody body,Callback callback){
        Request  request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //get请求,返回json数据
    public static void get(String url,Callback callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
