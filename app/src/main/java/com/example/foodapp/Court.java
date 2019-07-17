package com.example.foodapp;

public class Court {
    private int cimage;
    private String cname;

    public void setCimage(int image){
        cimage = image;
    }

    public int getCimage(){
        return cimage;
    }

    public void setCname(String name){
        cname = name;
    }

    public String getCname(){
        return cname;
    }

    public Court(int image , String name){
        cimage = image;
        cname = name ;
    }
}
