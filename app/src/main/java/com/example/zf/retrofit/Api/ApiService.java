package com.example.zf.retrofit.Api;

import com.example.zf.retrofit.pojo.User;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ZF on 2017/3/21.
 */

public interface ApiService {
    String API_URL = "http://151g61s040.imwork.net:25530";
    @POST("/hello1/")
    Observable<User> login(@QueryMap Map<String,String> maps);
}
