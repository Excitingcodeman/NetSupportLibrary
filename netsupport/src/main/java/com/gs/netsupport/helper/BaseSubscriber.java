package com.gs.netsupport.helper;

import com.gs.netsupport.BaseResponse;
import com.gs.netsupport.HttpConfig;
import com.gs.netsupport.exception.MyConsumerThrowable;
import io.reactivex.observers.DisposableObserver;

/**
 * @author husky
 * create on 2019-05-14-17:03
 */
public abstract class BaseSubscriber<T extends BaseResponse> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
        if (HttpConfig.SUCCESS_CODE.equals(t.getResultCode())) {
            onSuccess(t);
        } else {
            onFail(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        MyConsumerThrowable.handlingException(e);
    }

    protected abstract void onSuccess(T value);

    protected void onFail(T value) {

    }
}
