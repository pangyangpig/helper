package com.example.pangyang.helper.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * Created by pangyang on 2016/4/18.
 */
public class ProgressHandler extends Handler{
    private ProgressDialog progressDialog;
    final int TYPE_SHOW = 1;
    final int TYPE_DISMISS = 2;

    public ProgressHandler(Context context) {
        this.progressDialog = new ProgressDialog(context);
    }

    public void dismiss(){
        obtainMessage(TYPE_DISMISS).sendToTarget();
    }

    public void show(){
        obtainMessage(TYPE_SHOW).sendToTarget();
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case TYPE_DISMISS : {
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            } break;

            case TYPE_SHOW : {
                if(!progressDialog.isShowing()){
                    progressDialog.show();
                }
            } break;
        }
    }
}
