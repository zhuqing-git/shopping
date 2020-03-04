package com.zhuqing.shopping.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.luck.picture.lib.entity.LocalMedia;
import com.zhuqing.shopping.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.zip.Inflater;

public class CustomGridAdapter extends BaseAdapter {
    private List<String>imagePaths;
   // private LayoutInflater layoutInflater;


    public CustomGridAdapter(Context context,List<String> imagePaths)
    {
        this.imagePaths=imagePaths;
       // layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imagePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return imagePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null)
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_public,parent,false);
        holder=new ViewHolder(convertView);

           if (Build.VERSION.SDK_INT<=Build.VERSION_CODES.P)
           {
               FileInputStream fileInputStream= null;
               try {
                   fileInputStream = new FileInputStream(imagePaths.get(position));
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
               holder.imageView.setImageBitmap(BitmapFactory.decodeStream(fileInputStream));
               try {
                   fileInputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }else {
               holder.imageView.setImageURI(Uri.parse(imagePaths.get(position)));


//               String uri=imagePaths.get(position);
//               Bitmap bm= null;
//               try {
//                   bm = MediaStore.Images.Media.getBitmap(parent.getContext().getContentResolver(), Uri.parse(uri));
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//               try {
//                   bm = BitmapFactory.decodeStream(parent.getContext().getContentResolver().openInputStream(Uri.parse(imagePaths.get(position))));
//               } catch (FileNotFoundException e) {
//                   e.printStackTrace();
//               }
//
//
//               holder.imageView.setImageBitmap(bm);
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
