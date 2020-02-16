package com.zhuqing.shopping.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
import com.zhuqing.shopping.R;
import com.zhuqing.shopping.entity.FansName;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FansFragment extends Fragment {




    private List<FansName> fansName = new ArrayList<>();


    //region 初始化recycleView
    private void initFruits() {
        for (int i = 0; i < 20; i++) {

            fansName.add(new FansName("张三",R.drawable.d1));
            fansName.add(new FansName("李四",R.drawable.d1));

        }
    }



    //endregion
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        initFruits();
        RecyclerView recyclerView = view.findViewById(R.id.page2_recyclerView);
       LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
FansNameAdapter adapter=new FansNameAdapter(fansName,getContext());
        recyclerView.setAdapter(adapter);



        return view;
    }


    private class Myloader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {


            Glide.with(context).load(path).into(imageView);

        }
    }



     public static class FansNameAdapter extends RecyclerView.Adapter<FansNameAdapter.ViewHolder>{
        private Context context;
        private List<FansName> mfansName;

        public FansNameAdapter(List<FansName> mfansName,Context context)
        {
            this.mfansName=mfansName;
            this.context=context;
        }


         static class ViewHolder extends RecyclerView.ViewHolder{
             TextView fansName;
             CircleImageView fansHeadId;


             public ViewHolder(@NonNull View itemView) {
                 super(itemView);
                 fansName=(TextView)itemView.findViewById(R.id.fans_textView);
                 fansHeadId=(CircleImageView)itemView.findViewById(R.id.fans_headId);
             }
         }

         @NonNull
         @Override
         public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fans,parent,false);
             ViewHolder holder=new ViewHolder(view);
             return holder;
         }

         @Override
         public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            FansName fans=mfansName.get(position);
            holder.fansName.setText(fans.getName());
           // holder.fansHeadId.setImageResource(fans.getHeadId());
            Glide.with(context).load(fans.getHeadId()).into(holder.fansHeadId);



         }

         @Override
         public int getItemCount() {
             return mfansName.size();
         }





     }
}






















