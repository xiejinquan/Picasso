package com.jesse.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jesse.recyclerview.JesseAdapter;
import com.jesse.recyclerview.JesseHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Picture> mDatas;
    private JesseAdapter<Picture> mAdapter;
    private Context mContext=this;
    private Context mTag=mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        assignViews();
        initRecyclerview();
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(MainActivity.this, PicassoActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerview() {
        /** setLayoutManager设置Recyclerview的item的排列方式   true表示从end到start */
        mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));

        mRecyclerview.setAdapter(mAdapter = new JesseAdapter<Picture>(this, R.layout.item_data, mDatas) {
            @Override
            public void onBindView(JesseHolder holder, int position) {
                ImageView iv_data = holder.getView(R.id.iv_data);

                // Get the image URL for the current position.
                String url = mDatas.get(position).getImg();
                // Trigger the download of the URL asynchronously into the image view.
                Picasso.with(mContext)
                        .load(url)
                        .placeholder(R.mipmap.placeholder) //默认显示
                        .error(R.mipmap.ic_launcher)//加载错误显示
                        .fit()//将placeholder高宽作为显示的高宽
                        .tag(mTag)//设tag，解决错位
                        .into(iv_data);

                TextView tv_name = holder.getView(R.id.tv_name);
                tv_name.setText(mDatas.get(position).getName());
            }
        });

        /** Recyclerview的item单击事件 */
        mAdapter.setOnItemClickListener(new JesseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        /**mRecyclerview滑动*/
        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {//滑动停止的时候加载图片
                    Picasso.with(mContext).resumeTag(mTag);
                } else {//滑动时候不加载图片
                    Picasso.with(mContext).pauseTag(mTag);
                }
            }
        });

    }


    String[] urls={
            "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3c03a127ca177f3e0f34fb0d40ce3bb9/faedab64034f78f01afda9627a310a55b2191ca8.jpg",
            "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=4b43caf593dda144c5096bb282b6d009/574e9258d109b3dedb168a8ec8bf6c81810a4cae.jpg",
            "https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=55d241dc5aee3d6d3dc680cb73176d41/96dda144ad345982b658b7e90ff431adcaef84fe.jpg",
            "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd75ccf9acd3fd1f2909a53a004c25ce/c995d143ad4bd1130c0ee8e55eafa40f4afb0521.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/caef76094b36acaf2232c4877fd98d1000e99cfe.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/342ac65c103853430c3ada5a9013b07ecb8088d0.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/574e9258d109b3dedb168a8ec8bf6c81810a4cae.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/622762d0f703918f6f15532c553d269758eec414.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/9345d688d43f8794d4cd21c8d61b0ef41bd53a21.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/8b82b9014a90f603d51af2a13d12b31bb151edaa.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03fe578a5ed03f8794a4c2262c.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/bd3eb13533fa828bf60df405f91f4134970a5a2d.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c65c41402b9f16fdfaaf51671b.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/bf096b63f6246b60fc49d17ce9f81a4c510fa277.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fb871bbd226f224f4a21a4ddd1.jpg",
            "http://a.hiphotos.baidu.com/image/h%3D200/sign=d185d989544e9258b93481eeac83d1d1/b7fd5266d016092473be93f6d60735fae7cd3447.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/377adab44aed2e73e32f15f28501a18b86d6fa2e.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/d833c895d143ad4b9227d41e80025aafa50f06e6.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/8c1001e93901213f6c2cdc0256e736d12e2e95d5.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/8b13632762d0f703147406020afa513d2797c52e.jpg"
    };
    private void initDatas() {
        mDatas=new ArrayList<>();
        for (int i=0;i<urls.length;i++){
            mDatas.add(new Picture("jesse"+i,urls[i]));
        }
    }

    private Toolbar mToolbar;
    private RecyclerView mRecyclerview;

    private void assignViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

}
