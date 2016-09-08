package com.wangl.mylibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by XANINFO02 on 2016/9/4.
 * 自己定义的图片加载工具
 */
public class PicassoUtil {
    //加载本地图片
    public static void setImg(Context context, int resId, ImageView imgView){
        Picasso.with(context)
                .load(resId)
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .fit()
                .into(imgView);
    }
    //按照一定的宽高加载本地图片，带有加载错误和默认图片
    public static void setImg(Context context,int resId,ImageView imgView,int weight,int height){
        Picasso.with(context)
                .load(resId)//加载本地图片
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .resize(weight,height)//设置图片的宽高
                .into(imgView);//把图片加载到控件上
    }
    //加载网络图片到imgview,带有加载错误和默认图片
    public static void setImg(Context context, String imgurl, int resId, ImageView imgView){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .placeholder(resId)//默认图片
                .error(resId)//加载错误的图片
                .fit()//图片的宽高等于控件的宽高
                .into(imgView);//把图片加载到控件上
    }
    public static void setImg(Context context, String imgurl, ImageView imgView){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .fit()//图片的宽高等于控件的宽高
                .into(imgView);//把图片加载到控件上
    }
    //加载网络图片到Viewpager
    public static void setImg(Context context, String imgurl, ViewPager imgView){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .fit()//图片的宽高等于控件的宽高
                .into((Target) imgView);//把图片加载到控件上
    }
    //加载网络图片到Viewpager，带有加载错误和默认图片
    public static void setImg(Context context, String imgurl, int resId, ViewPager imgView){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .placeholder(resId)//默认图片
                .error(resId)//加载错误的图片
                .fit()//图片的宽高等于控件的宽高
                .into((Target) imgView);//把图片加载到控件上
    }
    //按照设定的宽高加载网络图片到imgview
    public static void setImg(Context context, String imgurl,ImageView imgView,int weight,int height){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .resize(weight,height)//设置图片的宽高
                .into(imgView);//把图片加载到控件上
    }
    //按照设定的宽高加载网络图片到imgview，带有加载错误和默认图片
    public static void setImg(Context context, String imgurl, int resId,int weight,int height, ImageView imgView){
        Picasso.with(context)
                .load(imgurl)//加载网络图片的url
                .config(Bitmap.Config.RGB_565)//8位RGB位图
                .placeholder(resId)//默认图片
                .error(resId)//加载错误的图片
                .resize(weight,height)//设置图片的宽高
                .into(imgView);//把图片加载到控件上
    }
}
