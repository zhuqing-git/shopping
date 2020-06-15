package com.zhuqing.shopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.Config;
import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.WindowUtil;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;



public class SortActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    CircleImageView sortWay;
    Toolbar toolbar;
    RecyclerView recyclerView;
    CommodityAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RadioGroup radioGroup;
    int topic;



    private List<Commodity> commodityList = new ArrayList<>();
    private int goodsType=0;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);


                    break;
                default:
                    break;
            }

        }
    };


    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        recyclerView = findViewById(R.id.sort_recyclerView);
        drawerLayout = (DrawerLayout) findViewById(R.id.sort_drawer_layout);
        sortWay = (CircleImageView) findViewById(R.id.sort_way);
        swipeRefreshLayout=findViewById(R.id.sort_swipeRefreshLayout);
        radioGroup=findViewById(R.id.sort_radioGroup);
        toolbar = (Toolbar) findViewById(R.id.sort_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }

        WindowUtil.setStatusBar(this);

        String sort=getIntent().getStringExtra("sort");

       topic= Config.GetSortNumber(sort);


        sortWay.setOnClickListener(this);

        adapter = new CommodityAdapter(commodityList,0,0);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        refreshCommody(0);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCommody(0);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.sort_jiage_btn)
                {
                   refreshCommody(1);
                }
                if (checkedId==R.id.sort_zhonghe_btn)
                {
                    refreshCommody(0);
                }
                if (checkedId==R.id.sort_shoucang_btn)
                {
                    refreshCommody(2);
                }
                if (checkedId==R.id.sort_xinyongfen_btn)
                {
                    refreshCommody(3);
                }
            }
        });
    }

    //flag(综合，价格，收藏，信用
    private void refreshCommody(int flag) {

        commodityList.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                        HttpUtil.GetUtil.GetSortCommody(commodityList,Config.getCommodyNumber,0,topic,flag);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();

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




}


