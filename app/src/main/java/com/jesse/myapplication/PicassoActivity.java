package com.jesse.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {
    String url="https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3c03a127ca177f3e0f34fb0d40ce3bb9/faedab64034f78f01afda9627a310a55b2191ca8.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        assignViews();
        initPicasso();
    }

    private void initPicasso() {
        //加载图片
        Picasso.with(this).load(url).into(mIv);
        //mIv2控件不能设置成wrap_content,也就是必须有大小才行,fit()才让图片的宽高等于mIv2的宽高，设置fit()，不能再调用resize()
        Picasso.with(this).load(url).fit().into(mIv2);
        //将加载的图片指定高宽显示
        Picasso.with(this).load(url).resize(200, 300).centerCrop().into(mIv3);
        //将加载的图片进行截取显示
//        Picasso.with(this).load(url).transform(new CropSquareTransformation()).into(mIv3);
        //默认显示placeholder，加载错误显示ic_launcher
//        Picasso.with(this).load(url).placeholder(R.mipmap.placeholder).error(R.mipmap.ic_launcher).into(mIv4);
        //默认显示placeholder，加载错误显示ic_launcher，指定placeholder大小显示
        Picasso.with(this).load(url).placeholder(R.mipmap.placeholder).fit().error(R.mipmap.ic_launcher).into(mIv4);
    }

    private ImageView mIv;
    private ImageView mIv2;
    private ImageView mIv3;
    private ImageView mIv4;
    private void assignViews() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIv2 = (ImageView) findViewById(R.id.iv2);
        mIv3 = (ImageView) findViewById(R.id.iv3);
        mIv4 = (ImageView) findViewById(R.id.iv4);
    }
}
