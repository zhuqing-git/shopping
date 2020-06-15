package com.zhuqing.shopping.entity;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Commodity extends LitePalSupport implements Serializable {

    private String content;
    private int money,praise,message,collection;
    @SerializedName("topic")
    private String topic;
    @SerializedName("images")
    private String images;
    private SimpleDateFormat date;

    private List<String>imageList;
    @SerializedName("userId")
    private int userID;
    @SerializedName("cId")
    private int commodyId;

    @SerializedName("state")
    private int state;

    @SerializedName("evaluate")
    private int evaluate;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getCommodyId() {
        return commodyId;
    }

    public void setCommodyId(int commodyId) {
        this.commodyId = commodyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
