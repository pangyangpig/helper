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
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RVViewHolder> {

    List<Book> list = new ArrayList<>();

    public void addData(List<Book> data){
        list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_book,parent,false);
        RVViewHolder holder = new RVViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        Book book = list.get(position);
        holder.textView.setText(book.title);
        holder.imageView.setImageURI(Uri.parse(book.image));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class RVViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title) TextView textView;
        @Bind(R.id.iv_cover) ImageView imageView;

        public RVViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
