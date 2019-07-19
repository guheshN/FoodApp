package com.example.foodapp;

public class Review {
    private int reviewID;
    private int stallID;
    private int userID;
    private String stallReview;
    private String stallScore;

    public void setReviewID(int rID){reviewID = rID;}
    public int getReviewID(){return reviewID;}

    public void setStallID(int sID){stallID = sID;}
    public int getStallID(){return stallID;}

    public void setUserID(int uID){userID = uID;}
    public int getUserID(){ return userID; }

    public void setStallReview(String review){
        stallReview =review;
    }
    public String getStallReview(){
        return stallReview;
    }

    public void setStallScore(String score){
        stallScore = score;
    }
    public String getStallScore(){
        return stallScore;
    }


    public Review(int rid, int sid, int uid, String r, String s){
        reviewID = rid;
        stallID = sid;
        userID = uid;
        stallReview = r;
        stallScore = s;
    }
}
