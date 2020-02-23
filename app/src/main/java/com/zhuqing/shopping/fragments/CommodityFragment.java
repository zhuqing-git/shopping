package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Commodity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityFragment extends Fragment {
    RecyclerView recyclerView;
    List<Commodity>commodityList=new ArrayList<>();
    List<Integer>imageList=new ArrayList<>();
    private int flag;

    public CommodityFragment(int flag){
        this.flag=flag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_page2,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.page2_recyclerView);

        imageList.add(R.drawable.aaaa);
        for (int i=0;i<20;i++)
        {
            commodityList.add(new Commodity(i,"这是内容啊啊啊啊",1,2,3,4,imageList,null));
        }


        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        CommodityAdapter adapter=new CommodityAdapter(commodityList,3);
        recyclerView.setAdapter(adapter);



        return view;
    }
}
