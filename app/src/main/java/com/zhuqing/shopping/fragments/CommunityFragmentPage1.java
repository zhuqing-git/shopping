package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.adapter.TopicAdapter;
import com.zhuqing.shopping.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragmentPage1 extends Fragment {
    private List<Commodity> topicList=new ArrayList<>();

    private void initTopic() {
        for (int i = 0; i < 20; i++) {
            Commodity apple = new Commodity("综合", R.drawable.a1);
            topicList.add(apple);
            Commodity pear = new Commodity("Pear", R.drawable.a1);
            topicList.add(pear);
        }
    }


    private RecyclerView recyclerView1,recyclerView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_community_page1,container,false);

        recyclerView1=(RecyclerView)view.findViewById(R.id.community_page1_recycleview1);
        recyclerView2=(RecyclerView)view.findViewById(R.id.community_page1_recycleview2);


        LinearLayoutManager layoutManager1=new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager1);

        LinearLayoutManager layoutManager2=new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(layoutManager2);

        initTopic();

        TopicAdapter adapter=new TopicAdapter(topicList);
        recyclerView1.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);




        return view;
    }
}
