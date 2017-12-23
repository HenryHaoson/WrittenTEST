package com.henryhaoson.expendview.read.ui.WordExplainView;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.henryhaoson.expendview.R;
import com.henryhaoson.expendview.read.ui.WordExplainView.presenter.WordExplainPresenter;
import com.henryhaoson.expendview.read.ui.WordExplainView.utils.Player;
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
    public int height = 0;
    String soundUrl;

    private RelativeLayout contentRl;
    private TextView wordTv;
    private TextView soundMarkTv;
    private TextView explainTv;
    private TextView errorTv;
    private TextView loadTv;

    private ImageView sound;

    private Player soundPlayer;

    private WordExplainPresenter presenter;

    public static WordExplainFragment newInstance() {

        Bundle args = new Bundle();

        WordExplainFragment fragment = new WordExplainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView() {
        view.setVisibility(View.INVISIBLE);

        contentRl=view.findViewById(R.id.word_explain_content);
        wordTv = view.findViewById(R.id.word_explain_word);
        soundMarkTv = view.findViewById(R.id.word_explain_sound_mark);
        explainTv = view.findViewById(R.id.word_explain_explain);
        errorTv = view.findViewById(R.id.word_explain_error);
        loadTv = view.findViewById(R.id.word_explain_load);
        sound=view.findViewById(R.id.word_explain_sound);

    }

    public void setWord(String word) {
        presenter.getExplain(word);
        contentRl.setVisibility(View.INVISIBLE);
        errorTv.setVisibility(View.INVISIBLE);
        showLoadingContentView();

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        soundPlayer=new Player();
        wordTv.post(new Runnable() {
            @Override
            public void run() {
                height = view.getHeight();
            }
        });

    }

    @Override
    public void initListener() {
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        soundPlayer.playUrl(soundUrl);
                    }
                }).start();
            }
        });
    }

    @Override
    public void showLoadingContentView() {
        contentRl.setVisibility(View.INVISIBLE);
        loadTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeLoadingContentView() {
        loadTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initPresenter() {
        presenter = new WordExplainPresenter(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_word_explain;
    }

    @Override
    public void getExplainSucceed(String word, String soundMark, String soundUrl, String explain) {
        contentRl.setVisibility(View.VISIBLE);
        errorTv.setVisibility(View.INVISIBLE);
        removeLoadingContentView();
        wordTv.setText(word);
        soundMarkTv.setText(soundMark);
        explainTv.setText(explain);
        this.soundUrl = soundUrl;
    }

    @Override
    public void getExplainFailed(String error) {
        removeLoadingContentView();
        showErrorView();
    }

    public void showErrorView() {
        contentRl.setVisibility(View.INVISIBLE);
        errorTv.setVisibility(View.VISIBLE);
    }

    public void show() {
        view.setVisibility(View.VISIBLE);
//        contentRl.setVisibility(View.VISIBLE);
        ObjectAnimator.ofFloat(view, "translationY", 0).start();
    }

    public void leave() {
        ObjectAnimator.ofFloat(view, "translationY", height).start();

    }
}
