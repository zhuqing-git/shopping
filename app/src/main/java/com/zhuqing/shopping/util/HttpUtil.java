package com.zhuqing.shopping.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
    public static String addressOfPicture = "http://192.168.43.17:8080/static/images/";
    public static String addressOfGetCommody = "http://192.168.43.17:8080/get_commody/";


    public static void SendOkHttpRequest(String address, Request request, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(callback);

    }


    public static class GetUtil {


        //获取commody
        public static void GetCommody(List<Commodity>commodityList, int state) throws IOException {

            commodityList.clear();
            String address = addressOfGetCommody + ValueUtility.getUserId() + "/5/" + state;


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
    }


        public static class PublicUtil {
            //发布commody
            public static boolean PublicOneCommody(String content, String topic, String money, List<String> imagePaths, Context context) {

                String userId = String.valueOf(ValueUtility.getUserId());

                String address = Config.addressOfPublicCommody;
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
                        Toast.makeText(context, "发布失败", Toast.LENGTH_SHORT).show();
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

