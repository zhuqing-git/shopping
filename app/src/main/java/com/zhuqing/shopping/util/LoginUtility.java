package com.zhuqing.shopping.util;

import android.text.TextUtils;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginUtility {
    /**
     * 解析和处理服务器返回的登录数据
     */
    public static boolean HandleLoginResponse(String response)
    {
        boolean result=false;
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONObject jsonObject=new JSONObject(response);
                result=jsonObject.getBoolean("result");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;


    }
}
