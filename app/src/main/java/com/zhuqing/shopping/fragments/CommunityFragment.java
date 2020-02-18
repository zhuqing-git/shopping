package com.zhuqing.shopping.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zhuqing.shopping.MainActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.util.CustomFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

   private TabLayout communityTablayout;
   private ViewPager communityViewPager;
   private List<Fragment> fragments;




    String[] topic = {"帖子","话题"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragement_community,container,false);

        communityTablayout=(TabLayout)view.findViewById(R.id.community_tablayout);
        communityViewPager=(ViewPager)view.findViewById(R.id.community_viewpager);


        fragments=new  ArrayList<Fragment>();
        fragments.add(new CommunityFragmentPage1());
        fragments.add(new CommunityFragmentPage2());

        CustomFragmentPagerAdapter madapter1 = new CustomFragmentPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments,topic);
        communityViewPager.setAdapter(madapter1);
        communityTablayout.setupWithViewPager(communityViewPager);



       return view;
    }
}
