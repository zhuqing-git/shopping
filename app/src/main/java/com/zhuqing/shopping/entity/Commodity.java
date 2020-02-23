package com.zhuqing.shopping.entity;

import android.provider.ContactsContract;

import java.util.Date;
import java.util.List;

public class Commodity {
    private String content;
    private int money,praise,message,collection,userID;

    private Date date;
    private List<Integer>imageList;

    public Commodity(int userID,String content,int money,int praise,int message,int collection,List<Integer>imageList,Date data) {
        this.userID=userID;
        this.content=content;
        this.money=money;
        this.praise=praise;
        this.message=message;
        this.collection=collection;
        this.imageList=imageList;
        this.date=date;
    }

    public  int getOneImage(int a)
    {
        return imageList.get(a);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public List<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(List<Integer> imageList) {
        this.imageList = imageList;
    }
}
