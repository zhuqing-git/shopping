package com.zhuqing.shopping.item;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommentAdapter;
import com.zhuqing.shopping.entity.Comment;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.fragments.CommentFragment;
import com.zhuqing.shopping.fragments.MyFragment2;
import com.zhuqing.shopping.util.CustomFragmentPagerAdapter;
import com.zhuqing.shopping.util.CustomPopWindow;
import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.ValueUtility;
import com.zhuqing.shopping.util.WindowUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommodyActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    Toolbar toolbar;
    TextView content, money;
    Commodity commodity;
    ImageView image1, image2, image3, image4, image5, image6;
    LinearLayout imageLinear;
    private CustomPopWindow popWindow;
    ViewPager viewPager;
    SwipeRefreshLayout swipeRefreshLayout;
    List<Comment> commentList = new ArrayList<>();
    CommentAdapter adapter;
    List<Fragment> fragments = new ArrayList<>();
    String[] fansTitle = {"我的关注", "我的粉丝"};


//    private Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    //adapter.notifyDataSetChanged();
//
//
//                   // swipeRefreshLayout.setRefreshing(false);
//
//
//
//
//                    break;
//
//                default:
//                    break;
//            }
//
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commody);
        toolbar = findViewById(R.id.commody_toolbar);
        setSupportActionBar(toolbar);


        content = findViewById(R.id.commody_content);
        money = findViewById(R.id.commody_money);
        image1 = findViewById(R.id.commody_image_1);
        image2 = findViewById(R.id.commody_image_2);
        image3 = findViewById(R.id.commody_image_3);
        image4 = findViewById(R.id.commody_image_4);
        image5 = findViewById(R.id.commody_image_5);
        image6 = findViewById(R.id.commody_image_6);
        imageLinear = findViewById(R.id.commody_image_linearlayout);
        viewPager = findViewById(R.id.commody_viewpager);
//        swipeRefreshLayout=findViewById(R.id.comment_swipe);

context=this;
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        WindowUtil.setStatusBar(this);

        commodity = (Commodity) getIntent().getSerializableExtra("commodity");

//        if (commodity.getMessage()==0)
//            viewPager.setVisibility(View.GONE);
        fragments.add(new CommentFragment(commodity.getCommodyId()));

        adapter madapter1 = new adapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(madapter1);
//

        content.setText(commodity.getContent());
        money.setText(String.valueOf(commodity.getMoney()));
        List<ImageView> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        if (commodity.getImageList().size() > 4) {
            imageLinear.setVisibility(View.VISIBLE);
        }


        for (int i = 0; i < commodity.getImageList().size(); i++) {
            ImageView temp = images.get(i);
            Glide.with(this).load(commodity.getImageList().get(i)).into(temp);
        }


//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                try {
//                    refreshComment();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

    }


    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            popWindow.dismiss();
            switch (v.getId()) {
                case R.id.window_pop_1:
                    Toast.makeText(v.getContext(), "niaho", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.window_pop_3:
                    break;


            }
        }
    };


    public void onClickOnCommody(View v) {
        switch (v.getId()) {
            case R.id.commody_buy:
                popWindow = new CustomPopWindow(this, commodyItemClick, 4);
                popWindow.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        popWindow.backgroundAlpha(CommodyActivity.this, 1f);
                    }
                });
        }
    }

    private View.OnClickListener commodyItemClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.window_pop_4:
                    popWindow.dismiss();
                    finish();



//                                Log.d("test", "run: -----------"+commodity.getCommodyId());
//                                String address="http://192.168.43.17:8080/sell_commody/"+commodity.getCommodyId()+ "/1";
//                                Request request=new Request.Builder().url(address).build();
//                                OkHttpClient client=new OkHttpClient();
//                    try {
//                        client.newCall(request).execute();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }


            }

        }
    };

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return true;
    }


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
}
