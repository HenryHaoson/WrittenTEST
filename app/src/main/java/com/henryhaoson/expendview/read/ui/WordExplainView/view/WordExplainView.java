package com.henryhaoson.expendview.read.ui.WordExplainView.view;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public interface WordExplainView {
    void getExplainSucceed(String word,String soundMark,String soundUrl,String explain);
    void getExplainFailed(String error);
}
