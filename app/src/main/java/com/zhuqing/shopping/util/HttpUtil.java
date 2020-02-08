package com.zhuqing.shopping.util;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {


    public static void SendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder().add("phone","32").add("password","3421").build();

        Request request=new Request.Builder().url(address).post(requestBody).build();
        client.newCall(request).enqueue(callback);

    }
}
