package com.henryhaoson.expendview.everydaySentence.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.henryhaoson.expendview.R;

import java.util.List;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class EveryDaySentenceAdapter extends RecyclerView.Adapter<EverydaySentenceHolder> {
    private List<String> picList;
    private Context mContext;

    public EveryDaySentenceAdapter(Context context, List<String> list) {
        mContext = context;
        picList = list;
    }


    @Override
    public EverydaySentenceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EverydaySentenceHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_everyday_sentence, null));
    }

    @Override
    public void onBindViewHolder(EverydaySentenceHolder holder, int position) {
        Glide.with(mContext).load(picList.get(position)).
                skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.everydayPic);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return picList.size();
    }
}
