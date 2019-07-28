package com.np.foodapp;

public class Stalls {
    //set private properties
    private int stallID;
    private int courtID;
    private String stallName;
    private String stallDes;
    private double stallScore;
    //private int stallPicture;

    //Constructor
    public Stalls(int sid, int cid, String n, String d, double s  ){
        stallID = sid;
        courtID = cid;
        stallName = n;
        stallDes = d;
        stallScore = s;

    }
    public Stalls(){

    }
    //set public properties
    public void setStallID(int id){ stallID = id; }
    public int getStallID(){ return stallID; }

    public void setCourtID(int id){ courtID = id; }
    public int getCourtID(){ return courtID; }

    public void setStallName(String name){ stallName = name; }
    public String getStallName(){ return stallName; }

    public void setStallDes(String Des){ stallDes = Des; }
    public String getStallDes(){ return stallDes; }

    public void setStallScore(double score){ stallScore = score; }
    public double getStallScore(){ return stallScore; }

}
