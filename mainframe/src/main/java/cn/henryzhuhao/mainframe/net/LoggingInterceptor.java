package cn.henryzhuhao.mainframe.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author : zhuhao
 * Date : 13/12/2017
 *
 * @Last Modified Time :13/12/2017
 * Description :
 */

public class LoggingInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(chain.request());
        Log.i("LoggingInterceptor",response.body().byteStream().toString());
        return response;
    }
}
