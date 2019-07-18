package com.example.foodapp;

public class Court {
    //set private properties
    private int cimage;
    private String cname;

    //set public properties
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

    //constructors
    public Court(int image , String name){
        cimage = image;
        cname = name ;
    }
}
