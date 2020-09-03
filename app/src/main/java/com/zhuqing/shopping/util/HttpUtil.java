package com.zhuqing.shopping.util;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhuqing.shopping.entity.Comment;
import com.zhuqing.shopping.entity.Commodity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpUtil {
    public static String prefix="http://192.168.43.17:8080/";
    public  static String addressOfLogin=prefix+"login/";
    public static String addressOfPicture = prefix+"static/images/";


    public static String addressOfGetCommody = prefix+"get_commody/";
    public static String addressOfGetSortCommody=prefix+"sort_commody/";
    private static String addressOfSellCommody=prefix+"sell_commody/";
    public  static String addressOfGetComment=prefix+"get_comment/";
    public static String addressOfSpecialCommody=prefix+"get_special_commody";


    public static String addressOfPublicCommody=prefix+"public_commodity";


    public static void SendOkHttpRequest(String address, Request request, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(callback);

    }


    public static class GetUtil {


        private static String responseText;

        //获取用户自己的commody
        public static void GetCommody(List<Commodity>commodityList,int number, int state) throws IOException {

            commodityList.clear();
            String address = addressOfGetCommody + ValueUtility.getUserId() + "/"+number+"/" + state;


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            String responseText = response.body().string();

            Gson gson = new Gson();
            List<Commodity> commodities = gson.fromJson(responseText, new TypeToken<List<Commodity>>() {
            }.getType());

            for (Commodity c : commodities) {
                List<String> ll = new ArrayList<>();
                String[] a = c.getImages().split("/");

                for (int i = 0; i < a.length - 1; i++) {
                    String uri = HttpUtil.addressOfPicture + c.getUserID() + "/" + a[0] + "_" + a[1 + i];
                    ll.add(uri);
                }
                c.setImageList(ll);
                commodityList.add(c);


            }



        }



        //获取显示的commody
        public static void GetCommodyShow(List<Commodity>commodityList,int number, int state) throws IOException {

            commodityList.clear();
            String address = addressOfGetCommody +number+"/" + state+"/";


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();


try{
     responseText = response.body().string();

}catch (Exception e)
{
    Log.d("test", "GetCommodyShow: -------------faile");
//Toast.makeText(,"link faile",Toast.LENGTH_SHORT).show();
}
          //  String responseText = response.body().string();

            Gson gson = new Gson();
            List<Commodity> commodities = gson.fromJson(responseText, new TypeToken<List<Commodity>>() {
            }.getType());

            for (Commodity c : commodities) {
                List<String> ll = new ArrayList<>();
                String[] a = c.getImages().split("/");

                for (int i = 0; i < a.length - 1; i++) {
                    String uri = HttpUtil.addressOfPicture + c.getUserID() + "/" + a[0] + "_" + a[1 + i];
                    ll.add(uri);
                }
                c.setImageList(ll);
                commodityList.add(c);


            }



        }

        //获取分类的commody---commodityList 列表  number数量  state商品状态  topic商品分类
        public static void GetSortCommody(List<Commodity>commodityList,int number,int state,int topic,int fun) throws IOException {

            commodityList.clear();
            String address = addressOfGetSortCommody +number+"/" + state+"/"+topic+"/"+fun;


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            String responseText = response.body().string();

            Gson gson = new Gson();
            List<Commodity> commodities = gson.fromJson(responseText, new TypeToken<List<Commodity>>() {
            }.getType());

            for (Commodity c : commodities) {
                List<String> ll = new ArrayList<>();
                String[] a = c.getImages().split("/");

                for (int i = 0; i < a.length - 1; i++) {
                    String uri = HttpUtil.addressOfPicture + c.getUserID() + "/" + a[0] + "_" + a[1 + i];
                    ll.add(uri);
                }
                c.setImageList(ll);
                commodityList.add(c);
            }



        }

        //获取comment
        public static void GetComment(List<Comment>commentList,int commodyId) throws IOException{

            commentList.clear();
            String address = addressOfGetComment +commodyId;


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            String responseText = response.body().string();

            Gson gson = new Gson();

            List<Comment> comments = gson.fromJson(responseText, new TypeToken<List<Comment>>() {
            }.getType());

            for (Comment c : comments) {
                commentList.add(c);
            }




        }

        //得到轮播台的Commody
        public static void GetSpecialCommody(List<Commodity> commodityList) throws IOException{
            commodityList.clear();
            String address =  HttpUtil.addressOfSpecialCommody;


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            String responseText = response.body().string();
            Gson gson = new Gson();
            List<Commodity> commodities = gson.fromJson(responseText, new TypeToken<List<Commodity>>() {
            }.getType());

            for (Commodity c : commodities) {
                List<String> ll = new ArrayList<>();
                String[] a = c.getImages().split("/");

                for (int i = 0; i < a.length - 1; i++) {
                    String uri = HttpUtil.addressOfPicture + c.getUserID() + "/" + a[0] + "_" + a[1 + i];
                    ll.add(uri);
                }
                c.setImageList(ll);
                commodityList.add(c);


            }







        }


        public static void SellCommody(int commodyId) throws IOException, JSONException {

            String address = addressOfSellCommody +commodyId+"/"+ ValueUtility.getUserId() ;


            Request request = new Request.Builder().url(address).build();


            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            String responseText = response.body().string();








        }
    }


        public static class PublicUtil {
            //发布commody
            public static boolean PublicOneCommody(String content, String topic, String money, List<String> imagePaths, Context context) {

                String userId = String.valueOf(ValueUtility.getUserId());

                String address = HttpUtil.addressOfPublicCommody;
                MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);

                Date current = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

                for (int i = 0; i < imagePaths.size(); i++) {
                    File file = new File(imagePaths.get(i));
                    RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
                    String fileName = file.getName();
                    requestBody.addFormDataPart("files", fileName, body);

                }
                requestBody.addFormDataPart("userId", userId).addFormDataPart("content", content).
                        addFormDataPart("topic", topic).addFormDataPart("money", money);
                Request request = new Request.Builder().url(address).post(requestBody.build()).build();
                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(context, "发布失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response.body().string());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            if (jsonObject.get("result").equals("true")) {
                                ValueUtility.commodyPublicChange = true;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
                return true;

            }


        }

}

