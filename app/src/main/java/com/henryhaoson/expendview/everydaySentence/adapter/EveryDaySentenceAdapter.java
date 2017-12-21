package com.henryhaoson.expendview.everydaySentence.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.henryhaoson.expendview.R;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :每日一句适配器
 */

public class EveryDaySentenceAdapter extends RecyclerView.Adapter<EverydaySentenceHolder> {
    private String[] picList;
    private Context mContext;

    public EveryDaySentenceAdapter(Context context, String[] list) {
        mContext = context;
        picList = list;
    }


    @Override
    public EverydaySentenceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("recyclerView", "onCreateViewHolder");
        return new EverydaySentenceHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_everyday_sentence, parent, false));
    }

    @Override
    public void onBindViewHolder(final EverydaySentenceHolder holder, int position) {
        Log.i("recyclerView", "onBindViewHolder");
//        Glide.with(mContext).load(picList[position])
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .error(R.drawable.default_pic)
        loadImage(holder,position);
    }

    /**
     * 实现有重新加载机制的图片加载方式
     * @param holder
     * @param position
     */
    private void loadImage(final EverydaySentenceHolder holder, final int position){
        holder.everydayPic.setClickable(false);
        Glide.with(mContext)
                .load(picList[position])
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .error(R.drawable.default_pic)
                .listener(new RequestListener<String, GlideDrawable>() {
                    /**
                     * 监听Glide加载失败的情况，设置ImageView为可点击，实现点击重新加载。
                     */
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        holder.everydayPic.setClickable(true);
                        holder.everydayPic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                loadImage(holder,position);
                            }
                        });
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.everydayPic);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return picList.length;
    }
}
