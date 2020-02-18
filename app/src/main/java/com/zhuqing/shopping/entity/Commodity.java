package com.zhuqing.shopping.entity;

public class Commodity {
    private String title;
    private int imageid;

    public Commodity(String title, int imageid) {
        this.title = title;
        this.imageid = imageid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
