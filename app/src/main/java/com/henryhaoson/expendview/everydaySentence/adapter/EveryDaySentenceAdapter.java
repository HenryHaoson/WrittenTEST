package com.henryhaoson.expendview.everydaySentence.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.henryhaoson.expendview.R;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
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
       Log.i("recyclerView","onCreateViewHolder");
        return new EverydaySentenceHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_everyday_sentence, parent,false));
    }

    @Override
    public void onBindViewHolder(EverydaySentenceHolder holder, int position) {
        Log.i("recyclerView","onBindViewHolder");
//        Glide.with(mContext).load(picList[position])
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .error(R.drawable.default_pic)
//                .into(holder.everydayPic);
        Glide.with(mContext)
                .load(picList[position])
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .error(R.drawable.default_pic)
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
