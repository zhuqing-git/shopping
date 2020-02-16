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
    private int type;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View commodityView;
        ImageView commodityImage;
        TextView commodityName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commodityView=itemView;
            commodityName = itemView.findViewById(R.id.commodity_name);
            commodityImage = itemView.findViewById(R.id.commodity_image);
        }
    }

//    static class ViewHolder2 extends RecyclerView.ViewHolder {
//        View commodityView;
//        ImageView commodityImage;
//        TextView commodityName;
//
//        public ViewHolder2(@NonNull View itemView) {
//            super(itemView);
//            commodityView=itemView;
//            commodityName = itemView.findViewById(R.id.commodity_name);
//            commodityImage = itemView.findViewById(R.id.commodity_image);
//        }
//    }

    public CommodityAdapter(List<Commodity> commodityList) {
        mCommodityList = commodityList;
    }


    @NonNull
    @Override
    public CommodityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view;


        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity, parent, false);
            ViewHolder linearViewHolder = new ViewHolder(view);

        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_item_2, parent, false);
            ViewHolder gridViewHolder = new ViewHolder(view);

        }

       final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.commodityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                Commodity commodity=mCommodityList.get(position);
                Intent intent=new Intent(v.getContext(),MsgActivity.class);
                v.getContext().startActivity(intent);
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


    //region 分列
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }
    //endregion
}
