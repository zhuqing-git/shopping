package com.zhuqing.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    Button registSend;
    TimeCount timeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registSend=(Button)findViewById(R.id.regist_send);
        timeCount=new TimeCount(60000,1000);


        registSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.regist_send:
                timeCount.start();
        }


    }

    /**
     * 倒计时类
     */
    class TimeCount extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            registSend.setBackgroundColor(Color.parseColor("#9e9e9e"));
            registSend.setClickable(false);
            registSend.setText( String.valueOf(millisUntilFinished/1000));


        }

        @Override
        public void onFinish() {
            registSend.setText("获取验证码");
            registSend.setClickable(true);
            registSend.setBackgroundColor(Color.parseColor("#FB7299"));

        }
    }
}
