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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
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
   FragmentManager fragmentManager;




    String[] topic = {"帖子","话题"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragement_community,container,false);

        communityTablayout=(TabLayout)view.findViewById(R.id.community_tablayout);
        communityViewPager=(ViewPager)view.findViewById(R.id.community_viewpager);



//        fragmentManager=getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
        fragments=new  ArrayList<Fragment>();
        fragments.add(new CommunityFragmentPage1());
        fragments.add(new CommunityFragmentPage2());
//        fragments.add(new CommunityFragmentPage1());
//        fragments.add(new CommunityFragmentPage2());
//        fragmentTransaction.add(R.id.fragment_bottom_frame,fragments.get(0));
//        fragmentTransaction.add(R.id.fragment_bottom_frame,fragments.get(1));
//        fragmentTransaction.commit();


        CustomFragmentPagerAdapter madapter1 = new CustomFragmentPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments,topic);
        communityViewPager.setAdapter(madapter1);
        communityTablayout.setupWithViewPager(communityViewPager);



       return view;
    }

    @Override
    public void onStart() {
        super.onStart();






    }
}
