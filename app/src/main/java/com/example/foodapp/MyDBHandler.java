package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final  String TAG = "MyDBHandler";

    public static  final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME= "foodie.db";

    //Variables for User table
    public static  final String USER= "User";
    public static  final String COLUMN_USERID ="UserID";
    public static  final String COLUMN_USERNAME="UserName";
    public static  final String COLUMN_PASSWORD="Password";

    //Variables for FoodCourt table
    public static  final String FOODCOURT="FoodCourt";
    public static  final String COLUMN_COURTID="CourtID";
    public static  final String COLUMN_COURTNAME="CourtName";
    public static  final String COLUMN_COURTPICTURE="CourtPicture";

    //Variables for FoodStall table
    public static  final String FOODSTALL="FoodStall";
    public static  final String COLUMN_STALLID="StallID";
    public static  final String COLUMN_STALLNAME="StallName";
    public static  final String COLUMN_STALLDESCRIPTION="StallDescription";
    public static  final String COLUMN_STALLSCORE="StallScore";
    public static  final String COLUMN_STALLPICTURE="StallPicture";

    //Variables for Review table
    public static  final String REVIEW="Review";
    public static  final String COLUMN_REVIEWID="ReviewID";
    public static  final String COLUMN_REVIEWSCORE="ReviewScore";
    public static  final String COLUMN_REVIEWDESCRIPTION="ReviewDescription";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //create user table
        String CREATE_USER_TABLE= "create table " + USER +"(" + COLUMN_USERID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME +"TEXT," + COLUMN_PASSWORD +"TEXT" +")";
        db.execSQL(CREATE_USER_TABLE);
        //create food court table
        String CREATE_FOODCOURT_TABLE = "create table " + FOODCOURT +"(" + COLUMN_COURTID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COURTNAME +"TEXT," + COLUMN_COURTPICTURE +"LARGEBLOB" +")";
        db.execSQL(CREATE_FOODCOURT_TABLE);
        //create food stall table
        String CREATE_FOODSTALL_TABLE = "create table " + FOODSTALL +"(" + COLUMN_STALLID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_STALLNAME +"TEXT," + COLUMN_STALLPICTURE +"LARGEBLOB," + COLUMN_STALLSCORE + "FLOAT," + COLUMN_STALLDESCRIPTION + "TEXT" + ")";
        db.execSQL(CREATE_FOODSTALL_TABLE);
        //create review table
        String CREATE_REVIEW_TABLE = "create table " + REVIEW +"(" + COLUMN_REVIEWID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_REVIEWDESCRIPTION +"TEXT," + COLUMN_REVIEWSCORE +"FLOAT" +")";
        db.execSQL(CREATE_REVIEW_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + USER);

        onCreate(db);
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
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        UserData queryData= new UserData();
        if (cursor.moveToFirst()){
            queryData.setMyUserName(cursor.getString(0));
            queryData.setMyPassword(cursor.getString(1));
            cursor.close();
        }

        else{
            queryData=null;
        }
        db.close();
        return  queryData;
    }


    public boolean deleteAccount(String username)
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
    }




}

