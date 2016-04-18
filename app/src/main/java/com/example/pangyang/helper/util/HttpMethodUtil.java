package com.example.pangyang.helper.util;

import com.example.pangyang.helper.model.SearchBookResp;
import com.example.pangyang.helper.view.IBookView;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by pangyang on 2016/4/13.
 */
public class HttpMethodUtil {
    final String BASE_URL = "https://api.douban.com/v2/";
    private static Retrofit retrofit;

    private HttpMethodUtil(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

    }

    public static <T> T getService(Class<T> typeT){
        if(retrofit == null){
            new HttpMethodUtil();
        }
        T tService = retrofit.create(typeT);
        return tService;
    }

    public static <T> void execute(Observable<T> observable, Subscriber<T> subscriber){
        observable
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber);
    }

}
