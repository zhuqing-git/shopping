package com.zhuqing.shopping.util;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.zhuqing.shopping.R;

public class WindowUtil {


    /**
     * 设置状态栏颜色
     * @param activity
     */
    public static void setStatusBar(Activity activity){

        //直接设置状态栏背景色
        Window window=activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.colorPrimary));
    }

    public static int  getWindowWidth(Context context){

       return  context.getApplicationContext().getApplicationContext().getResources()
                .getDisplayMetrics().widthPixels;

    }



    //          沉浸式状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams barLayoutParams = getWindow().getAttributes();
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//           // barLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | barLayoutParams.flags);
//        }


}
