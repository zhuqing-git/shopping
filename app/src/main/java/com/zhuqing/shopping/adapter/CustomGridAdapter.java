package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.core.content.FileProvider;

import com.luck.picture.lib.entity.LocalMedia;
import com.zhuqing.shopping.R;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.Inflater;

public class CustomGridAdapter extends BaseAdapter {
    private List<String>selectList;
   // private LayoutInflater layoutInflater;


    public CustomGridAdapter(Context context,List<String> selectList)
    {
        this.selectList=selectList;
       // layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return selectList.size();
    }

    @Override
    public Object getItem(int position) {
        return selectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null)
        {
            //LocalMedia localMedia=selectList.get(position);
//            BitmapFactory.Options options=new BitmapFactory.Options();
//            Bitmap bm=BitmapFactory.decodeFile(localMedia.getPath(),options);
            Bitmap bm= null;
           // Log.d("test",localMedia.getPath());
            try {

                    bm = BitmapFactory.decodeStream(parent.getContext().getContentResolver().openInputStream(Uri.parse(selectList.get(position))));
                    convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_public,parent,false);
                    holder=new ViewHolder(convertView);
                    Log.d("test", String.valueOf(bm));
                    holder.imageView.setImageBitmap(bm);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
          //  Log.d("test",localMedia.getPath());

        }
        return convertView;
    }

   static class ViewHolder {
        ImageView imageView;

        public ViewHolder(View view){
            imageView=view.findViewById(R.id.public_item_image);
        }

    }

















}
