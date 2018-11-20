package com.cjy.jackmusic.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtil {
    public static  void sendOkhttpResquest(String url, okhttp3.Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().
                url(url).addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows 7)").build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
