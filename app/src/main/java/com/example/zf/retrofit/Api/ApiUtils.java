package com.example.zf.retrofit.Api;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.zf.retrofit.MainActivity;
import com.example.zf.retrofit.pojo.User;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZF on 2017/3/21.
 */

public class ApiUtils {
public static ApiService getApiService(){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiService.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    ApiService apiService = retrofit.create(ApiService.class);
    return apiService;
}
}
