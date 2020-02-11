package com.zhuqing.shopping.util;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {



    public static void SendOkHttpRequest(String address,Request request,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();

        client.newCall(request).enqueue(callback);

    }


}
