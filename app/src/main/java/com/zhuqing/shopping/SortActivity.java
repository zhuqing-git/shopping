package com.zhuqing.shopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class SortActivity extends AppCompatActivity implements View.OnClickListener {

    List<Integer> imageUrlData;
    List<String> contentData;
    DrawerLayout drawerLayout;
    CircleImageView sortWay;
    Toolbar toolbar;
    RecyclerView recyclerView;
    CommodityAdapter adapter;
    int goodsType = 0;


    private String[] data = {"apple", "pear"};
    private List<Commodity> fruitList = new ArrayList<>();
    private List<Integer> imageList=new ArrayList<>();

    //region 初始化recycleView
    private void initFruits() {
        imageList.add(R.drawable.a1);
        for (int i = 0; i < 20; i++) {
            Commodity apple = new Commodity(1, "这里是内容", 20, 120,
                    124, 3,  imageList,null);
            fruitList.add(apple);

        }
    }

    private String getRandomLengthName(String apple) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(apple);
        }
        return builder.toString();
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        initFruits();
        recyclerView = findViewById(R.id.sort_recyclerView);
        drawerLayout = (DrawerLayout) findViewById(R.id.sort_drawer_layout);
        sortWay = (CircleImageView) findViewById(R.id.sort_way);
        adapter = new CommodityAdapter(fruitList,0);

        toolbar = (Toolbar) findViewById(R.id.sort_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }


        sortWay.setOnClickListener(this);

        imageUrlData = new ArrayList<>();
        contentData = new ArrayList<>();
        imageUrlData.add(R.drawable.d16);
        imageUrlData.add(R.drawable.d16);
        imageUrlData.add(R.drawable.d16);
        contentData.add("头像");
        contentData.add("头像");
        contentData.add("头像");


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort_way:
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
                if (goodsType == 0) {
                   // adapter.setType(1);
                    //2：设置对应的布局管理器
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));

                    //3：刷新adapter
                    adapter.notifyDataSetChanged();
                    goodsType = 1;
                } else {

                    //adapter.setType(0);
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                    adapter.notifyDataSetChanged();
                    goodsType = 0;
                }
                recyclerView.setAdapter(adapter);
                break;
            default:
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return true;
    }

//    private class Myloader extends ImageLoader {
//
//        @Override
//        public void displayImage(Context context, Object path, ImageView imageView) {
//
//
//            Glide.with(context).load(path).into(imageView);
//
//        }
//    }
}


