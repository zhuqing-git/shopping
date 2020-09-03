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
import com.zhuqing.shopping.entity.Tiezi;
import com.zhuqing.shopping.util.ValueUtility;

import java.util.ArrayList;
import java.util.List;

public class TieziFragment extends Fragment {
    RecyclerView recyclerView;
    List<Tiezi>tieziList=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_page2,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.page2_recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
int[] imageArray={R.drawable.login};

        tieziList.add(new Tiezi(ValueUtility.getUserId(),"这里是标题","没有内容",imageArray,1));

        TieziAdapter adapter=new TieziAdapter(tieziList);
        recyclerView.setAdapter(adapter);





        return view;
    }
}
