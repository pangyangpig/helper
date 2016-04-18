package com.example.pangyang.helper.util;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by pangyang on 2016/4/18.
 */
public class MySubscriber<T> extends Subscriber<T> {

    private OnSubNextListener<T> nextListener;
    private Context context;
    private ProgressHandler progressListener;

    public MySubscriber(Context context, OnSubNextListener<T> nextListener) {
        super(null,false);
        this.context = context;
        this.nextListener = nextListener;
        progressListener = new ProgressHandler(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        progressListener.show();
    }

    @Override
    public void onNext(T o) {
        nextListener.onNext(o);
    }

    @Override
    public void onCompleted() {
        progressListener.dismiss();
    }

    @Override
    public void onError(Throwable e) {
        progressListener.dismiss();
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
