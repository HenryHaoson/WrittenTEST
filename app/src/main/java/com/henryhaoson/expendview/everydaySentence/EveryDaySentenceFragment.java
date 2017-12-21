package com.henryhaoson.expendview.everydaySentence;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.henryhaoson.expendview.R;
import com.henryhaoson.expendview.everydaySentence.adapter.EveryDaySentenceAdapter;

import cn.henryzhuhao.mainframe.frame.base.BaseFragment;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class EveryDaySentenceFragment extends BaseFragment {
    String[] urls = new String[]{"https://static.baydn.com/media/media_store/image/f1672263006c6e28bb9dee7652fa4cf6.jpg",
            "https://static.baydn.com/media/media_store/image/8c997fae9ebb2b22ecc098a379cc2ca3.jpg",
            "https://static.baydn.com/media/media_store/image/2a4616f067285b4bd59fe5401cd7106b.jpeg",
            "https://static.baydn.com/media/media_store/image/b0e3ab329c8d8218d2af5c8dfdc21125.jpg",
            "https://static.baydn.com/media/media_store/image/670abb28408a9a0fc3dd9666e5ca1584.jpeg",
            "https://static.baydn.com/media/media_store/image/1e8d675468ab61f4e5bdebd4bcb5f007.jpeg",
            "https://static.baydn.com/media/media_store/image/9b2f93cbfa104dae1e67f540ff14a4c2.jpg",
            "https://static.baydn.com/media/media_store/image/f5e0631e00a09edbbf2eb21eb71b4d3c.jpeg"};
    private RecyclerView everydaySentenceRc;

    public static EveryDaySentenceFragment newInstance() {
        
        Bundle args = new Bundle();
        
        EveryDaySentenceFragment fragment = new EveryDaySentenceFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initView() {
        everydaySentenceRc = view.findViewById(R.id.everyday_sentence_rc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        everydaySentenceRc.setLayoutManager(linearLayoutManager);
        everydaySentenceRc.setAdapter(new EveryDaySentenceAdapter(getContext(),urls));
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
