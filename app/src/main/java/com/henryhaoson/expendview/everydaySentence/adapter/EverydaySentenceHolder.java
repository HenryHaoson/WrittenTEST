package com.henryhaoson.expendview.everydaySentence.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.henryhaoson.expendview.R;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class EverydaySentenceHolder extends RecyclerView.ViewHolder {
    public ImageView everydayPic;
    public EverydaySentenceHolder(View itemView) {
        super(itemView);
        everydayPic = itemView.findViewById(R.id.item_everyday_sentence_pic);
        //设置初始时为不可点击，为后面点击重新加载做准备。
        everydayPic.setClickable(false);
    }
}
