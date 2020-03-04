package com.zhuqing.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.zhuqing.shopping.fragments.CommunityFragment;
import com.zhuqing.shopping.fragments.MyFragment1;
import com.zhuqing.shopping.fragments.MyFragment2;
import com.zhuqing.shopping.fragments.MyFragment3;
import com.zhuqing.shopping.nav_activity.CollectionActivity;
import com.zhuqing.shopping.nav_activity.DynamicActivity;
import com.zhuqing.shopping.nav_activity.ExchangeActivity;
import com.zhuqing.shopping.nav_activity.Fans;
import com.zhuqing.shopping.util.CustomFragmentPagerAdapter;
import com.zhuqing.shopping.util.CustomViewPager;
import com.zhuqing.shopping.util.WindowUtil;
import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    Context context = this;


    ImageButton imageButton;
    Toolbar toolbar;
    CoordinatorLayout coordinatorLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView imagePersiion,rightCirclaImageView;
    CircleImageView navImagePerson;
    //    CircleImageView imagePersion_sort;
    SearchView searchView1;
    TextView searchViewText;
    TabLayout tabLayout;
    ViewPager viewPager1;
    CustomViewPager viewPager2;
    List<Fragment> fragments1, fragments2;
    AppBarLayout appBar;
    AppBarLayout.LayoutParams params;
    View headerLayout;


    BottomNavigationView bottomNavigationView;
    public static int width;

    String[] title = {"首页", "书本", "手机", "电脑", "数码", "美妆", "运动", "洗护", "电器"};

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.set
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView1 = (SearchView) findViewById(R.id.seachview_1);
        searchViewText = (TextView) findViewById(R.id.main_title);

        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewPager1 = (ViewPager) findViewById(R.id.viewpager);
        viewPager2 = (CustomViewPager) findViewById(R.id.viewpager_bottomnavigationview);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationView);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        imagePersiion = (CircleImageView) findViewById(R.id.image_persion);
        rightCirclaImageView=(CircleImageView)findViewById(R.id.main_right_circleimageview);
         headerLayout = navigationView.inflateHeaderView(R.layout.nav_hander);
        navImagePerson = headerLayout.findViewById(R.id.nav_head_image_person);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        appBar=(AppBarLayout)findViewById(R.id.appBarLayout);
         params=(AppBarLayout.LayoutParams)toolbar.getLayoutParams();

          //取消上划时顶部阴影
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//
//            appBar.setOutlineProvider(null);
//
//        }

        Log.d("test", String.valueOf(Build.VERSION.SDK_INT));

        imagePersiion.setOnClickListener(this);
        navImagePerson.setOnClickListener(this);
        rightCirclaImageView.setOnClickListener(this);
//        imagePersion_sort.setOnClickListener(this);


//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        searchView1.setFocusable(false);




        WindowUtil.setStatusBar(this);







        // navigationView.setBackground(Color.parseColor("#fff"));
        navigationView.setCheckedItem(R.id.nav_main);

        //navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.nav_logout:
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        LoginActivity.editor.putBoolean("verification", false).apply();
                        finish();
                        break;
                    case R.id.nav_collect:
                        Intent intent1 = new Intent(MainActivity.this, CollectionActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_public:
                        Intent intent4 = new Intent(MainActivity.this, ExchangeActivity.class);
                        intent4.putExtra("state", "我发布的");
                        startActivity(intent4);
                        break;

                    case R.id.nav_sell:
                        Intent intent2 = new Intent(MainActivity.this, ExchangeActivity.class);
                        intent2.putExtra("state", "我卖出的");
                        startActivity(intent2);
                        break;
                    case R.id.nav_buy:
                        Intent intent3 = new Intent(MainActivity.this, ExchangeActivity.class);
                        intent3.putExtra("state", "我买到的");
                        startActivity(intent3);
                        break;
                    case R.id.nav_test:
                        drawerLayout.closeDrawers();
                        viewPager1.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        searchView1.setVisibility(View.GONE);
                        //  rightCirclaImageView.setVisibility(View.GONE);

                        searchViewText.setVisibility(View.VISIBLE);
                        searchViewText.setText("社区");




                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(2);



                        //禁止appbar滑动隐藏
                        params.setScrollFlags(0);
                        break;


                    default:
                        drawerLayout.closeDrawers();

                        break;
                }

                return true;
            }
        });


        //region 添加碎片
        fragments1 = new ArrayList<>();
        fragments1.add(new MyFragment1());
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));
        fragments1.add(new MyFragment2(0));

        fragments2 = new ArrayList<>();
        fragments2.add(new MyFragment3());
        fragments2.add(new MyFragment2(2));
        fragments2.add(new CommunityFragment());
        //endregion

        CustomFragmentPagerAdapter madapter1 = new CustomFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments1, title);
        viewPager1.setAdapter(madapter1);
        tabLayout.setupWithViewPager(viewPager1);

        CustomFragmentPagerAdapter madapter2 = new CustomFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments2, title);
        viewPager2.setAdapter(madapter2);
        viewPager2.setScanScroll(false);



        //region bottomNavigatinView 点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        searchViewText.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.GONE);


                        viewPager1.setVisibility(View.VISIBLE);
                        tabLayout.setVisibility(View.VISIBLE);
                        searchView1.setVisibility(View.VISIBLE);


                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS|AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP|
                                AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        toolbar.setLayoutParams(params);




                        break;
                    case R.id.item2:
                        viewPager1.setVisibility(View.VISIBLE);
                        tabLayout.setVisibility(View.GONE);
                        searchView1.setVisibility(View.GONE);


                        searchViewText.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(0);
                        // searchView2.setFocusable(false);
                     //   scroll|enterAlways|snap


                        break;
                    case R.id.item3:
                        viewPager1.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        searchView1.setVisibility(View.GONE);


                        searchViewText.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.item4:
                        viewPager1.setVisibility(View.GONE);
                        tabLayout.setVisibility(View.GONE);
                        searchView1.setVisibility(View.GONE);
                      //  rightCirclaImageView.setVisibility(View.GONE);

                        searchViewText.setVisibility(View.VISIBLE);
                        searchViewText.setText("社区");




                        viewPager2.setVisibility(View.VISIBLE);
                        viewPager2.setCurrentItem(2);



                        //禁止appbar滑动隐藏
                        params.setScrollFlags(0);









                    default:
                        break;
                }
                return true;
            }
        });
        //endregion





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
            case R.id.nav_head_image_person:
                Intent intent = new Intent(this, DynamicActivity.class);
                startActivity(intent);
                break;
            case R.id.main_right_circleimageview:
                Intent intent1=new Intent(this,PublicActivity.class);
                startActivity(intent1);

                break;

            default:
                break;
        }
    }


    public void onClickLinearLayout(View view) {
        switch (view.getId()) {
            // case R.id.nav_image_person:
            case R.id.dongtai_layout:
                Intent intent1 = new Intent(this, DynamicActivity.class);
                startActivity(intent1);
                break;
            case R.id.guanzhu_layout:
                Intent intent2 = new Intent(this, Fans.class);
                intent2.putExtra("state", false);
                startActivity(intent2);
                break;
            case R.id.fans_layout:
                Intent intent3 = new Intent(this, Fans.class);
                intent3.putExtra("state", true);
                startActivity(intent3);

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


}