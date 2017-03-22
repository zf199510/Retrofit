package com.example.zf.retrofit.Api;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by ZF on 2017/3/21.
 */

public abstract class RxSubscribe<T> extends Subscriber<T> {
    private Context context;
    private String msg;

    public RxSubscribe(Context context, String msg) {
        this.context = context;
        this.msg = msg;
    }

    public RxSubscribe(Context context) {
        this.context = context;
    }

    public RxSubscribe() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        _onError(e.toString());
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);
    protected abstract void _onError(String msg);
}
