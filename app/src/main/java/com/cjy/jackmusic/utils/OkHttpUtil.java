package com.cjy.jackmusic.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtil {
    public static  void sendOkhttpResquest(String url, okhttp3.Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
