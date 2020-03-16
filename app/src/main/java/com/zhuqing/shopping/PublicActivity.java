package com.zhuqing.shopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhuqing.shopping.adapter.CustomGridAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.Config;
import com.zhuqing.shopping.util.CustomPopWindow;
import com.zhuqing.shopping.util.GlideEngine;
import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.LoginUtility;
import com.zhuqing.shopping.util.ValueUtility;
import com.zhuqing.shopping.util.WindowUtil;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class PublicActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "PublicActivity";

    Context context = this;

    private Toolbar toolbar;
    private CircleImageView sortImageView;
    private TextView topTextView, sortTextView;
    private ImageView sortFlagImageView, publicTest;
    private LinearLayout topLinearLayout;
    private List<LocalMedia> selectList;
    private GridView gridView;
    private List<String> imagePaths = new ArrayList<>();
    private List<String> imagePutPaths = new ArrayList<>();
    private EditText editText,publicMoney;
    private Button popBtn, pubButton;
    private CustomPopWindow popWindow;

    CustomGridAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        toolbar = (Toolbar) findViewById(R.id.public_toolbar);
        setSupportActionBar(toolbar);
        sortImageView = findViewById(R.id.public_sort_image);
        topTextView = findViewById(R.id.public_top_text);
        sortTextView = findViewById(R.id.public_sort_text);
        sortFlagImageView = findViewById(R.id.public_sort_flag);
        topLinearLayout = findViewById(R.id.public_top_layout);
        gridView = findViewById(R.id.public_gridview);
        editText = findViewById(R.id.public_edittext);
        popBtn = findViewById(R.id.public_popwindow);
        pubButton = findViewById(R.id.public_tijiao);
        publicTest = findViewById(R.id.public_test);
        publicMoney=findViewById(R.id.public_money);


        popBtn.setOnClickListener(this);
        pubButton.setOnClickListener(this);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }
        WindowUtil.setStatusBar(this);


        adapter = new CustomGridAdapter(this, imagePaths);
        gridView.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 相册主题
            case R.id.public_popwindow:
                popWindow = new CustomPopWindow(this, itemsOnClick);
                popWindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        popWindow.backgroundAlpha(PublicActivity.this, 1f);
                    }
                });


                break;
            case R.id.public_tijiao:
                String contentSend = editText.getText().toString();
                String topic = sortTextView.getText().toString();
                String money=publicMoney.getText().toString();


                //File filc=new File(imagePutPaths.get(0));//原图上传

             boolean result=   HttpUtil.PublicUtil.PublicOneCommody(contentSend,topic,money,imagePaths,this);
             if (result)
                 finish();

                break;
        }
    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            popWindow.dismiss();
            switch (v.getId()) {
                case R.id.window_pop_1:
                    imagePaths.clear();

                    PictureSelector.create((Activity) context)
                            .openGallery(PictureMimeType.ofImage())
                            .loadImageEngine(GlideEngine.createGlideEngine())
                            .isCamera(false)
                            .maxSelectNum(6)
                            .theme(R.style.picture_default_style)
                            .isReturnEmpty(true)

                            .imageSpanCount(6)
                            .selectionMode(PictureConfig.MULTIPLE)
                            .isZoomAnim(true)
                            .selectionMedia(selectList)
                            // .enableCrop(true)
                            .compress(true)
                            .withAspectRatio(9, 16)
                            // .compressSavePath(filePath)
                            .circleDimmedLayer(false)
                            .minimumCompressSize(100)
                            .scaleEnabled(true)


                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    break;
                case R.id.window_pop_3:
                    break;



            }
        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @SuppressLint("ResourceType")
    public void onClickPublic(View view) {
        switch (view.getId()) {
            case R.id.public_top_layout:
                topTextView.setVisibility(View.GONE);
                sortImageView.setVisibility(View.VISIBLE);
                sortTextView.setVisibility(View.VISIBLE);
                sortFlagImageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种 path
                    // 1.media.getPath(); 为原图 path
                    // 2.media.getCutPath();为裁剪后 path，需判断 media.isCut();是否为 true
                    // 3.media.getCompressPath();为压缩后 path，需判断 media.isCompressed();是否为 true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的


                    for (int i = 0; i < selectList.size(); i++) {

                        LocalMedia localMedia = selectList.get(i);
                        Log.d("test", "Path              " + localMedia.getPath());

                        imagePaths.add(localMedia.getCompressPath());
                        //imagePutPaths.add(localMedia.getPath());原图路径

                    }
                    adapter.notifyDataSetChanged();

                    break;
            }
        }
    }
}