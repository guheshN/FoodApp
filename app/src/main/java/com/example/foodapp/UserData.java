package com.example.foodapp;


public class UserData {
    private int UserID;
    private String MyUserName;
    private String MyPassword;


    public UserData(){

    }

    public UserData(int uid,String myUserName,String myPassword){
        UserID = uid;
        MyUserName=myUserName;
        MyPassword=myPassword;
    }
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getMyUserName() {
        return MyUserName;
    }

    public void setMyUserName(String myUserName) {
        MyUserName = myUserName;
    }

    public String getMyPassword() {
        return MyPassword;
    }

    public void setMyPassword(String myPassword) {
        MyPassword = myPassword;
    }
}
