package com.zhuqing.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.User;
import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.LoginUtility;
import com.zhuqing.shopping.util.ValueUtility;

import org.json.JSONException;
import org.litepal.LitePal;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login, regist;
    EditText phoneText, passwordText;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;


    String TAG="LoginActivity";
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {








        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneText = (EditText) findViewById(R.id.login_phone);
        passwordText = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_login_button);
        regist = (Button) findViewById(R.id.login_regist_button);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();


        login.setOnClickListener(this);
        regist.setOnClickListener(this);

        if (sharedPreferences.getBoolean("verification", false)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login_button:
                String address = HttpUtil.prefix+"login";
                RequestBody requestBody = new FormBody.Builder().add("phone", phoneText.getText().toString()).add("password", passwordText.getText().toString()).build();
                Request request = new Request.Builder().url(address).post(requestBody).build();


                QueryFromServer(address, request);

                break;
            case R.id.login_regist_button:
                Intent intentRegist = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegist);
                LitePal.getDatabase();
                break;
            default:
                break;


        }
    }

    /**
     * 从服务器查询
     *
     * @param address
     */
    private void QueryFromServer(String address, Request request) {

        HttpUtil.SendOkHttpRequest(address, request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                boolean result = false;


                String responseText = response.body().string();

               int userid=0;
                try {
                    userid =Integer.parseInt( LoginUtility.HandleLoginResponse(responseText));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (userid!=0) {

                    // String aa="Hello";
                    editor.putBoolean("verification", true);
                    editor.apply();
                    LitePal.deleteAll(User.class);
                    User user = new User();



                    user.setUserId(userid);
                    Log.d(TAG, "onResponse: "+userid);
                    ValueUtility.setUserId(userid);
                    user.setPhone(Integer.parseInt(phoneText.getText().toString()));
                    user.setPassword(passwordText.getText().toString());
                    user.save();

                    User user1=LitePal.findFirst(User.class);
                    Log.d(TAG, "onResponse:11111111 "+user1.getUserId());


                    List<User> user2=LitePal.findAll(User.class);
                    Log.d(TAG, "onResponse:   2222222 "+user2.size());




                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
}
