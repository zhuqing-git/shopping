package com.zhuqing.shopping.nav_activity;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.db.User;
import com.zhuqing.shopping.fragments.CommodityFragment;
import com.zhuqing.shopping.fragments.FansFragment;
import com.zhuqing.shopping.fragments.MyFragment1;
import com.zhuqing.shopping.fragments.MyFragment2;
import com.zhuqing.shopping.fragments.MyFragment3;
import com.zhuqing.shopping.fragments.TieziFragment;
import com.zhuqing.shopping.nav_activity.Fans;
import com.zhuqing.shopping.util.WindowUtil;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExchangeActivity extends AppCompatActivity implements View.OnClickListener{

    TabLayout tabLayout;
    Toolbar fansToolbar;
    ViewPager fansViewPager;
    List<Fragment> fansFragments;
    TextView titleView;
    int status=0;


    String[] publicTlte = {"我的帖子", "我的宝贝"};
String[]sellTitle={""};
    String[] buyTitle={"买到的宝贝"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        fansToolbar=(Toolbar) findViewById(R.id.fans_toolbar);
        setSupportActionBar(fansToolbar);
        tabLayout=(TabLayout)findViewById(R.id.fans_tablayout);
        fansViewPager=(ViewPager)findViewById(R.id.fans_viewpager);
        titleView=findViewById(R.id.exchange_title);



        String titleText=getIntent().getStringExtra("state");
        titleView.setText(titleText);





        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.d1);//设置背景图片
        }
        WindowUtil.setStatusBar(this);


        Intent intent=getIntent();
        String state= intent.getStringExtra("state");
        if(state.equals("我发布的"))
        {
            this.status=0;
            tabLayout.setVisibility(View.VISIBLE);
            fansFragments=new ArrayList<>();
            fansFragments.add(new TieziFragment());
            fansFragments.add(new CommodityFragment(3));
            adapter   madapter1 = new adapter(getSupportFragmentManager(), fansFragments);
            fansViewPager.setAdapter(madapter1);
            tabLayout.setupWithViewPager(fansViewPager);

        }
       else if(state.equals("我卖出的"))
        {
            this.status=1;
            tabLayout.setVisibility(View.GONE);
            fansFragments=new ArrayList<>();
            fansFragments.add(new CommodityFragment(3));
            adapter   madapter1 = new adapter(getSupportFragmentManager(), fansFragments);
            fansViewPager.setAdapter(madapter1);
        } else
        {
            this.status=2;
            tabLayout.setVisibility(View.GONE);
            fansFragments=new ArrayList<>();
            fansFragments.add(new CommodityFragment(3));
            adapter   madapter1 = new adapter(getSupportFragmentManager(), fansFragments);
            fansViewPager.setAdapter(madapter1);
        }




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
            if (status==0)
            return publicTlte[position];
            else if (status==1)
                return sellTitle[position];
            else return buyTitle[position];

        }
    }
    //endregion
}
