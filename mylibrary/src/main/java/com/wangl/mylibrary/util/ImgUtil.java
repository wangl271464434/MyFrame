package com.wangl.mylibrary.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by app on 2016/6/20.
 * 图片工具类
 */
public class ImgUtil {
    /**把图片按照指定宽高进行缩放*/
    public static Bitmap zoomImg(Bitmap bitmap,int newWidth,int newHeight){
        //获取图片的宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //计算缩放比例
        float scaleWidth = ((float)newWidth)/width;
        float scaleHeight = ((float)newHeight)/height;
        //取得想要缩放的参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth,scaleHeight);
        //得到新的图片
        Bitmap newBitmap = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        return newBitmap;
    }
    /**
     *
     * @param imgPath
     * @param bitmap
     * @param imgFormat 图片格式
     * @return
     */
    public static String imgToBase64(String imgPath, Bitmap bitmap,String imgFormat) {
        if (imgPath !=null && imgPath.length() > 0) {
            bitmap = readBitmap(imgPath);
        }
        if(bitmap == null){
            //bitmap not found!!
        }
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            byte[] imgBytes = out.toByteArray();
            return Base64.encodeToString(imgBytes, Base64.DEFAULT);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        } finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private static Bitmap readBitmap(String imgPath) {
        try {
            return BitmapFactory.decodeFile(imgPath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }

    }
    public static void savePhotoToSDcard(String path,String fileName,Bitmap bitmap){
        //创建一个文件夹
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //在指定目录下创建文件
        File file = new File(path,fileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            if (bitmap!=null){
                if (bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream)){
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            file.delete();
            e.printStackTrace();
        } catch (IOException e) {
            file.delete();
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
