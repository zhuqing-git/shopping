package com.zhuqing.shopping.db;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;


public class User extends LitePalSupport {




    private int userId;
    private String name;
    private String password;

    private int phone;
    private int age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
