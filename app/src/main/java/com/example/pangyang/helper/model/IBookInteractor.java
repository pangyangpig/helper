package com.example.pangyang.helper.model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by pangyang on 2016/4/11.
 */
public interface IBookInteractor {
    @GET("book/search")
    Observable<SearchBookResp> searchBooks(@QueryMap() Map<String, String> q);
}
