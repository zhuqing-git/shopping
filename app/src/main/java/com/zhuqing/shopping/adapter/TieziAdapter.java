package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;
import com.zhuqing.shopping.entity.Tiezi;
import com.zhuqing.shopping.entity.TopicLeft;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static org.litepal.LitePalApplication.getContext;

public class TieziAdapter extends RecyclerView.Adapter<TieziAdapter.ViewHolder> {
    private List<Tiezi> tieziList;



    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView headImageView;

        ImageView imageView1,imageView2,imageView3;
        TextView nameView,titleView,contentView,pariseView,commontView,topicView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                headImageView = itemView.findViewById(R.id.item_tiezi_headImage);
                 imageView1= itemView.findViewById(R.id.item_tiezi_image1);
            imageView2 = itemView.findViewById(R.id.item_tiezi_image2);
            imageView3= itemView.findViewById(R.id.item_tiezi_image3);
            nameView = itemView.findViewById(R.id.item_tiezi_name);
            titleView= itemView.findViewById(R.id.item_tiezi_title);
            contentView = itemView.findViewById(R.id.item_tiezi_content);
            pariseView=itemView.findViewById(R.id.item_tiezi_parise);
            commontView= itemView.findViewById(R.id.item_tiezi_commont);
            topicView=itemView.findViewById(R.id.item_tiezi_topic);
        }
    }



    public TieziAdapter(List<Tiezi> tiezeList ){
           this.tieziList=tiezeList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            View     theView1 = LayoutInflater.from(getContext()).inflate(R.layout.item_tiezi, parent, false);
            ViewHolder holder = new ViewHolder(theView1);
            return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TieziAdapter.ViewHolder holder, int position) {

        Context context=getContext();
       Tiezi tiezi=tieziList.get(position);
            holder.headImageView.setImageResource(tiezi.getHeadImageId());
            holder.nameView.setText(tiezi.getName());
        holder.titleView.setText(tiezi.getTitle());
        if (tiezi.getImage1() != 0) {
            holder.imageView1.setImageResource(tiezi.getImage1());
            Glide.with(context).load(tiezi.getImage1()).into(holder.imageView1);
        }
        if (tiezi.getImage2()!=0)
        {
            holder.imageView2.setVisibility(View.VISIBLE);
            Glide.with(context).load(tiezi.getImage2()).into(holder.imageView2);
        }
        if (tiezi.getImage3()!=0)
        {
            holder.imageView3.setVisibility(View.VISIBLE);
            Glide.with(context).load(tiezi.getImage3()).into(holder.imageView3);
        }
        holder.contentView.setText(tiezi.getContent());
        holder.pariseView.setText(String.valueOf(tiezi.getPraise()));
        holder.commontView.setText(String.valueOf(tiezi.getComment()));
        holder.topicView.setText(tiezi.getTopic());




    }

    @Override
    public int getItemCount() {

        return tieziList.size();}




    //region 分列

    //endregion
}
