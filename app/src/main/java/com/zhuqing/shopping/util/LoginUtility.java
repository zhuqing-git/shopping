package com.zhuqing.shopping.util;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginUtility {
    /**
     * 解析和处理服务器返回的登录数据
     */
    public static String HandleLoginResponse(String response) throws JSONException {

        try{
            JSONObject re=new JSONObject(response);
            if (re.get("result").equals("true"))
                return (String) re.get("userId");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return "0";

    }
//    public static int GetUserId(){
//       // User user=
//    }
}
