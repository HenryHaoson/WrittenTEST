package com.henryhaoson.expendview.read.ui.WordExplainView;

import android.os.Bundle;
import android.widget.TextView;

import com.henryhaoson.expendview.R;
import com.henryhaoson.expendview.read.ui.WordExplainView.presenter.WordExplainPresenter;
import com.henryhaoson.expendview.read.ui.WordExplainView.view.WordExplainView;

import cn.henryzhuhao.mainframe.frame.base.BaseFragment;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public class WordExplainFragment extends BaseFragment implements WordExplainView {
    public int mHeight = 0;

    private TextView word;
    private TextView soundMark;
    private TextView explain;

    private WordExplainPresenter presenter;
    @Override
    public void initView() {
        if (mHeight != 0) {
            view.getLayoutParams().height = mHeight;
        }

        word=view.findViewById(R.id.word_explain_word);
        soundMark=view.findViewById(R.id.word_explain_sound_mark);
        explain=view.findViewById(R.id.word_explain_explain);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showLoadingContentView() {

    }

    @Override
    public void removeLoadingContentView() {

    }

    @Override
    public void initPresenter() {
        presenter=new WordExplainPresenter(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_word_explain;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    @Override
    public void getExplainSucceed(String word, String soundMark, String soundUrl, String explain) {

    }

    @Override
    public void getExplainFailed(String error) {

    }
}
