package com.zhuqing.shopping.entity;

public class FansName {
    private String name;
    private int headId;

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public FansName(String name, int headId)
    {
        this.name=name;
        this.headId=headId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
