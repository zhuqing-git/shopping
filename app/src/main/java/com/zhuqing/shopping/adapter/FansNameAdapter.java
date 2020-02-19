package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.FansName;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public  class FansNameAdapter extends RecyclerView.Adapter<FansNameAdapter.ViewHolder>{
    private Context context;
    private List<FansName> mfansName;
    private int flag;
    View finalview;

    public FansNameAdapter(List<FansName> mfansName,Context context,int flag)
    {
        this.mfansName=mfansName;
        this.context=context;
        this.flag=flag;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView fansName,fansSignature;
        CircleImageView fansHeadId;
        ImageButton imageButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fansName=(TextView)itemView.findViewById(R.id.fans_textView);
            fansHeadId=(CircleImageView)itemView.findViewById(R.id.fans_headId);
            fansSignature=(TextView)itemView.findViewById(R.id.fans_signature);
            imageButton=(ImageButton)itemView.findViewById(R.id.item_fans_flag);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fans,parent,false);
        finalview=view;
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FansName fans=mfansName.get(position);
        holder.fansName.setText(fans.getName());
       if(!fans.getSignature().equals(""))
       {
           holder.fansSignature.setText(fans.getSignature());
       }
       if (flag==0)
       {
           holder.imageButton.setImageDrawable(finalview.getResources().getDrawable(R.drawable.a1));
       }
       if(flag==1)
       {
           holder.imageButton.setImageDrawable(finalview.getResources().getDrawable(R.drawable.d1));
       }
        // holder.fansHeadId.setImageResource(fans.getHeadId());
        Glide.with(context).load(fans.getHeadId()).into(holder.fansHeadId);



    }

    @Override
    public int getItemCount() {
        return mfansName.size();
    }





}
