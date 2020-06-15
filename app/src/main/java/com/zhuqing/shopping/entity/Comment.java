package com.zhuqing.shopping.entity;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Text;

import java.net.URL;

public class Comment {

    public   User user;

    public String image;
    public String name;
    public String content;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

