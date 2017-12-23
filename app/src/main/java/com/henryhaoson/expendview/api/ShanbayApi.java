package com.henryhaoson.expendview.api;

import com.henryhaoson.expendview.entity.resEntity.WordExplainEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public interface ShanbayApi {

    @GET("https://api.shanbay.com/bdc/search")
    Observable<WordExplainEntity> getWordExplain(@Query("word") String word);
}
