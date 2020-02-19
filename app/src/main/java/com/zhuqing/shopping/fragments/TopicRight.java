package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.zhuqing.shopping.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

public class TopicRight extends Fragment {

    RecyclerView recyclerView;
    List<Commodity> topicRightList= new ArrayList<>();

    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Commodity apple = new Commodity("Apple", R.drawable.a1);
            topicRightList.add(apple);
            Commodity pear = new Commodity("Pear", R.drawable.pear);
            topicRightList.add(pear);
        }
    }

    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_topic_right,container,false);

       recyclerView=(RecyclerView) view.findViewById(R.id.fragment_topic_right_recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(manager);
        initFruits();
        CommodityAdapter adapter=new CommodityAdapter(topicRightList,1);
        recyclerView.setAdapter(adapter);
        Log.d("test","create");
       return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("test","stop");
    }

    @Override
    public void onDestroyView() {
        Log.d("test","hello");
        super.onDestroyView();
    }
}
