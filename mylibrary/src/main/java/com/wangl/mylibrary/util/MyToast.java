package com.wangl.mylibrary.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by XANINFO02 on 2016/9/4.
 */
public class MyToast {
    public static void show(Context context,String string){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
