package com.gs.netsupport.helper;

import android.app.Dialog;
import com.gs.netsupport.BaseResponse;

/**
 * @author husky
 * create on 2019-05-14-17:07
 */
public abstract class ProgressSubscriber<T extends BaseResponse> extends BaseSubscriber<T> {

    private Dialog dialog;

    public ProgressSubscriber(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != dialog && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onComplete() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (null != dialog) {
            dialog.dismiss();
        }
    }
}
