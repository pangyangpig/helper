package com.example.pangyang.helper.util;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by pangyang on 2016/4/18.
 */
public class ImageDisplayer {
    public static void displayImage(String url, ImageView imageView){
        ImageLoader.getInstance().displayImage(url, imageView);
    }
}
