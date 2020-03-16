package com.zhuqing.shopping.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFragment1 extends Fragment implements View.OnClickListener {
    Banner myBanner;
    List<Integer> imageUrlData;
    List<String> imageList=new ArrayList<>();
    List<String> contentData;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
     List<Commodity> commodityList = new ArrayList<>();
    CommodityAdapter adapter1;
    int state=0;
    int flag=0;


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    adapter1.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);

                    break;
                default:
                    break;
            }

        }
    };













    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);

         recyclerView = view.findViewById(R.id.page1_recyclerView);
        swipeRefreshLayout=view.findViewById(R.id.fragment_page1_swipe);
        myBanner = (Banner) view.findViewById(R.id.banner);




        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);

        adapter1 = new CommodityAdapter(commodityList,flag,state);
        refreshCommody();
        recyclerView.setAdapter(adapter1);


        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCommody();

            }
        });






        imageUrlData = new ArrayList<>();
        contentData = new ArrayList<>();
        imageUrlData.add(R.drawable.default_head);
        imageUrlData.add(R.drawable.default_head);
        imageUrlData.add(R.drawable.default_head);
        contentData.add("头像");
        contentData.add("头像");
        contentData.add("头像");
        myBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        myBanner.setImageLoader(new Myloader());
        myBanner.setImages(imageUrlData);
        myBanner.setBannerTitles(contentData);
        myBanner.setBannerAnimation(Transformer.Default);
        myBanner.setDelayTime(2000);
        myBanner.isAutoPlay(true);
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        myBanner.start();
        return view;
    }

    @Override
    public void onClick(View v) {

    }


    private class Myloader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {


            Glide.with(context).load(path).into(imageView);

        }
    }


    //region 初始化recycleView
    private void refreshCommody() {
        commodityList.clear();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpUtil.GetUtil.GetCommody(commodityList,state) ;
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






















