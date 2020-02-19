package com.zhuqing.shopping.nav_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.fragments.FansFragment;
import com.zhuqing.shopping.util.AppBarStateChangeListener;

import java.util.ArrayList;
import java.util.List;

public class DynamicActivity extends AppCompatActivity implements View.OnClickListener{
    TabLayout tabLayout;
    Toolbar dynamicToolbar;
    ViewPager fansViewPager;
    List<Fragment> fansFragments;
    AppBarLayout dynamicAppbar;
    TextView dynamicHead,dynamicUsername;
    FloatingActionButton dynamicImagePerson;
    LinearLayout dynamicLinearLayout;


    String[] fansTitle = {"我的关注", "我的粉丝"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        dynamicToolbar=(Toolbar) findViewById(R.id.dynamic_toolbar);
       // dynamicToolbar.setTitle("朱庆");
        setSupportActionBar(dynamicToolbar);
        dynamicAppbar=(AppBarLayout)findViewById(R.id.dynamic_appBarLayout);
       // dynamicHead=(TextView)findViewById(R.id.dynamic_username_head);
        tabLayout=(TabLayout)findViewById(R.id.dynamic_tablayout);
        fansViewPager=(ViewPager)findViewById(R.id.dynamic_viewpager);
        dynamicImagePerson=(FloatingActionButton)findViewById(R.id.dynamic_image_person);
       // dynamicUsername=findViewById(R.id.dynamic_username);
      //  dynamicLinearLayout=findViewById(R.id.dynamic_linearlayout);


        dynamicAppbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {

                if( state == State.EXPANDED ) {
                   // dynamicHead.setVisibility(View.GONE);
                    dynamicImagePerson.setVisibility(View.VISIBLE);
                   // dynamicUsername.setVisibility(View.VISIBLE);
                   // dynamicLinearLayout.setVisibility(View.VISIBLE);

                    //展开状态

                }else if(state == State.COLLAPSED){
                   // dynamicHead.setVisibility(View.VISIBLE);
                    dynamicImagePerson.setVisibility(View.GONE);
                  //  dynamicUsername.setVisibility(View.GONE);
                   // dynamicLinearLayout.setVisibility(View.GONE);




                    //折叠状态

                }else {
                    //dynamicHead.setVisibility(View.GONE);
                    dynamicImagePerson.setVisibility(View.VISIBLE);
                   // dynamicUsername.setVisibility(View.VISIBLE);
                    //dynamicLinearLayout.setVisibility(View.VISIBLE);
//



                    //中间状态

                }
            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }

        fansFragments=new ArrayList<>();
        fansFragments.add(new FansFragment(0));
        fansFragments.add(new FansFragment(1));

       DynamicActivity.adapter madapter1 = new DynamicActivity.adapter(getSupportFragmentManager(), fansFragments);
        fansViewPager.setAdapter(madapter1);
        tabLayout.setupWithViewPager(fansViewPager);

        Intent intent=getIntent();
        Boolean state= intent.getBooleanExtra("state",false);
        if(state)
            tabLayout.getTabAt(1).select();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }

    //region viewpage适配器
    class adapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public adapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
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
            return fansTitle[position];

        }
    }
    //endregion
}
