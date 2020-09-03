package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.Comment;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/***
评论适配器
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    List<Comment> commentList;
    Context context;


    static class ViewHolder extends RecyclerView.ViewHolder {
       // CircleImageView imageView;
        TextView person,comment;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView=itemView.findViewById(R.id.comment_image);
            person=itemView.findViewById(R.id.comment_person);
            comment=itemView.findViewById(R.id.comment_comment);
        }
    }


    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment=commentList.get(position);

        holder.comment.setText(comment.getContent());
        holder.person.setText(comment.getUser().getName());
    }



    @Override
    public int getItemCount() {
        return commentList.size();
    }


}
