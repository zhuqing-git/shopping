package com.zhuqing.shopping.fragments;

import android.content.Context;
import android.os.Bundle;
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

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFragment2 extends Fragment {



    List<Integer> imageUrlData;
    List<String> contentData;
    int status=0;
    private List<Integer> imageList=new ArrayList<>();

    public MyFragment2(int status){
        this.status=status;
    }
    public MyFragment2(){}



    private String[] data = {"apple", "pear"};
    private List<Commodity> fruitList = new ArrayList<>();


    //region 初始化recycleView
    private void initFruits() {
        imageList.add(R.drawable.d1);
        imageList.add(R.drawable.a1);
        for (int i = 0; i < 20; i++) {
            Commodity apple = new Commodity(1, "这里是内容", 20, 120,
                    124, 3,  imageList,null);
            fruitList.add(apple);
            Commodity pear = new Commodity(1, "这里是内容", 20, 120,
                    124, 3,  imageList,null);
            fruitList.add(pear);
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        initFruits();
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

        CommodityAdapter adapter = new CommodityAdapter(fruitList,0);
        recyclerView.setAdapter(adapter);

        imageUrlData = new ArrayList<>();
        contentData = new ArrayList<>();
        imageUrlData.add(R.drawable.d16);
        imageUrlData.add(R.drawable.d16);
        imageUrlData.add(R.drawable.d16);
        contentData.add("头像");
        contentData.add("头像");
        contentData.add("头像");

        return view;
    }


    private class Myloader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {


            Glide.with(context).load(path).into(imageView);

        }
    }
}






















