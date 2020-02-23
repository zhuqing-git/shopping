package com.zhuqing.shopping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhuqing.shopping.adapter.CustomGridAdapter;
import com.zhuqing.shopping.util.GlideEngine;
import com.zhuqing.shopping.util.WindowUtil;

import org.w3c.dom.Text;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.hdodenhof.circleimageview.CircleImageView;

public class PublicActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private CircleImageView sortImageView;
    private TextView topTextView,sortTextView;
    private ImageView sortFlagImageView;
    private LinearLayout topLinearLayout;
    private List<LocalMedia> selectList;
    private GridView gridView;
    private List<String> imagePaths=new ArrayList<>();
    CustomGridAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        toolbar=(Toolbar)findViewById(R.id.public_toolbar);
        setSupportActionBar(toolbar);
        sortImageView=findViewById(R.id.public_sort_image);
        topTextView=findViewById(R.id.public_top_text);
        sortTextView=findViewById(R.id.public_sort_text);
        sortFlagImageView=findViewById(R.id.public_sort_flag);
        topLinearLayout=findViewById(R.id.public_top_layout);
       gridView=findViewById(R.id.public_gridview);


        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }
        WindowUtil.setStatusBar(this);


        adapter=new CustomGridAdapter(this,imagePaths);
        gridView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

    }




    @SuppressLint("ResourceType")
    public void onClickPublic(View view){
        switch (view.getId()){
            case R.id.public_top_layout:
//                topTextView.setVisibility(View.GONE);
//                sortImageView.setVisibility(View.VISIBLE);
//                sortTextView.setVisibility(View.VISIBLE);
//                sortFlagImageView.setVisibility(View.VISIBLE);
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .loadImageEngine(GlideEngine.createGlideEngine())
                        .isCamera(false)
                        .maxSelectNum(6)
.theme(R.style.picture_white_style)
                        .imageSpanCount(6)
                        .selectionMode(PictureConfig.MULTIPLE)
                        .isZoomAnim(true)

                        .forResult(PictureConfig.CHOOSE_REQUEST);
                // 相册主题

                break;
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
                    if(Build.VERSION.SDK_INT>=19)
                    {
                        for(int i=0;i<selectList.size();i++){

                            LocalMedia localMedia=selectList.get(i);
                            Log.d("test","Path              "+localMedia.getPath());
                            imagePaths.add(localMedia.getPath());

                        }
                    }
                    else {
                        for(int i=0;i<selectList.size();i++){

                            Uri uri=selectList.get(i)
                        }

                            LocalMedia localMedia=selectList.get(i);
                            Log.d("test","Path              "+localMedia.getPath());
                            imagePaths.add(localMedia.getPath());
                    }
                    for(int i=0;i<selectList.size();i++){

                        LocalMedia localMedia=selectList.get(i);
                      Log.d("test","Path              "+localMedia.getPath());
                      imagePaths.add(localMedia.getPath());

                    }
                //   Log.d("test", String.valueOf(imagePaths));
                    Log.d("test", String.valueOf(selectList));

                    adapter.notifyDataSetChanged();

                    break;
            }
        }
    }




}
