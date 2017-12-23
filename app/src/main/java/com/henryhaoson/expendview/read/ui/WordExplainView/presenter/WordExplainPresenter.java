package com.henryhaoson.expendview.read.ui.WordExplainView.presenter;

import com.henryhaoson.expendview.entity.resEntity.WordExplainEntity;
import com.henryhaoson.expendview.read.ui.WordExplainView.model.WordExplainModel;
import com.henryhaoson.expendview.read.ui.WordExplainView.view.WordExplainView;

import cn.henryzhuhao.mainframe.frame.base.action.BaseModel;

;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public class WordExplainPresenter {
    private WordExplainModel mModel;
    private WordExplainView mView;
    public WordExplainPresenter(WordExplainView view){
        mView=view;
        mModel=new WordExplainModel();
    }

    public void getExplain(final String word){
        mModel.exlpainWord(word, new BaseModel.LoadDateCallBack<WordExplainEntity>() {
            @Override
            public void loadDateSucceed(WordExplainEntity date) {
                String soundMark = date.getData().getPron();
                String soundUrl = date.getData().getAudio();
                String explain=date.getData().getDefinition();
                mView.getExplainSucceed(word,soundMark,soundUrl,explain);
            }

            @Override
            public void loadDateFailed(String error) {
                mView.getExplainFailed(error);
            }
        });
    }
}
