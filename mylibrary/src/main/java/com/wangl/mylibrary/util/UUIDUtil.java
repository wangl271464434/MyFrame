package com.wangl.mylibrary.util;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/6 0006.
 * 用来获取手机唯一标识的工具类
 */

public class UUIDUtil {
    public static String getIMEI(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELECOM_SERVICE);
        String s = tm.getDeviceId();
        return s;
    }
    public static String getUUID(Activity activity){
        final TelephonyManager tm = (TelephonyManager) activity.getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = ""+tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(activity.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uuid = deviceUuid.toString();
        return uuid;
    }
}
