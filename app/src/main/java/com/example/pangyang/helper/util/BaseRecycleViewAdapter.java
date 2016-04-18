package com.example.pangyang.helper.util;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangyang.helper.R;
import com.example.pangyang.helper.model.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pangyang on 2016/4/15.
 */
public abstract class BaseRecycleViewAdapter<ItemDataType> extends RecyclerView.Adapter<BaseViewHolder> {

    List<ItemDataType> list = new ArrayList<>();

    private int layoutId;

    public BaseRecycleViewAdapter() {
    }

    public BaseRecycleViewAdapter(int layoutId ) {
        this.layoutId = layoutId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public abstract void onBindViewHolder(BaseViewHolder holder, int position) ;

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<ItemDataType> data){
        list.addAll(data);
        notifyDataSetChanged();
    }
}
