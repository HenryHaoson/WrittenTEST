package com.henryhaoson.expendview;

import android.os.Bundle;

import cn.henryzhuhao.mainframe.frame.base.BaseActivity;

import static com.henryhaoson.expendview.R.layout.activity_main;

public class MainActivity extends BaseActivity {

    @Override
    public int getFragmentContentId() {
        return R.id.activity_container;
    }

    @Override
    public void initView() {

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
        return activity_main;
    }
}
