package com.example.pangyang.helper.util;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by pangyang on 2016/4/18.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private SparseArray<Object> views = new SparseArray<>();

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public <T> T getSubView(int resId){
        T subView = (T) views.get(resId);
        if(subView == null){
            subView = (T) itemView.findViewById(resId);
            views.put(resId, subView);
        }

        return subView;
    }
}
