package com.example.pangyang.helper.presenter;

import android.content.Context;

import com.example.pangyang.helper.model.Book;
import com.example.pangyang.helper.model.IBookInteractor;
import com.example.pangyang.helper.model.SearchBookReq;
import com.example.pangyang.helper.model.SearchBookResp;
import com.example.pangyang.helper.util.HttpMethodUtil;
import com.example.pangyang.helper.util.MySubscriber;
import com.example.pangyang.helper.util.OnSubNextListener;
import com.example.pangyang.helper.util.Utils;
import com.example.pangyang.helper.view.IBookView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pangyang on 2016/4/11.
 */
public class BookApiPresenter implements IBookApiPresenter{

    IBookView bookView;
    Context context;

    public BookApiPresenter(IBookView bookView,Context context) {
        this.bookView = bookView;
        this.context = context;
    }

    @Override
    public void search(String keyWords) {
        IBookInteractor bookInteractor = HttpMethodUtil.getService(IBookInteractor.class);
        SearchBookReq req = new SearchBookReq();
        req.count = 2;
        req.q = keyWords;
        req.start = 0;
        Observable<SearchBookResp> observable = bookInteractor.searchBooks(Utils.simpleBean2Map(req));

        HttpMethodUtil.execute(observable,new MySubscriber<>(context,new OnSubNextListener<SearchBookResp>() {
            @Override
            public void onNext(SearchBookResp searchBookResp) {
                List<Book> books = searchBookResp.books;
                bookView.showItems(books);
            }
        }));

    }
}
