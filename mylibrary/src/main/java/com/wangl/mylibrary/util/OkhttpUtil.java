package com.wangl.mylibrary.util;

import android.content.Context;

import com.wangl.mylibrary.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/15 0015.
 * 自己对okhttp网络请求进行的进一步处理，
 * 通过实现Result接口的方法来对网络请求的数据进行进一步处理，
 * 或者更新UI
 */

public  class OkHttpUtil {
    private static OkHttpClient client = new OkHttpClient();
//    static Result result;
    //get请求
    public static void get(String path, final int code, final Result result, final Context context){
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               result.result(context.getResources().getString(R.string.error), 0);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                result.result(s,code);
            }
        });
    }
    //需要实现的接口,解析数据更新UI等操作,该方法是运行在子线程中
    public interface Result{
        void result(String s, int code);
    }
    //post请求
    public static void post(String path, final int code, RequestBody body, final Result result, final Context context){
        Request request = new Request.Builder().url(path).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                result.result(context.getResources().getString(R.string.error),0);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                result.result(s,code);
            }
        });
    }
}
