package com.wangl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangl.model.Book;
import com.wangl.model.User;
import com.wangl.mylibrary.util.GlideUtil;
import com.wangl.mylibrary.util.GsonUtil;
import com.wangl.mylibrary.util.MyToast;
import com.wangl.mylibrary.util.OkHttpUtil;
import com.wangl.mylibrary.util.PicassoUtil;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity implements OkHttpUtil.Result {

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
    @Override
    protected void onResume() {
        super.onResume();
        //以list形式封装json数据
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 23, "男"));
        list.add(new User("李四", 25, "男"));
        list.add(new User("王小花", 22, "女"));
        String json = GsonUtil.listToJson(list);
        Log.i("json", json);
        userTv.setText(json);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java", 35.00));
        bookList.add(new Book("Android", 55.50));
        String bookJson = GsonUtil.listToJson(bookList);
        book.setText(bookJson);
    }

    @OnClick({R.id.btn_pic, R.id.btn_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pic:
                MyToast.show(MainActivity.this, "加载图片按钮");
                //加载网络图片
                GlideUtil.setCircleImgView(getApplicationContext(),iv,0,imgurl);
                break;
            case R.id.btn_text:
                MyToast.show(MainActivity.this, "获取网络数据按钮");
                //加载网络数据
                OkHttpUtil.get(url,Contans.sccuess,this,this);
                break;
        }
    }

    @Override
    public void result(final String s, final int code) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (code){
                    case Contans.sccuess:
                        text.setText(s);
                        break;
                    default:
                        MyToast.show(getApplicationContext(),s);
                        break;
                }
            }
        });
    }
}
