package com.example.pangyang.helper.util;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangyang.helper.R;
import com.example.pangyang.helper.model.Book;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by pangyang on 2016/4/15.
 */
public class RecycleViewAdapter extends BaseRecycleViewAdapter<Book>{

    public RecycleViewAdapter(int layoutId) {
        super(layoutId);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Book book = list.get(position);
        TextView title = holder.getSubView(R.id.tv_title);
        title.setText(book.title);
        ImageView cover = holder.getSubView(R.id.iv_cover);
        ImageLoader.getInstance().displayImage(book.image, cover);
    }
}
