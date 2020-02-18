package com.zhuqing.shopping.util;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

public class CustomLinearLayoutManager extends LinearLayoutManager {


    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

//    public void setScrollEnabled(boolean flag) {
//        this.isScrollEnabled = flag;
//    }

    /**
     * 禁止滑动
     * canScrollHorizontally（禁止横向滑动）
     * @return
     */
    @Override
    public boolean canScrollHorizontally() {
       return false;

    }
//    /**
//     * 禁止滑动
//     * canScrollVertically（禁止竖向滑动）
//     * @return
//     */
//    @Override
//    public boolean canScrollVertically() {
//        return isScrollEnabled && super.canScrollVertically();
//    }
}
