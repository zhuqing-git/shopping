package com.zhuqing.shopping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Msg;


import java.util.List;


public  class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InfoViewHolder>{

        private List<Msg> msgList;
        static class InfoViewHolder extends RecyclerView.ViewHolder {
            LinearLayout leftLayout,rightLayout;
            TextView leftMsg,rightMsg;

            public InfoViewHolder(@NonNull View itemView) {
                super(itemView);
                leftLayout=itemView.findViewById(R.id.item_information_left_layout);
                rightLayout=itemView.findViewById(R.id.item_information_right_layout);
                leftMsg=itemView.findViewById(R.id.item_information_left_msg);
                rightMsg=itemView.findViewById(R.id.item_information_right_msg);
            }
        }


        public InformationAdapter(List<Msg> mL){
            this.msgList=mL;

        }

        @NonNull
        @Override
        public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_information,parent,false);
         InfoViewHolder infoViewHolder=new InfoViewHolder(view);
            return infoViewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {

        Msg msg=msgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED)
        {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }
        else if(msg.getType()==Msg.TYPE_SENT)
        {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }

    }




        @Override
        public int getItemCount() {
            return msgList.size();
        }
    }

