package com.zhuqing.shopping.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhuqing.shopping.R;

public class CustomPopWindow extends PopupWindow {
    private static final String TAG = "CustomPopWindow";
    private  View view ;
    private Activity context;
    private View.OnClickListener itemClick;
    private View.OnClickListener commodyItemClick;
    private int state;


//state 两种状态
    public CustomPopWindow(Activity context, View.OnClickListener itemClick ,int state) {
        super(context);
        this.itemClick = itemClick;
        this.commodyItemClick=itemClick;
        this.context = context;
        this.state=state;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (state==1)
        {
            view = inflater.inflate(R.layout.window_pop_1, null);//alt+ctrl+f
        }
        else if (state==2)
        {
            view =inflater.inflate(R.layout.window_pop_2,null);
        }
        else if (state==3)
        {
            view=inflater.inflate(R.layout.window_pop_3,null);
        }
        else if (state==4)
        {
            view=inflater.inflate(R.layout.window_pop_4,null);
        }



        initView();
        initPopWindow();
    }



    private void initView() {
        if (state==1)
        {
            TextView textView1=view.findViewById(R.id.window_pop_1);
            TextView textView2=view.findViewById(R.id.window_pop_2);
            TextView textView3=view.findViewById(R.id.window_pop_3);
//        final LinearLayout popBg = view.findViewById(R.id.pop_bg);
//        LinearLayout weChatShare = view.findViewById(R.id.ll_wechat_share);
//        LinearLayout weChatZone = view.findViewById(R.id.ll_wechat_zone);
//        LinearLayout qqShare = view.findViewById(R.id.ll_qq_share);
//        LinearLayout qqZone = view.findViewById(R.id.ll_qq_zone);
//        TextView cancelTv = view.findViewById(R.id.share_cancel);
            textView1.setOnClickListener(itemClick);
            textView2.setOnClickListener(itemClick);
            textView3.setOnClickListener(itemClick);
        }
        else if (state==2)
        {
            LinearLayout shuben=view.findViewById(R.id.pop2_shuben_layout);
            LinearLayout shouji=view.findViewById(R.id.pop2_shouji_layout);
            LinearLayout diannao=view.findViewById(R.id.pop2_diannao_layout);
            LinearLayout shuma=view.findViewById(R.id.pop2_shuma_layout);
            LinearLayout meizhuang=view.findViewById(R.id.pop2_meizhuang_layout);
            LinearLayout yundong=view.findViewById(R.id.pop2_yundong_layout);
            LinearLayout xihu=view.findViewById(R.id.pop2_xihu_layout);
            LinearLayout yiwu=view.findViewById(R.id.pop2_yiwu_layout);



            shuben.setOnClickListener(itemClick);
            shouji.setOnClickListener(itemClick);
            diannao.setOnClickListener(itemClick);
            shuma.setOnClickListener(itemClick);
            meizhuang.setOnClickListener(itemClick);
            yundong.setOnClickListener(itemClick);
            xihu.setOnClickListener(itemClick);
            yiwu.setOnClickListener(itemClick);
        }
        else if (state==3)
        {
            TextView number1=view.findViewById(R.id.tv_NumberPopup_1);
            TextView number2=view.findViewById(R.id.tv_NumberPopup_2);
            TextView number3=view.findViewById(R.id.tv_NumberPopup_3);
            TextView number4=view.findViewById(R.id.tv_NumberPopup_4);
            TextView number5=view.findViewById(R.id.tv_NumberPopup_5);
            TextView number6=view.findViewById(R.id.tv_NumberPopup_6);
            TextView number7=view.findViewById(R.id.tv_NumberPopup_7);
            TextView number8=view.findViewById(R.id.tv_NumberPopup_8);
            TextView number9=view.findViewById(R.id.tv_NumberPopup_9);
            TextView number0=view.findViewById(R.id.tv_NumberPopup_0);
            TextView numberdel=view.findViewById(R.id.iv_NumberPopup_Del);
            TextView numbersur=view.findViewById(R.id.iv_NumberPopup_sure);


            number1.setOnClickListener(itemClick);
            number2.setOnClickListener(itemClick);
            number3.setOnClickListener(itemClick);
            number4.setOnClickListener(itemClick);
            number5.setOnClickListener(itemClick);
            number6.setOnClickListener(itemClick);
            number7.setOnClickListener(itemClick);
            number8.setOnClickListener(itemClick);
            number9.setOnClickListener(itemClick);
            number0.setOnClickListener(itemClick);
            numberdel.setOnClickListener(itemClick);
            numbersur.setOnClickListener(itemClick);

        }
        else if (state==4)
        {
            TextView confirm=view.findViewById(R.id.window_pop_4);

            confirm.setOnClickListener(commodyItemClick);
        }

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
            this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

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
