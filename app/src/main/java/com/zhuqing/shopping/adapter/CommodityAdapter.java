package com.zhuqing.shopping.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.MsgActivity;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    private List<Commodity> mCommodityList;
  private int number=0;
    ViewHolder viewHolder;
//    private int type;

     class ViewHolder extends RecyclerView.ViewHolder {
        View commodityView;
        ImageView commodityImage;
        TextView commodityName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commodityView=itemView;
            if(number==0)
            {
                commodityName = itemView.findViewById(R.id.commodity_name);
                commodityImage = itemView.findViewById(R.id.commodity_image);
            }else if(number==1)
            {
                commodityName = itemView.findViewById(R.id.item_topic_right_textview);
                commodityImage = itemView.findViewById(R.id.item_topic_right_imageview);
            }

        }
    }

    public CommodityAdapter(List<Commodity> commodityList,int a){
        mCommodityList=commodityList;
        this.number=a;
    }



    @NonNull
    @Override
    public CommodityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view;
        ViewHolder gridViewHolder;

        if(number==0)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity_linear, parent, false);
            viewHolder = new ViewHolder(view);

        }else if (number==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic_right, parent, false);
          viewHolder = new ViewHolder(view);

        }



        viewHolder.commodityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                Commodity commodity=mCommodityList.get(position);
               // Intent intent=new Intent(v.getContext(),MsgActivity.class);
               // v.getContext().startActivity(intent);
              //  Toast.makeText(v.getContext(),commodity.getTitle(),Toast.LENGTH_SHORT).show();

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityAdapter.ViewHolder holder, int position) {
        Commodity commodity = mCommodityList.get(position);
        holder.commodityImage.setImageResource(commodity.getImageid());
        holder.commodityName.setText(commodity.getTitle());

    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }



}
