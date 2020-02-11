package com.zhuqing.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.LoginUtility;

import org.json.JSONException;

import java.io.IOException;
import java.util.ResourceBundle;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    Button registSend,registGet;
    TimeCount timeCount;
    EditText registerPhone,registerPassword;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registSend=(Button)findViewById(R.id.regist_send);
        registGet=(Button)findViewById(R.id.regist_get);
        registerPhone=(EditText)findViewById(R.id.register_phone);
        registerPassword=(EditText)findViewById(R.id.register_password);
        editor=PreferenceManager.getDefaultSharedPreferences(this).edit();




        timeCount=new TimeCount(60000,1000);


        registSend.setOnClickListener(this);
        registGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.regist_get:
                timeCount.start();
                break;

            case R.id.regist_send:
                //region 内容
                String address = "http://192.168.43.28:8080/register";
                RequestBody requestBody = new FormBody.Builder().add("phone", registerPhone.getText().toString()).add("password", registerPassword.getText().toString()).build();
                Request request = new Request.Builder().url(address).post(requestBody).build();
                HttpUtil.SendOkHttpRequest(address, request, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseText = response.body().string();
                        try {
                            boolean result= LoginUtility.HandleLoginResponse(responseText);
                            if (result)
                            {
                               editor.putBoolean("verification",true);
                               editor.apply();
                                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                });

            //endregion
                break;
            default:
                break;
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
            registGet.setBackgroundColor(Color.parseColor("#9e9e9e"));
            registGet.setClickable(false);
            registGet.setText( String.valueOf(millisUntilFinished/1000));


        }

        @Override
        public void onFinish() {
            registGet.setText("获取验证码");
            registGet.setClickable(true);
            registGet.setBackgroundColor(Color.parseColor("#FB7299"));

        }
    }
}
