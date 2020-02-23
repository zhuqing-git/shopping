package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.MsgActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    Context context;
    private List<Commodity> mCommodityList;
  private int number;
 private ViewHolder ffff;




   static   class ViewHolder extends RecyclerView.ViewHolder {
        //View ffff;

        TextView content,money,praise,message,collection;
        Button edit,cancel;

        TextView commodityName;
        ImageView commodityImage;


        public ViewHolder(@NonNull View itemView ,int number) {
            super(itemView);
           // ffff=itemView;
            if(number==0)
            {
                commodityName = itemView.findViewById(R.id.commodity_name);
                commodityImage = itemView.findViewById(R.id.commodity_image);
            }else if(number==1)
            {
                commodityName = itemView.findViewById(R.id.item_topic_right_textview);
                commodityImage = itemView.findViewById(R.id.item_topic_right_imageview);
            }else if(number==3)
            {
                content=itemView.findViewById(R.id.item_commodity_view_content);
                commodityImage=itemView.findViewById(R.id.item_commodity_view_image);
                money=itemView.findViewById(R.id.item_commodity_view_money);
                praise=itemView.findViewById(R.id.item_commodity_view_praise);
                message =itemView.findViewById(R.id.item_commodity_view_message);
                collection =itemView.findViewById(R.id.item_commodity_view_collection);
                edit =itemView.findViewById(R.id.item_commodity_view_editbutton);
                cancel =itemView.findViewById(R.id.item_commodity_view_cancel);
               // LinearLayout linearLayout=(LinearLayout)itemView.findViewById(R.id.item_commodity_view_linearlayout);

            }

        }
    }

    public CommodityAdapter(List<Commodity> commodityList,int number){
        mCommodityList=commodityList;
        this.number=number;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view;
        ViewHolder viewHolder = null;

        if(number==0)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_linear, parent, false);
           viewHolder = new ViewHolder(view,number);

        }else if (number==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_right, parent, false);
                viewHolder= new ViewHolder(view,number);

        }
        else if(number==3)
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_view, parent, false);
                viewHolder=new ViewHolder(view,number);
        }
        this.context=parent.getContext();

        return viewHolder;



    }

    @Override
    public void onBindViewHolder(@NonNull final CommodityAdapter.ViewHolder holder, int position) {

        Commodity commodity = mCommodityList.get(position);
        if (number==1||number==0)
        {
            holder.commodityImage.setImageResource(commodity.getOneImage(0));
            holder.commodityName.setText(commodity.getContent());
        }
        else if(number==3){
            holder.content.setText(commodity.getContent());
            holder.money.setText(String.valueOf(commodity.getMoney()));
            holder.praise.setText(String.valueOf(commodity.getPraise()));
            holder.message.setText(String.valueOf(commodity.getMessage()));
            holder.collection.setText(String.valueOf(commodity.getCollection()));
            Glide.with(context).load(commodity.getOneImage(0)).into(holder.commodityImage);
           // holder.commodityImage.setImageResource(commodity.getOneImage(0));
//            holder.commodityView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(),"hello",Toast.LENGTH_SHORT).show();
//                }
//            });
        }

    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }



}
