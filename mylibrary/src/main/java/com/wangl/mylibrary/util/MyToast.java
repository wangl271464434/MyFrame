package com.wangl.mylibrary.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/15 0015.
 * 自己写的Toast
 */

public class MyToast {
    public static void show(Context context,String string){
        Toast.makeText(context, string,Toast.LENGTH_SHORT).show();
    }
    public static void show(Context context,int resId){
        Toast.makeText(context, resId,Toast.LENGTH_SHORT).show();
    }
}
