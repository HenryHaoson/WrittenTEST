package com.henryhaoson.expendview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.henryhaoson.expendview.everydaySentence.EveryDaySentenceFragment;
import com.henryhaoson.expendview.read.ReadFragment;

import cn.henryzhuhao.mainframe.frame.base.BaseFragment;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class MainFragment extends BaseFragment {
    private Button wordBtn;
    private Button picBtn;

    public static MainFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView() {
        wordBtn=view.findViewById(R.id.main_word);
        picBtn=view.findViewById(R.id.main_pic);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {
        wordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(ReadFragment.newInstance());
            }
        });
        picBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(EveryDaySentenceFragment.newInstance());
            }
        });
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
        return R.layout.fragment_main;
    }
}
