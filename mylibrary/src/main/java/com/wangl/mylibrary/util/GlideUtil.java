package com.wangl.mylibrary.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangl.mylibrary.view.GlideCircleTransform;


/**
 *
 * 通过第三方图片处理库glide来对图片进行的处理
 * */
public class GlideUtil {
    public static void setCircleImgView(Context context, ImageView imageView,int error,int resId){
        Glide.with(context)
                .load(resId)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
//                .transform(new GlideRoundTransform(context,20))//圆角图片
                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
    public static void setCircleImgView(Context context, ImageView imageView,int error,String url){
        Glide.with(context)
                .load(url)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
//                .transform(new GlideRoundTransform(context,20))//圆角图片
                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
    public static void setImgView(Context context, ImageView imageView,int error,int resId){
        Glide.with(context)
                .load(resId)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
//                .transform(new GlideRoundTransform(context,20))//圆角图片
//                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
    public static void setImgView(Context context, ImageView imageView,int error,int resId,int width,int height){
        Glide.with(context)
                .load(resId)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
                .override(width,height)
//                .transform(new GlideRoundTransform(context,20))//圆角图片
//                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
    public static void setImgView(Context context, ImageView imageView,int error,String imgurl,int width,int height){
        Glide.with(context)
                .load(imgurl)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
                .override(width,height)
//                .transform(new GlideRoundTransform(context,20))//圆角图片
//                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
    public static void setImgView(Context context, ImageView imageView,int error,String imgurl){
        Glide.with(context)
                .load(imgurl)
//                .placeholder(R.mipmap.ic_launcher) //占位符 也就是加载中的图片，可放个gif
                .error(error) //失败图片
//                .transform(new GlideRoundTransform(context,20))//圆角图片
//                .transform(new GlideCircleTransform(context))//圆形图片
                .into(imageView);
    }
}
