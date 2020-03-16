package com.zhuqing.shopping.adapter;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.MsgActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.TopicLeft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private List<Commodity> mTopicList;
    private List<TopicLeft> mTopicLeftList;







    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView commodityImage;
        TextView commodityName;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                commodityName = itemView.findViewById(R.id.topic_item_textview);
                commodityImage = itemView.findViewById(R.id.topic_item_imageview);

        }


    }



    public TopicAdapter(List<Commodity> topicList){
            mTopicList=topicList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            View     theView1 = LayoutInflater.from(getContext()).inflate(R.layout.item_topic, parent, false);
            ViewHolder holder1 = new ViewHolder(theView1);
            return holder1;




    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.ViewHolder holder, int position) {

        Commodity commodity = mTopicList.get(position);
        FileInputStream inputStream= null;
        Glide.with(getContext()).load(commodity.getImageList().get(0)).into(holder.commodityImage);
        holder.commodityName.setText(commodity.getContent());




    }

    @Override
    public int getItemCount() {

        return mTopicList.size();}




    //region 分列

    //endregion
}
