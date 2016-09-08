package com.wangl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangl.model.Book;
import com.wangl.model.User;
import com.wangl.mylibrary.util.JsonUtil;
import com.wangl.mylibrary.util.MyToast;
import com.wangl.mylibrary.util.OkhttpUtil;
import com.wangl.mylibrary.util.PicassoUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.book)
    TextView book;
    @BindView(R.id.user_tv)
    TextView userTv;
    private String url = "https://api.github.com/search/users";
    private String imgurl = "http://www.dabaoku.com/sucaidatu/dongwu/chongwujingling/902438.JPG";

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
        //加载网络图片
        PicassoUtil.setImg(MainActivity.this,imgurl,R.mipmap.ic_launcher,iv);
        //加载网络数据
        OkhttpUtil.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MyToast.show(MainActivity.this,"请求失败");
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                json = response.body().string();
                Log.i("url",json);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(json);
                    }
                });
            }
        });
        //以map形式封装json数据
        /*Map map = new HashMap();
        map.put("name","张三");
        map.put("age",23);
        map.put("gander","男");
        String json = JsonUtil.getJsonString(map);
        Log.i("json",json);*/
        //以list形式封装json数据
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 23, "男"));
        list.add(new User("李四", 25, "男"));
        list.add(new User("王小花", 22, "女"));
        String json = JsonUtil.getListToJson(list);
        Log.i("json", json);
        userTv.setText(json);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java", 35.00));
        bookList.add(new Book("Android", 55.50));
        String bookJson = JsonUtil.getListToJson(bookList);
        book.setText(bookJson);
    }

    @OnClick({R.id.btn_pic, R.id.btn_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pic:
                MyToast.show(MainActivity.this, "加载图片按钮");
                break;
            case R.id.btn_text:
                MyToast.show(MainActivity.this, "获取网络数据按钮");
                break;
        }
    }
}
