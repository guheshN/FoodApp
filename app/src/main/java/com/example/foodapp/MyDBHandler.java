package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final  String TAG = "MyDBHandler";

    public static  final int DATABASE_VERSION=1;

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
        String CREATE_FOODSTALL_TABLE = "create table " + FOODSTALL +"(" + COLUMN_STALL_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_STALL_NAME +"\t TEXT," + COLUMN_STALL_PICTURE +"\t INT," + COLUMN_STALL_DESCRIPTION + "\t TEXT" + ")";
        db.execSQL(CREATE_FOODSTALL_TABLE);
        //create review table
        String CREATE_REVIEW_TABLE = "create table " + REVIEW +"(" + COLUMN_REVIEW_ID + "\t INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_REVIEW_DESCRIPTION +"\t TEXT," + COLUMN_REVIEW_SCORE +"\t FLOAT" +")";
        db.execSQL(CREATE_REVIEW_TABLE);

        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")"  + "VALUES" +"(" + "Foodclub" + "," + 0 + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")"  + "VALUES" +"(" + "MakanPlace" + "," + 0 + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")"  + "VALUES" +"(" + "Munch" + "," + 0 + ")");
        db.execSQL("INSERT INTO FOODCOURT (" + COLUMN_COURT_NAME+ "," + COLUMN_COURT_PICTURE + ")"  + "VALUES" +"(" + "Poolside" + "," + 0 + ")");

        db.execSQL("INSERT INTO FOODSTALL (" + COLUMN_STALL_NAME + "," + COLUMN_COURT_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + "FriedMasterChicken" + "," + 0 + "," + "Chickies" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" + COLUMN_STALL_NAME + "," + COLUMN_COURT_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + "Western" + "," + 0 + "," + "ChickenChop" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" + COLUMN_STALL_NAME + "," + COLUMN_COURT_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + "MalayFood" + "," + 0 + "," + "NasiLemak" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" + COLUMN_STALL_NAME + "," + COLUMN_COURT_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + "MalaHotpot" + "," + 0 + "," + "Mala" + ")");
        db.execSQL("INSERT INTO FOODSTALL (" + COLUMN_STALL_NAME + "," + COLUMN_COURT_PICTURE + "," + COLUMN_STALL_DESCRIPTION+ ") VALUES" + "(" + "Japanese" + "," + 0 + "," + "HotPlate" + ")");

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


    public boolean insertStall(int StallID,String StallName,String StallDesc,double StallScore)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STALL_ID,StallID);
        contentValues.put(COLUMN_STALL_NAME,StallName);
        contentValues.put(COLUMN_STALL_DESCRIPTION,StallDesc);
        contentValues.put(COLUMN_STALL_SCORE,StallScore);
        long result = db.insert(FOODSTALL,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;

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

