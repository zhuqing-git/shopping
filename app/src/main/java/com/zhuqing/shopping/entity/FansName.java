package com.zhuqing.shopping.entity;

public class FansName {
    private String name;
    private int headId;
    private String signature;

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public FansName(String name, int headId,String signature)
    {
        this.name=name;
        this.headId=headId;
        this.signature=signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
