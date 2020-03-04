package com.zhuqing.shopping.util;

import com.zhuqing.shopping.db.User;



public class ValueUtility {

    private static int userId=0;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        ValueUtility.userId = userId;
    }
}
