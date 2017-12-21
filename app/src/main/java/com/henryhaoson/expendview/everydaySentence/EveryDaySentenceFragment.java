package com.henryhaoson.expendview.everydaySentence;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.henryhaoson.expendview.R;

import cn.henryzhuhao.mainframe.frame.base.BaseFragment;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class EveryDaySentenceFragment extends BaseFragment {
    private RecyclerView everydaySentenceRc;
    @Override
    public void initView() {
        everydaySentenceRc = view.findViewById(R.id.everyday_sentence_rc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        everydaySentenceRc.setLayoutManager(linearLayoutManager);
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

    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_everyday_sentence;
    }
}
