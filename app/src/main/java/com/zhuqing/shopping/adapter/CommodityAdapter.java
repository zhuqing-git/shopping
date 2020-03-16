package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


/**
 * commodityilst
 * number:commody样式
 * state:卖出，发布，买入
 */
public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    Context context;
    private List<Commodity> mCommodityList;
  private int number;
 private ViewHolder ffff;
 int state;




   static   class ViewHolder extends RecyclerView.ViewHolder {
        //View ffff;

        TextView content,money,praise,message,collection;
        Button edit,cancel;
        LinearLayout linearLayoutOf3;
        TextView commodityName;
        ImageView commodityImage;
        int number;


        public ViewHolder(@NonNull View itemView ,int number,int state) {
            super(itemView);
            this.number=number;
            if(number==0)
            {
               commodityName=itemView.findViewById(R.id.commodity_name_of_number0);
               commodityImage=itemView.findViewById(R.id.commodity_image_of_number0);
               money=itemView.findViewById(R.id.commodity_money_of_number0);
            } if(number==1)
            {
                commodityName = itemView.findViewById(R.id.item_topic_right_textview);
                commodityImage = itemView.findViewById(R.id.item_topic_right_imageview);
            } if(number==3)
            {

                content=itemView.findViewById(R.id.item_commodity_view_content);
                commodityImage=itemView.findViewById(R.id.item_commodity_view_image);
                money=itemView.findViewById(R.id.item_commodity_view_money);
                praise=itemView.findViewById(R.id.item_commodity_view_praise);
                message =itemView.findViewById(R.id.item_commodity_view_message);
                collection =itemView.findViewById(R.id.item_commodity_view_collection);
                edit =itemView.findViewById(R.id.item_commodity_view_editbutton);
                cancel =itemView.findViewById(R.id.item_commodity_view_cancel);
                linearLayoutOf3=itemView.findViewById(R.id.item_commodity_3_linearLayout);
             //  LinearLayout linearLayout=(LinearLayout)itemView.findViewById(R.id.item_commodity_view_linearlayout);
                if (state==1||state==2)
                {
                    edit.setVisibility(View.GONE);
                    cancel.setVisibility(View.GONE);
                    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(linearLayoutOf3.getLayoutParams());
                   params.setMargins(0,20,0,0);
                    linearLayoutOf3.setLayoutParams(params);
                }

            }

        }
    }

    public CommodityAdapter(List<Commodity> commodityList,int number,int state){
        mCommodityList=commodityList;
        this.number=number;
        this.state=state;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        this.context=parent.getContext();

        if(number==0)
        {
            View   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_linear, parent, false);

           return new ViewHolder(view,number,state);

        } if (number==1)
        {
            View   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_right, parent, false);
              return   new ViewHolder(view,number,state);

        }
        else if(number==3)
        {
            View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_view, parent, false);
              return new   ViewHolder(view,number,state);

        }
        return null;
   }

    @Override
    public void onBindViewHolder(@NonNull  CommodityAdapter.ViewHolder holder, int position) {

        Commodity commodity = mCommodityList.get(position);

        if (number==0)
       {

         holder.money.setText(String.valueOf(commodity.getMoney()));

            holder.commodityName.setText(commodity.getContent());
           Glide.with(context).load(commodity.getImageList().get(0)).into(holder.commodityImage);



        }
        if(number==3){


            holder.content.setText(commodity.getContent());
            holder.money.setText(String.valueOf(commodity.getMoney()));
            holder.praise.setText(String.valueOf(commodity.getPraise()));
            holder.message.setText(String.valueOf(commodity.getMessage()));
            holder.collection.setText(String.valueOf(commodity.getCollection()));
            Glide.with(context).load(commodity.getImageList().get(0)).into(holder.commodityImage);



            //Glide.with(context).load(commodity.getImageList().get(0)).into(holder.commodityImage);
//            holder.commodityImage.setImageResource(commodity.getOneImage(0));
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
