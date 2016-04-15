package com.example.pangyang.helper.view;

import com.example.pangyang.helper.model.Book;

import java.util.List;

/**
 * Created by pangyang on 2016/4/11.
 */

public interface IBookView {
    void showProgress();
    void showItems(List<Book> items);
}
