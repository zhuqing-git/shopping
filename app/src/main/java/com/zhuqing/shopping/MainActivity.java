package com.zhuqing.shopping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.zhuqing.shopping.fragments.MyFragment1;
import com.zhuqing.shopping.fragments.MyFragment2;
import com.zhuqing.shopping.fragments.MyFragment3;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageButton imageButton;
    CoordinatorLayout coordinatorLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView imagePersiion;
    //    CircleImageView imagePersion_sort;
    SearchView searchView1;
    TextView searchViewText;
    TabLayout tabLayout;
    ViewPager viewPager1;
    ViewPager viewPager2;
    List<Fragment> fragments1;
    List<Fragment> fragments2;
    String[] title = {"首页", "书本", "手机", "电脑", "数码", "美妆", "运动", "洗护", "电器"};
    BottomNavigationView bottomNavigationView;
    public static int width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView1 = (SearchView) findViewById(R.id.seachview_1);
        searchViewText = (TextView) findViewById(R.id.seachview_text);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager1 = (ViewPager) findViewById(R.id.viewpager);
        viewPager2 = (ViewPager) findViewById(R.id.viewpager_bottomnavigationview);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationView);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        imagePersiion = (CircleImageView) findViewById(R.id.image_persion);
//        imagePersion_sort = (CircleImageView) findViewById(R.id.sort_image_persion);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);


        imagePersiion.setOnClickListener(this);
//        imagePersion_sort.setOnClickListener(this);


//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        searchView1.setFocusable(false);


//        Display display=getWindowManager().getDefaultDisplay();
//        Point size=new Point();
//        display.getSize(size);
//        width=size.x;
//       height=size.y;


        //得到屏幕宽度
        int a = getApplicationContext().getApplicationContext().getResources()
                .getDisplayMetrics().widthPixels;
        width = a;
        //Log.d("test", String.valueOf(a));


        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //drawerLayout.closeDrawers();

                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        //region 添加碎片
        fragments1 = new ArrayList<>();
        fragments1.add(new MyFragment1());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());
        fragments1.add(new MyFragment2());

        fragments2 = new ArrayList<>();
        fragments2.add(new MyFragment3());
        fragments2.add(new MyFragment3());
        fragments2.add(new MyFragment3());
        //endregion

        adapter madapter1 = new adapter(getSupportFragmentManager(), fragments1);
        viewPager1.setAdapter(madapter1);
        tabLayout.setupWithViewPager(viewPager1);

        adapter madapter2 = new adapter(getSupportFragmentManager(), fragments2);
        viewPager2.setAdapter(madapter2);
        //viewpager的滑动配置
        viewPager2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        viewPager1.setVisibility(View.VISIBLE);
                        tabLayout.setVisibility(View.VISIBLE);
                        searchView1.setVisibility(View.VISIBLE);

                        searchViewText.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.GONE);
                        break;
                    case R.id.item2:
                        viewPager1.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        searchView1.setVisibility(View.GONE);

                        searchViewText.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(0);
                        // searchView2.setFocusable(false);
                        break;
                    case R.id.item3:
                        coordinatorLayout.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.item4:
                        coordinatorLayout.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    /**
     * 适配菜单项
     *
     * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    //region 点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_persion:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
//            case R.id.sort_up:
//                Intent intent = new Intent(MainActivity.this, SortsActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.dongtai_layout:
//                System.out.println("点击");
//                break;
//            case R.id.sort_image_persion:
//                Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
//                break;
            default:
                break;
        }
    }

    public void onClickLinearLayout(View view) {
        switch (view.getId()) {
            case R.id.dongtai_layout:
                Toast.makeText(this, "动态", Toast.LENGTH_SHORT).show();
                break;
            case R.id.guanzhu_layout:
                Toast.makeText(this, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fensi_layout:
                Toast.makeText(this, "粉丝", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shuben_layout:
                Toast.makeText(this, "书本", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SortActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    //endregion


    //region viewpage适配器
    private class adapter extends FragmentPagerAdapter {
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
            return title[position];

        }
    }
    //endregion


}