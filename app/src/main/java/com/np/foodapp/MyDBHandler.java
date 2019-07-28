package com.np.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final  String TAG = "MyDBHandler";

    public static  final int DATABASE_VERSION=2;

    private static final String DATABASE_NAME= "foodie.db";

    //Variables for User table
    public static  final String USER= "User";
    public static  final String COLUMN_USER_ID ="UserID";
    public static  final String COLUMN_USERNAME="UserName";
    public static  final String COLUMN_PASSWORD="Password";

    //Variables for FoodCourt table
    public static  final String FOODCOURT="FoodCourt";
    public static  final String COLUMN_COURT_ID="CourtID";
    public static  final String COLUMN_COURT_NAME="CourtName";
    public static  final String COLUMN_COURT_PICTURE="CourtPicture";

    //Variables for FoodStall table
    public static  final String FOODSTALL="FoodStall";
    public static  final String COLUMN_STALL_ID="StallID";
    public static  final String COLUMN_STALL_NAME="StallName";
    public static  final String COLUMN_STALL_DESCRIPTION="StallDescription";
    public static  final String COLUMN_STALL_SCORE="StallScore";
    public static  final String COLUMN_STALL_PICTURE="StallPicture";

    //Variables for Review table
    public static  final String REVIEW="Review";
    public static  final String COLUMN_REVIEW_ID="ReviewID";
    public static  final String COLUMN_REVIEW_SCORE="ReviewScore";
    public static  final String COLUMN_REVIEW_DESCRIPTION="ReviewDescription";
    public static final  String COLUMN_REVIEW_LIKE = "ReviewLike";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //create user table
        String CREATE_USER_TABLE= "create table " + USER +"(" + COLUMN_USER_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME +"\t TEXT," + COLUMN_PASSWORD +"\t TEXT" +")";
        db.execSQL(CREATE_USER_TABLE);
        //create food court table
        String CREATE_FOODCOURT_TABLE = "create table " + FOODCOURT +"(" + COLUMN_COURT_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COURT_NAME +"\t TEXT," + COLUMN_COURT_PICTURE +"\t INT" +")";
        db.execSQL(CREATE_FOODCOURT_TABLE);
        //create food stall table
        String CREATE_FOODSTALL_TABLE = "create table " + FOODSTALL +"(" + COLUMN_STALL_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COURT_ID + "\t INTEGER," + COLUMN_STALL_NAME +"\t TEXT," + COLUMN_STALL_PICTURE +"\t INTEGER," + COLUMN_STALL_DESCRIPTION + "\t TEXT" + ")";
        db.execSQL(CREATE_FOODSTALL_TABLE);
        //create review table
        String CREATE_REVIEW_TABLE = "create table " + REVIEW +"(" + COLUMN_REVIEW_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_STALL_ID + "\t INTEGER," +COLUMN_USER_ID + "\t INTEGER," + COLUMN_REVIEW_DESCRIPTION +"\t TEXT," + COLUMN_REVIEW_SCORE +"\t FLOAT," + COLUMN_REVIEW_LIKE + "\t INTEGER" + ")";
        db.execSQL(CREATE_REVIEW_TABLE);

        /*insertCourt("Poolside",R.drawable.poolside);
        insertCourt("FoodClub",R.drawable.fc);
        insertCourt("MakanPlace",R.drawable.makanplace);
        insertCourt("Munch",R.drawable.munch);

        insertStall(0,"Fried Chicken Master","Crispy Tender Chicken and more",0);
        insertStall(0,"Malay Store","Nasi Lemak, Mee Soto And more",0);
        insertStall(0,"Waffles and Ice Cream","Crunchy and Fresh Waffles available",0);
        insertStall(0,"Canopy Coffee Club","Drinks and BreakFast provided",0);
        insertStall(0,"Henry's Western Stall","Great Western Food here at Henry's" ,0);
        insertStall(0,"MiniWok","All Your Favourite Stir-Fried Dishes Available",0);*/


        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")" + "\tVALUES" + "(" + "\"" + "PoolSide" + "\""+ "," + R.drawable.poolside + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")" + "\tVALUES" + "(" + "\"" + "FoodCLub" + "\""+ "," + R.drawable.fc + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")" + "\tVALUES" + "(" + "\"" + "MAkanPlace" + "\""+ "," + R.drawable.makanplace + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")" + "\tVALUES" + "(" + "\"" + "Munch" + "\""+ "," + R.drawable.munch + ")");


        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" + "FriedMasterChicken" + "\"" + "," + 0 + "," + "\"" + "Chickies" + "\"" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" + "MalayStall"+ "\"" + "," + 0 + "," + "\"" + "NasiLemak" + "\"" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" +"Waffles" + "\""+ "," + 0 + "," + "\"" + "IceCream" + "\"" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" +"CanopyCoffeeClub" + "\"" + "," + 0 + "," + "\"" + "Drinks" + "\"" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" +"HenryWestern" + "\"" + "," + 0 + "," + "\"" +"GoodFoodie" + "\"" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" +COLUMN_COURT_ID + "," + COLUMN_STALL_NAME + "," + COLUMN_STALL_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + 0 + "," + "\"" +"MiniWok" + "\"" +"," + 0 + "," + "\"" + "OilyGood" + "\"" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + USER);

        onCreate(db);
    }

    public boolean insertCourt(String CourtName,int picture)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURT_NAME,CourtName);
        contentValues.put(COLUMN_COURT_PICTURE,picture);
        long result = db.insert(FOODCOURT,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;


    }

    public boolean insertStall(int CourtID,String StallName,String StallDesc,int picture)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURT_ID,CourtID);
        contentValues.put(COLUMN_STALL_NAME,StallName);
        contentValues.put(COLUMN_STALL_DESCRIPTION,StallDesc);
        contentValues.put(COLUMN_COURT_PICTURE,picture);
        long result = db.insert(FOODSTALL,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;


    }

    public void addUser(UserData userData){
        ContentValues values= new ContentValues();
        values.put(COLUMN_USERNAME,userData.getMyUserName());
        values.put(COLUMN_PASSWORD,userData.getMyPassword());
        SQLiteDatabase db= this.getWritableDatabase();
        Log.v(TAG,values.toString());
        db.insert(USER,null,values);
        db.close();
    }


    public UserData findUser(String username)
    {
        String query= "SELECT * FROM "+ USER+ " WHERE "+COLUMN_USERNAME + "= \""+ username +"\"";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        UserData queryData= new UserData();
        if (cursor.moveToNext()){
            queryData.setUserID(cursor.getInt(0));
            queryData.setMyUserName(cursor.getString(1));
            queryData.setMyPassword(cursor.getString(2));
            cursor.close();
        }

        else{
            queryData = null;
        }
        db.close();
        return  queryData;
    }

    public void editUser (String username,String password)
    {
        String usernamequery= "UPDATE "+ USER+ " SET "+COLUMN_USERNAME + "= \""+ username +"\"";
        String passwordquery= "UPDATE "+ USER+ " SET "+COLUMN_PASSWORD + "= \""+ password +"\"";
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL(usernamequery);
        db.execSQL(passwordquery);



    }


    public ArrayList<Court> getCourt()
    {
        String query= "SELECT * FROM " + FOODCOURT ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        ArrayList<Court> courtdata = new ArrayList<>();
        while (cursor.moveToNext()){
            Court querydata = new Court();
            querydata.setCname(cursor.getString(1));
            querydata.setCimage(cursor.getInt(2));
            courtdata.add(querydata);
        }
        cursor.close();

        db.close();
        return  courtdata;
    }

    public ArrayList<Stalls> getStall(int courtid)
    {
        String query= "SELECT * FROM " + FOODSTALL + " WHERE " + COLUMN_COURT_ID + " = \"" + courtid + "\"";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        ArrayList<Stalls> stalldata = new ArrayList<>();
        while (cursor.moveToNext()){
            Stalls querydata = new Stalls();
            querydata.setStallID(cursor.getInt(0));
            querydata.setCourtID(cursor.getInt(1));
            querydata.setStallName(cursor.getString(2));
            querydata.setStallDes(cursor.getString(4));

            stalldata.add(querydata);
        }
        cursor.close();

        db.close();
        return  stalldata;
    }

    public Stalls getStallDetail(int stallid){
        String query= "SELECT * FROM " + FOODSTALL + " WHERE " + COLUMN_STALL_ID + " = \"" + stallid + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Stalls querydata = new Stalls();
        if(cursor.moveToFirst()){
            querydata.setStallID(cursor.getInt(0));
            querydata.setCourtID(cursor.getInt(1));
            querydata.setStallName(cursor.getString(2));
            querydata.setStallDes(cursor.getString(4));
        }
        else{
            querydata = null;
        }
        return querydata;
    }

    public void addReview(Review review){
        ContentValues values= new ContentValues();
        values.put(COLUMN_STALL_ID,review.getStallID());
        values.put(COLUMN_USER_ID,review.getUserID());
        values.put(COLUMN_REVIEW_DESCRIPTION,review.getStallReview());
        values.put(COLUMN_REVIEW_SCORE,review.getStallScore());
       // values.put(COLUMN_REVIEW_LIKE,review.getStallLikes());

        SQLiteDatabase db= this.getWritableDatabase();
        Log.v(TAG,values.toString());
        db.insert(REVIEW,null,values);
        db.close();
    }

    public ArrayList<Review> getReview(int stallid){
        String query= "SELECT * FROM " + REVIEW + " WHERE " + COLUMN_STALL_ID + " = \"" + stallid + "\"";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        ArrayList<Review> reviewdata = new ArrayList<>();
        while (cursor.moveToNext()){
            Review querydata = new Review();
            querydata.setReviewID(cursor.getInt(0));
            querydata.setStallID(cursor.getInt(1));
            querydata.setUserID(cursor.getInt(2));
            querydata.setStallReview(cursor.getString(3));
            querydata.setStallScore(cursor.getString(4));
            querydata.setLikes(cursor.getInt(5));

            reviewdata.add(querydata);
        }
        cursor.close();

        db.close();
        return  reviewdata;
    }





    /*public boolean deleteAccount(String username)
    {
        boolean result = false;
        String query = "SELECT * FROM "+USER+" WHERE "+COLUMN_USERNAME+"=\""+username+"\"";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query,null);

        UserData delData= new UserData();

        if(cursor.moveToFirst())
        {
            delData.setMyUserName(cursor.getString(0));
            db.delete(USER, COLUMN_USERNAME+"=?", new String[]{String.valueOf((delData.getMyUserName()))});
            cursor.close();
            result= true;
        }
        db.close();
        return result;
    }*/




}

