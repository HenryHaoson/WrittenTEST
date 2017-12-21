package com.henryhaoson.expendview;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :Glide配置类
 */

public class HenryGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置缓存大小
        int size = 250 * 1024 * 1024;
        //获取SD路径
        String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String dir = sdcardPath+"/Android/data/com/henry/expendView/images";
        builder.setDiskCache(new DiskLruCacheFactory(dir, size));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
