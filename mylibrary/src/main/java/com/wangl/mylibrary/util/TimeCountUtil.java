package com.wangl.mylibrary.util;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by wanglei on 2016/7/14.
 * 倒计时
 */
public class TimeCountUtil extends CountDownTimer{
   private Button view;
    public TimeCountUtil(long millisInFuture, long countDownInterval, Button view) {
        super(millisInFuture, countDownInterval);
        this.view = view;
    }
    @Override
    public void onTick(long l) {
        //计时过程
        view.setClickable(false);//防止重复点击
        view.setText(l/ 1000 + "s");
    }

    @Override
    public void onFinish() {
        //计时完毕
        view.setText("获取验证码");
        view.setClickable(true);
    }
}
