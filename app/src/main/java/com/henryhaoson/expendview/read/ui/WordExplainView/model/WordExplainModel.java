package com.henryhaoson.expendview.read.ui.WordExplainView.model;

import com.henryhaoson.expendview.api.ShanbayApi;
import com.henryhaoson.expendview.entity.resEntity.WordExplainEntity;

import cn.henryzhuhao.mainframe.frame.base.action.BaseModel;
import cn.henryzhuhao.mainframe.net.ApiFactory;
import cn.henryzhuhao.mainframe.net.RxHelper;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public class WordExplainModel {
    public void exlpainWord(String word,final BaseModel.LoadDateCallBack<WordExplainEntity> callBack){
        ShanbayApi api= ApiFactory.newInstance().createApi(ShanbayApi.class);
        api.getWordExplain(word)
                .compose(RxHelper.<WordExplainEntity>io_main())
                .subscribe(new Observer<WordExplainEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WordExplainEntity wordExplainEntity) {
                        if (wordExplainEntity.getStatus_code()==0){
                            callBack.loadDateSucceed(wordExplainEntity);
                        }else {
                            callBack.loadDateFailed("获取失败");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.loadDateFailed("获取失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
