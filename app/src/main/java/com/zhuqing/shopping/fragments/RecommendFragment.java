package com.zhuqing.shopping.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.zhuqing.shopping.MainActivity;
import com.zhuqing.shopping.R;
//import com.zhuqing.shopping.adapter.TopicAdapter;
//import com.zhuqing.shopping.adapter.TopicLeftAdapter;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.Tiezi;
import com.zhuqing.shopping.util.ValueUtility;
//import com.zhuqing.shopping.entity.TopicLeft;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {


    AppBarLayout appBarLayout;
    TextView title,content;
    private Tiezi tiezi;
    int imageArray[];
    ImageView image1, image2, image3, image4, image5, image6;
    private LinearLayout imageLinear;
    LinearLayout tieziDetail_shenglue_linearLayout;
 //  RecyclerView leftRecyclerView,rightRecyclerView;
  //  private List<TopicLeft> fruitList = new ArrayList<>();
    //region 初始化recycleView
//    private void initFruits() {
//        for (int i = 0; i < 2; i++) {
//            TopicLeft apple = new TopicLeft("我的关注");
//            fruitList.add(apple);
//            TopicLeft pear = new TopicLeft("全部话题");
//            fruitList.add(pear);
//        }
//    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_tiezi_details,container,false);

      //  leftRecyclerView=(RecyclerView) view.findViewById(R.id.topic_page2_recleft);
       // rightRecyclerView=(RecyclerView)view.findViewById(R.id.topic_page2_recright);



     //   initFruits();
        appBarLayout=view.findViewById(R.id.tieziDetail_appbar);
        appBarLayout.setVisibility(View.GONE);

        title=view.findViewById(R.id.tieziDetail_title);
        content=view.findViewById(R.id.tieziDetail_content);
        image1 = view.findViewById(R.id.tieziDetail_image_1);
        image2 =view. findViewById(R.id.tieziDetail_image_2);
        image3 = view.findViewById(R.id.tieziDetail_image_3);
        image4 = view.findViewById(R.id.tieziDetail_image_4);
        image5 = view.findViewById(R.id.tieziDetail_image_5);
        image6 =view. findViewById(R.id.tieziDetail_image_6);
        imageLinear =view. findViewById(R.id.tieziDetail_image_linearlayout);
       // tieziDetail_shenglue_linearLayout=view.findViewById(R.id.tieziDetail_shenglue_linearLayout);


//        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(0,0,0,0);
//        tieziDetail_shenglue_linearLayout.setLayoutParams(lp);

        int[] imageList={R.drawable.login};
        tiezi = new Tiezi(ValueUtility.getUserId(),"这是推荐内容","内容------------------------",imageList,1);

        title.setText(tiezi.getTitle());
        content.setText(tiezi.getContent());
        List<ImageView> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        if (tiezi.getImageArrayNumber() > 4) {
            imageLinear.setVisibility(View.VISIBLE);
        }


        for (int i = 0; i < tiezi.getImageArrayNumber(); i++) {
            ImageView temp = images.get(i);
            // temp.setImageDrawable(tiezi.getImageArray());
            Glide.with(this).load(tiezi.getImageArray()[i]).into(temp);
        }


//       LinearLayoutManager manager=new LinearLayoutManager(getContext());
//        leftRecyclerView.setLayoutManager(manager);
//        TopicLeftAdapter adapter=new TopicLeftAdapter(fruitList);
//        leftRecyclerView.setAdapter(adapter);






        return view;
    }
}
