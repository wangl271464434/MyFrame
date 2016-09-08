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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
       /* PicassoUtil.setImg(MainActivity.this,imgurl,R.mipmap.ic_launcher,iv);
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
        });*/
        /*Map map = new HashMap();
        map.put("name","张三");
        map.put("age",23);
        map.put("gander","男");
        String json = JsonUtil.getJsonString(map);
        Log.i("json",json);*/
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 23, "男"));
        list.add(new User("李四", 25, "男"));
        list.add(new User("王小花", 22, "女"));
        String json = JsonUtil.getListToJson(list);
        Log.i("json", json);
        text.setText(json);
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
