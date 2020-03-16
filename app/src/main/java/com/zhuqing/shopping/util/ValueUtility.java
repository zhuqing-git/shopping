package com.zhuqing.shopping.util;


public class ValueUtility {

    private static int userId=0;

    public static boolean commodyPublicChange=false;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        ValueUtility.userId = userId;
    }
}
