package com.zhuqing.shopping.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.MainActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.TopicAdapter;
import com.zhuqing.shopping.adapter.TopicLeftAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.TopicLeft;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragmentPage2 extends Fragment {


   RecyclerView leftRecyclerView,rightRecyclerView;
    private List<TopicLeft> fruitList = new ArrayList<>();
    //region 初始化recycleView
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            TopicLeft apple = new TopicLeft("我的关注");
            fruitList.add(apple);
            TopicLeft pear = new TopicLeft("全部话题");
            fruitList.add(pear);
        }
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_community_page2,container,false);

        leftRecyclerView=(RecyclerView) view.findViewById(R.id.topic_page2_recleft);
       // rightRecyclerView=(RecyclerView)view.findViewById(R.id.topic_page2_recright);



        initFruits();



       LinearLayoutManager manager=new LinearLayoutManager(getContext());
        leftRecyclerView.setLayoutManager(manager);
        TopicLeftAdapter adapter=new TopicLeftAdapter(fruitList);
        leftRecyclerView.setAdapter(adapter);




        return view;
    }
}
