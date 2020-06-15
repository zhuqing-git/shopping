package com.zhuqing.shopping.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.Config;
import com.zhuqing.shopping.util.CustomLinearLayoutManager;
import com.zhuqing.shopping.util.HttpUtil;

import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFragment2 extends Fragment {




    int status=0;
    int topic;


     List<Commodity> commodityList=new ArrayList<>();
     CommodityAdapter adapter;
  private SwipeRefreshLayout swipeRefreshLayout;

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

    public MyFragment2(int status,int topic){
        this.status=status;
        this.topic=topic;
    }
   // public MyFragment2(){}









    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        swipeRefreshLayout=view.findViewById(R.id.fragment_page2_swipe);
        RecyclerView recyclerView = view.findViewById(R.id.page2_recyclerView);

        if(status==0)
        {
            //网格视图
            GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(manager);
        }else if(status==1)
        {
            //线性视图
            LinearLayoutManager manager=new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(manager);
        }
        else if(status==2)
        {
            //禁止横向滑动
            CustomLinearLayoutManager manager=new CustomLinearLayoutManager(getContext());
            recyclerView.setLayoutManager(manager);
        }



         adapter = new CommodityAdapter(commodityList,0,0);
        refreshCommody();
        recyclerView.setAdapter(adapter);


        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCommody();

            }
        });



        return view;
    }


    private void refreshCommody() {
        commodityList.clear();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpUtil.GetUtil.GetSortCommody(commodityList,Config.getCommodyNumber,0,topic,0);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }
        ).start();

    }
}






















