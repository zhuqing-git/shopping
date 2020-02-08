package com.zhuqing.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.LoginUtility;

import org.litepal.LitePal;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login ,regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = (Button) findViewById(R.id.login_login_button);
        regist = (Button) findViewById(R.id.login_regist_button);
        login.setOnClickListener(this);
        regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login_button:
//                Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intentLogin);
                String address="http://192.168.43.28:8080/login";

                QueryFromServer(address);

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
     * @param address
     */
    private void QueryFromServer(String address)
    {

        HttpUtil.SendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(LoginActivity.this, "失败",Toast.LENGTH_SHORT).show();




            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String responseText=response.body().string();
                boolean result=false;
                result= LoginUtility.HandleLoginResponse(responseText);
                Log.d("test", String.valueOf(result));
                if(result)
                {

                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          Toast.makeText(LoginActivity.this,"成功",Toast.LENGTH_SHORT).show();
                      }
                  });

                }

            }
        });

    }
}
