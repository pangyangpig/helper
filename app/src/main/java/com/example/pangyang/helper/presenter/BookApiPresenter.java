package com.example.pangyang.helper.presenter;

import android.util.Log;

import com.example.pangyang.helper.model.Book;
import com.example.pangyang.helper.model.IBookInteractor;
import com.example.pangyang.helper.model.SearchBookReq;
import com.example.pangyang.helper.model.SearchBookResp;
import com.example.pangyang.helper.util.Utils;
import com.example.pangyang.helper.view.IBookView;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by pangyang on 2016/4/11.
 */
public class BookApiPresenter implements IBookApiPresenter{

    IBookView bookView;

    public BookApiPresenter(IBookView bookView) {
        this.bookView = bookView;
    }

    @Override
    public void search(String keyWords) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        IBookInteractor bookInteractor = retrofit.create(IBookInteractor.class);
        SearchBookReq req = new SearchBookReq();
        req.count = 2;
        req.q = keyWords;
        req.start = 0;
        Observable<SearchBookResp> observable = bookInteractor.searchBooks(Utils.simpleBean2Map(req));

        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchBookResp>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.toString());
                    }

                    @Override
                    public void onNext(SearchBookResp searchBookResp) {
                        List<Book> books = searchBookResp.books;
                        bookView.showItems(books);
                    }
                });

    }
}