package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommentAdapter;
import com.zhuqing.shopping.adapter.FansNameAdapter;

import com.zhuqing.shopping.adapter.MessageAdapter;
import com.zhuqing.shopping.entity.FansName;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    MessageAdapter adapter;
    private List<FansName> fansName = new ArrayList<>();


    //region 初始化recycleView
    private void initFruits() {
        for (int i = 0; i < 20; i++) {

            fansName.add(new FansName("张三",R.drawable.d1,"新的消息"));
            fansName.add(new FansName("李四",R.drawable.d1,"新的消息"));

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.page2_recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.fragment_page2_swipe);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshMessage();

            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new MessageAdapter(fansName,getContext(),0);
        refreshMessage();

        recyclerView.setAdapter(adapter);

        return view;
    }

    private void refreshMessage(){
        initFruits();
        adapter.notifyDataSetChanged();

    }


}


