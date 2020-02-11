package com.zhuqing.shopping.util;

import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoginUtility {
    /**
     * 解析和处理服务器返回的登录数据
     */
    public static boolean HandleLoginResponse(String response) throws JSONException {

        try{
            JSONObject re=new JSONObject(response);
            if (re.get("result").equals("true"))
                return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------------");



        return false;


    }
}
