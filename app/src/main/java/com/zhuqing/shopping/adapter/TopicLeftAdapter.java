package com.zhuqing.shopping.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.TopicLeft;

import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class TopicLeftAdapter extends RecyclerView.Adapter<TopicLeftAdapter.ViewHolder> {

    private List<TopicLeft> mTopicLeftList;
    private int thisPosition;

    public int getThisPosition() {
        return thisPosition;
    }

    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View topicView;
        TextView topicName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicView = itemView;
            topicName = itemView.findViewById(R.id.topic_item_leftview);
        }
    }


    public TopicLeftAdapter(List<TopicLeft> topicLeftList) {

        mTopicLeftList = topicLeftList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        final View theView1 = LayoutInflater.from(getContext()).inflate(R.layout.item_topic_left, parent, false);


        final ViewHolder holder1 = new ViewHolder(theView1);
        holder1.topicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setThisPosition(holder1.getAdapterPosition());
                notifyDataSetChanged();

            }
        });


        return holder1;


    }

    @Override
    public void onBindViewHolder(@NonNull TopicLeftAdapter.ViewHolder holder, int position) {

        TopicLeft topicLeft = mTopicLeftList.get(position);
        holder.topicName.setText(topicLeft.getTitle());
        if (position == getThisPosition()) {
            holder.itemView.setBackgroundColor(Color.YELLOW);
        } else {
            holder.itemView.setBackgroundColor(Color.RED);
        }


    }

    @Override
    public int getItemCount() {

        return mTopicLeftList.size();

    }


    //region 分列

    //endregion
}
