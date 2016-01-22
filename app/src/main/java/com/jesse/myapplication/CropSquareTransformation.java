package com.jesse.myapplication;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

/**
 * 作者：jesse
 * 创建时间：2016 2016/1/22 21:19
 * 联系邮箱：774202859@qq.com
 */
public class CropSquareTransformation implements Transformation {

    //截取从宽度和高度最小作为bitmap的宽度和高度
    @Override
    public Bitmap transform(Bitmap source) {
        int size=Math.min(source.getWidth(),source.getHeight());
        int x=(source.getWidth()-size)/2;
        int y=(source.getHeight()-size)/2;
        Bitmap result=Bitmap.createBitmap(source,x,y,size,size);
        if (result!=source){
            source.recycle();//释放bitmap
        }
        return result;
    }

    @Override
    public String key() {
        return "square()";
    }
}
