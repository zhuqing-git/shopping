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
import com.zhuqing.shopping.adapter.TieziAdapter;
import com.zhuqing.shopping.adapter.TopicAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.FansName;
import com.zhuqing.shopping.entity.Tiezi;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragmentPage1 extends Fragment {
    private List<String> topicList=new ArrayList<>();
    private List<Tiezi> tieziList=new ArrayList<>();
    private List<String> imageList= new ArrayList<>();







    private void initTiezi() {
        for (int i = 0; i < 20; i++) {
            Tiezi apple = new Tiezi("用户名",R.drawable.default_head,"标题","这里是内容","综合",12,
                    20,R.drawable.aaaa,R.drawable.aaaa,R.drawable.aaaa);
            tieziList.add(apple);
        }
    }



    private void initTopic() {
        imageList.add(String.valueOf(R.drawable.a1));
        imageList.add(String.valueOf(R.drawable.d1));
        for (int i = 0; i < 4; i++) {

            imageList.add(String.valueOf(R.drawable.a1));
            imageList.add(String.valueOf(R.drawable.d1));
            topicList.add("第一");
            topicList.add("第二");

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
        initTiezi();

        TopicAdapter adapter=new TopicAdapter(topicList,imageList);
        recyclerView1.setAdapter(adapter);

        TieziAdapter tieziAdapter=new TieziAdapter(tieziList);
        recyclerView2.setAdapter(tieziAdapter);




        return view;
    }
}
