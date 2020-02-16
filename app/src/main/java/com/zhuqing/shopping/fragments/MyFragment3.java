package com.zhuqing.shopping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zhuqing.shopping.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment3 extends Fragment {


    CircleImageView imagePersion_sort;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3, container, false);


        return view;
    }
}






















