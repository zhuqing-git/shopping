package com.zhuqing.shopping.entity;

import java.io.Serializable;
import java.util.List;


/**
 * 帖子的实例
 *
 * String title             标题
 * String content           内容
 * int[] imageArray         图片数组
 * int userId               用户Id
 *
 * int firePoint            热度值
 * int tieZiId              帖子ID
 * int praise               点赞数
 * int comment              评论数
 * int rank                 级别
 * int imageArrayNumber     图片数组计数器
 */

public class Tiezi implements Serializable {
    private int[] imageArray=new int[9];

    public int getImageArrayNumber() {
        return imageArrayNumber;
    }

    public void setImageArrayNumber(int imageArrayNumber) {
        this.imageArrayNumber = imageArrayNumber;
    }

    private int imageArrayNumber;
    private String title;
    private String content;
  //  private String topic;
    private int praise;
    private int comment;
    private  int firePoint;
    private  int tieZiId;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private  int userId;

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getTieZiId() {
        return tieZiId;
    }

    public void setTieZiId(int tieZiId) {
        this.tieZiId = tieZiId;
    }

    public int getFirePoint() {
        return firePoint;
    }

    public void setFirePoint(int firePoint) {
        this.firePoint = firePoint;
    }

//    public int getImage1() {
//        return image1;
//    }
//
//    public void setImage1(int image1) {
//        this.image1 = image1;
//    }
//
//    public int getImage2() {
//        return image2;
//    }
//
//    public void setImage2(int image2) {
//        this.image2 = image2;
//    }
//
//    public int getImage3() {
//        return image3;
//    }
//
//    public void setImage3(int image3) {
//        this.image3 = image3;
//    }

    public int[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(int[] imageArray) {
        this.imageArray = imageArray;
    }

    public Tiezi(int userId, String title, String content, int[] imageArray,int imageArrayNumber) {
       // this.name=name;
      //  this.headImageId=headImageId;
        this.title=title;
        this.content=content;
        this.userId=userId;
       // this.topic=topic;
       // this.praise=praise;
      //  this.comment=comment;
       this.imageArray=imageArray;
       this.imageArrayNumber=imageArrayNumber;

    }




//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public int getHeadImageId() {
//        return headImageId;
//    }
//
//    public void setHeadImageId(int headImageId) {
//        this.headImageId = headImageId;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getTopic() {
//        return topic;
//    }
//
//    public void setTopic(String topic) {
//        this.topic = topic;
//    }
//
//    public int getPraise() {
//        return praise;
//    }
//
//    public void setPraise(int praise) {
//        this.praise = praise;
//    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
