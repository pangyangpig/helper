package com.example.pangyang.helper.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pangyang.helper.R;
import com.example.pangyang.helper.model.Book;
import com.example.pangyang.helper.presenter.BookApiPresenter;
import com.example.pangyang.helper.presenter.IBookApiPresenter;
import com.example.pangyang.helper.util.RecycleViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class BooksListFragment extends BaseFragment implements IBookView{

    IBookApiPresenter presenter;
    private static BooksListFragment fragment;
    @Bind(R.id.rv_list)RecyclerView rvList;
    private Context context;
    private RecycleViewAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookslist, container, false);
        ButterKnife.bind(this,view);

        presenter = new BookApiPresenter(this, container.getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvList.setLayoutManager(layoutManager);
        adapter = new RecycleViewAdapter(R.layout.itemview_book);
        rvList.setAdapter(adapter);
        return view;
    }

    public static BooksListFragment getInstance(){
        if(fragment == null){
            fragment = new BooksListFragment();
        }
        return fragment;
    }

    public void doSearch(String keyWords){
        presenter.search(keyWords);
    }

    @Override
    public void showItems(List<Book> items) {
        adapter.addData(items);
    }
}
