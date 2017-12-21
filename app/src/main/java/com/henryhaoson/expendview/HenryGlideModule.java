package com.henryhaoson.expendview;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class HenryGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int size = 250 * 1024 * 1024;
//        String dir = "SDCard/Android/data/com/henry/expendView/images";
//        builder.setDiskCache(new DiskLruCacheFactory(dir, size));
//        builder.set
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
