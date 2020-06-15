package com.zhuqing.shopping.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhuqing.shopping.LoginActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.adapter.CommentAdapter;
import com.zhuqing.shopping.adapter.CommodityAdapter;
import com.zhuqing.shopping.entity.Comment;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.util.AsyncTaskUtil;
import com.zhuqing.shopping.util.Config;
import com.zhuqing.shopping.util.HttpUtil;
import com.zhuqing.shopping.util.ValueUtility;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommentFragment extends Fragment {

    RecyclerView recyclerView;
    private int commodyId;
    CommentAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    List<Comment> commentList = new ArrayList<>();


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);


                    break;
                default:
                    break;
            }

        }
    };


    private String TAG = "CommodityFragment";

    public CommentFragment(int commodyId) {
        this.commodyId = commodyId;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.page2_recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.fragment_page2_swipe);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshComment();

            }
        });
        refreshComment();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new CommentAdapter(commentList);

        recyclerView.setAdapter(adapter);

        return view;
    }

    private void refreshComment() {
        commentList.clear();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpUtil.GetUtil.GetComment(commentList,commodyId);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }
        ).start();

    }
}
