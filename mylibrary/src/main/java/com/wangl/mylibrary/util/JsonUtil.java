package com.wangl.mylibrary.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by XANINFO02 on 2016/9/8.
 * json工具类
 */
public class JsonUtil {
    private static String json;
    //将map转化成json字符串
    public static String getJsonString(Map map){
        Gson gson = new Gson();
        json = gson.toJson(map);
        return json;
    }
    //将list转化成json字符串
    public static String getListToJson(List list){
        Gson gson = new Gson();
        json = gson.toJson(list);
        return json;
    }
}
