package com.zhuqing.shopping.item;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Tiezi;
import com.zhuqing.shopping.util.WindowUtil;

import java.util.ArrayList;
import java.util.List;

public class TieziDetailsActivity extends AppCompatActivity {


    Toolbar toolbar;
    TextView title,content;
    private Tiezi tiezi;
    int imageArray[];
    ImageView image1, image2, image3, image4, image5, image6;
    private LinearLayout imageLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiezi_details);
toolbar=findViewById(R.id.tieziDetail_toolbar);
        setSupportActionBar(toolbar);

        title=findViewById(R.id.tieziDetail_title);
        content=findViewById(R.id.tieziDetail_content);
        image1 = findViewById(R.id.tieziDetail_image_1);
        image2 = findViewById(R.id.tieziDetail_image_2);
        image3 = findViewById(R.id.tieziDetail_image_3);
        image4 = findViewById(R.id.tieziDetail_image_4);
        image5 = findViewById(R.id.tieziDetail_image_5);
        image6 = findViewById(R.id.tieziDetail_image_6);
        imageLinear = findViewById(R.id.tieziDetail_image_linearlayout);



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }
        WindowUtil.setStatusBar(this);

        tiezi = (Tiezi) getIntent().getSerializableExtra("tiezi");

        title.setText(tiezi.getTitle());
        content.setText(tiezi.getContent());
        List<ImageView> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        if (tiezi.getImageArrayNumber() > 4) {
            imageLinear.setVisibility(View.VISIBLE);
        }


        for (int i = 0; i < tiezi.getImageArrayNumber(); i++) {
            ImageView temp = images.get(i);
           // temp.setImageDrawable(tiezi.getImageArray());
            Glide.with(this).load(tiezi.getImageArray()[i]).into(temp);
        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return true;
    }
}
