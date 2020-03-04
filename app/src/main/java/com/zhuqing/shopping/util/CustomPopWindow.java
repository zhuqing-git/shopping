package com.zhuqing.shopping.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhuqing.shopping.R;

public class CustomPopWindow extends PopupWindow {
    private static final String TAG = "CustomPopWindow";
    private final View view;
    private Activity context;
    private View.OnClickListener itemClick;


    public CustomPopWindow(Activity context, View.OnClickListener itemClick ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.window_pop, null);//alt+ctrl+f
        this.itemClick = itemClick;
        this.context = context;

        initView();
        initPopWindow();
    }


    private void initView() {
        TextView textView1=view.findViewById(R.id.window_pop_1);
        TextView textView2=view.findViewById(R.id.window_pop_2);
//        final LinearLayout popBg = view.findViewById(R.id.pop_bg);
//        LinearLayout weChatShare = view.findViewById(R.id.ll_wechat_share);
//        LinearLayout weChatZone = view.findViewById(R.id.ll_wechat_zone);
//        LinearLayout qqShare = view.findViewById(R.id.ll_qq_share);
//        LinearLayout qqZone = view.findViewById(R.id.ll_qq_zone);
//        TextView cancelTv = view.findViewById(R.id.share_cancel);
        textView1.setOnClickListener(itemClick);
        textView2.setOnClickListener(itemClick);
//
//        weChatShare.setOnClickListener(itemClick);
//        weChatZone.setOnClickListener(itemClick);
//        qqShare.setOnClickListener(itemClick);
//        qqZone.setOnClickListener(itemClick);
//        cancelTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });

    }

    private void initPopWindow() {
        this.setContentView(view);
        // 设置弹出窗体的宽
       // int width=

        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体的高
        this.setHeight(170);
        // 设置弹出窗体可点击()
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00FFFFFF);
        //设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context, 0.5f);//0.0-1.0
    }

    /**
     * 设置添加屏幕的背景透明度(值越大,透明度越高)
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }
}
