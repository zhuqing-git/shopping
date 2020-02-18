package com.zhuqing.shopping.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;



public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> list;
    private String[] title;


    public CustomFragmentPagerAdapter(@NonNull FragmentManager fm, int behaver,List<Fragment> list,String[] title ) {
        super(fm,behaver);
        this.list=list;
        this.title=title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];

    }
}