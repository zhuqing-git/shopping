package com.zhuqing.shopping.entity;

public class Tiezi {
    private String name;
    private int headImageId,image1=0,image2=0,image3=0;
    private String title;
    private String content;
    private String topic;
    private int praise;
    private int comment;


    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public Tiezi(String name, int  headImageId, String title, String content, String topic, int praise, int comment, int image1, int image2, int image3) {
        this.name=name;
        this.headImageId=headImageId;
        this.title=title;
        this.content=content;
        this.topic=topic;
        this.praise=praise;
        this.comment=comment;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadImageId() {
        return headImageId;
    }

    public void setHeadImageId(int headImageId) {
        this.headImageId = headImageId;
    }

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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
