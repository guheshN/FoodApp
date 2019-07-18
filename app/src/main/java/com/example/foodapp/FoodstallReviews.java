package com.example.foodapp;

public class FoodstallReviews {

    private String cStallName;
    private String cStallReview;
    private String cStallScore;



    public void setcStallName(String stallName){
        cStallName =stallName;
    }

    public String getcStallName(){
        return cStallName;
    }

    public void setcStallReview(String stallReview){
        cStallReview =stallReview;
    }

    public String getcStallReview(){
        return cStallReview;
    }

    public void setcStallScore(String stallScore){
        cStallScore =stallScore;
    }

    public String getcStallScore(){
        return cStallScore;
    }


    public FoodstallReviews(String stallName , String stallReview, String stallScore){
        cStallName = stallName;
        cStallReview = stallReview;
        cStallScore = stallScore ;
    }
}
