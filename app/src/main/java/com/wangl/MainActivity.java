package com.wangl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangl.mylibrary.util.MyToast;
import com.wangl.mylibrary.util.OkhttpUtil;
import com.wangl.mylibrary.util.PicassoUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.text)
    TextView text;
    private String url = "https://api.github.com/search/users";
    private String imgurl = "https://avatars.githubusercontent.com/u/383316?v=3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    String json;
    @Override
    protected void onResume() {
        super.onResume();
        PicassoUtil.setImg(MainActivity.this,imgurl,R.mipmap.ic_launcher,iv);
        OkhttpUtil.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                json = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(json);
                    }
                });
            }
        });

    }

    @OnClick({R.id.btn_pic, R.id.btn_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pic:
                MyToast.show(MainActivity.this,"加载图片按钮");
                break;
            case R.id.btn_text:
                MyToast.show(MainActivity.this,"获取网络数据按钮");
                break;
        }
    }
}
