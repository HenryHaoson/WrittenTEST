package com.henryhaoson.expendview;

import android.Manifest;
import android.os.Bundle;

import com.henryhaoson.expendview.everydaySentence.EveryDaySentenceFragment;
import com.tbruyelle.rxpermissions2.RxPermissions;

import cn.henryzhuhao.mainframe.frame.base.BaseActivity;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static com.henryhaoson.expendview.R.layout.activity_main;

public class MainActivity extends BaseActivity {

    @Override
    public int getFragmentContentId() {
        return R.id.activity_container;
    }

    @Override
    public void initView() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean){
                            startFragment(MainFragment.newInstance());
                        }
                        else {
                            startFragment(MainFragment.newInstance());
                        }
                    }
                });


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
