package com.zhuqing.shopping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Commodity;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    private List<Commodity> mCommodityList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView commodityImage;
        TextView commodityName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commodityName=itemView.findViewById(R.id.commodity_name);
            commodityImage=itemView.findViewById(R.id.commodity_image);
        }
    }

    public CommodityAdapter(List<Commodity>commodityList)
    {
        mCommodityList=commodityList;
    }


    @NonNull
    @Override
    public CommodityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityAdapter.ViewHolder holder, int position) {
        Commodity commodity=mCommodityList.get(position);
        holder.commodityImage.setImageResource(commodity.getImageid());
        holder.commodityName.setText(commodity.getTitle());

    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }
}
